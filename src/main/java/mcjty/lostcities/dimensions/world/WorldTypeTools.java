package mcjty.lostcities.dimensions.world;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mcjty.lostcities.LostCities;
import mcjty.lostcities.config.LostCityConfiguration;
import mcjty.lostcities.config.LostCityProfile;
import mcjty.lostcities.dimensions.ModDimensions;
import mcjty.lostcities.network.PacketHandler;
import mcjty.lostcities.network.PacketRequestProfile;
import mcjty.lostcities.network.PacketReturnProfileToClient;
import mcjty.lostcities.profile.ProfileRegistry;
import mcjty.lostcities.varia.JsonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class WorldTypeTools {

    // To prevent the client from asking the profile to the server too much
    private static long clientTimeout = -1;
    // A map which maps dimension id to the profile
    private static Map<Integer, LostCityProfile> profileMap = new HashMap<>();
    
    public static void cleanCache() {
        profileMap.clear();
        clientTimeout = -1;
    }
    
    // Client Receive Server Response
    // Called client side when we get an answer from the server about our profile
    public static void setProfileFromServer(int dimension, LostCityProfile profile) {
    	LostCities.logger.info("Responding Profile {} from server at dim {}",profile.getName(),dimension);
        profileMap.put(dimension, profile);
    }
    
    // Server receive Client request
    public static void getProfileFromClient(EntityPlayerMP p1,int p2) {
    	World v1=DimensionManager.getWorld(p2);
    	if(null==v1||v1.isRemote) {
    		LostCities.logger.error("Invalid packet sent from remote!!! {} {}",p2,p1.getName());
    		return;
    	}
    	LostCityProfile v2=null;
    	if(LostCityConfiguration.UNMANAGED_PROFILE_TO_CLIENT) {
    		v2=getProfile(v1);
    	}else if(ModDimensions.dimensionProfileMap.containsKey(p2)){
    		v2=ProfileRegistry.getLocalProfileByName(ModDimensions.dimensionProfileMap.get(p2));
    	}else {
    		v2=ProfileRegistry.getLocalProfileByName(LostCityConfiguration.DEFAULT_PROFILE);
    	}
    	LostCities.logger.info("Responding Profile {} for player {} at dim {}",v2.getName(),p1.getName(),p2);
    	PacketHandler.INSTANCE.sendTo(new PacketReturnProfileToClient(p2,v2),p1);
    }
    
    public static LostCityProfile getProfile(World world) {
        if (profileMap.containsKey(world.provider.getDimension())) {
            return profileMap.get(world.provider.getDimension());
        }

        if (!world.isRemote) {
            LostCityProfile profile = getProfileOnServer(world);
            profileMap.put(world.provider.getDimension(), profile);
            return profile;
        } else {
            // We don't know the information yet so we ask the server. We set a timeout to make sure this
            // message is not sent all the time
            long time = System.currentTimeMillis();
            if (clientTimeout == -1 || clientTimeout + 2000 > time) {
                PacketHandler.INSTANCE.sendToServer(new PacketRequestProfile(world.provider.getDimension()));
                clientTimeout = time;
            }
            if (ModDimensions.dimensionProfileMap.keySet().contains(world.provider.getDimension())) {
                // Don't put in cache because we might want to ask again
                return ProfileRegistry.getLocalProfileByName(ModDimensions.dimensionProfileMap.get(world.provider.getDimension()));
            } else {
                // Don't put in cache because we might want to ask again
            	return ProfileRegistry.getLocalProfileByName(LostCityConfiguration.DEFAULT_PROFILE);
            }
        }
    }
    
    private static LostCityProfile getProfileOnServer(World world) {
        if (ModDimensions.dimensionProfileMap.containsKey(world.provider.getDimension())) {
            LostCityProfile profile = ProfileRegistry.getLocalProfileByName(ModDimensions.dimensionProfileMap.get(world.provider.getDimension()));
            if (profile != null) {
                return profile;
            }
        }
        
        {
        	String generatorOptions = world.getWorldInfo().getGeneratorOptions();
        	if(null!=generatorOptions&&(!generatorOptions.trim().isEmpty())) {
	       		JsonObject json=JsonUtil.json.fromJson(generatorOptions,JsonObject.class);
	        	if(json instanceof JsonObject) {
	       			JsonElement pv=null;
	        		if(json.has(LostCities.CHUNK_GENERATOR_TAG)) {
	        			pv=json.get(LostCities.CHUNK_GENERATOR_TAG);
	        		}else if (json.has("profile")) {
	       				pv=json.get("profile");
	        		}
	       			if(null!=pv) {
	        			if(pv.isJsonPrimitive()) {
		       				LostCityProfile p=ProfileRegistry.getLocalProfileByName(pv.getAsString());
		       				if(null!=p) {
		        				return p;
		        			}
	        			}
	        			if(pv.isJsonObject()) {
	        				LostCityProfile p=new LostCityProfile();
	        				p.fromJsonDeserialize((JsonObject) pv);
	        				return p;
	        			}
	        		}
	        	}
        	}
        }
        LostCities.logger.error("Error while detect the profile on local side for dim {}",world.provider.getDimension());
        return ProfileRegistry.getLocalProfileByName(LostCityConfiguration.DEFAULT_PROFILE);
    }
// ================================================================
    // This map is constructed dynamically to allow having to avoid having an instanceof
    // on LostCityChunkGenerator which breaks on sponge
    private static Map<Integer, WeakReference<LostCityChunkGenerator>> chunkGeneratorMap = new HashMap<>();

    public static void cleanChunkGeneratorMap() {
        chunkGeneratorMap.clear();
    }
    
    public static void registerChunkGenerator(Integer dimension, LostCityChunkGenerator chunkGenerator) {
        chunkGeneratorMap.put(dimension, new WeakReference<LostCityChunkGenerator>(chunkGenerator));
    }
    
    @Nullable
    public static LostCityChunkGenerator getChunkGenerator(int dimension) {
        if (chunkGeneratorMap.containsKey(dimension)) {
            WeakReference<LostCityChunkGenerator> reference = chunkGeneratorMap.get(dimension);
            return reference.get();
        }
        return null;
    }
    
    /**
     * If possible return the LostCityChunkGenerator that belongs to this world. Return
     * null if it is not a Lost City world
     */
    @Nullable
    public static LostCityChunkGenerator getLostCityChunkGenerator(World world) {
        return getChunkGenerator(world.provider.getDimension());
//        WorldServer worldServer = (WorldServer) world;
//        IChunkGenerator chunkGenerator = worldServer.getChunkProvider().chunkGenerator;
//        // @todo not compatible with Sponge! No clue how to solve atm
//        // XXX
//        if (!(chunkGenerator instanceof LostCityChunkGenerator)) {
//            return null;
//        }
//        return (LostCityChunkGenerator) chunkGenerator;
    }
 // ================================================================

    public static boolean isLostCities(World world) {
        if (ModDimensions.dimensionProfileMap.containsKey(world.provider.getDimension())) {
            return true;
        }
        if (world.provider.getDimension() != 0) {
            return false;
        }
        return world.getWorldType() instanceof LostWorldType || world.getWorldType() instanceof LostWorldTypeBOP;
    }

}
