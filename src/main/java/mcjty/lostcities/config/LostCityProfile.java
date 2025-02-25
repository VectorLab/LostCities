
package mcjty.lostcities.config;
/* Not move to "profile" for legacy */
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;

import mcjty.lostcities.LostCities;
import mcjty.lostcities.varia.JsonUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class LostCityProfile {

    public static final String CATEGORY_LOSTCITY = "lostcity";
    public static final String CATEGORY_STRUCTURES = "structures";
    public static final String CATEGORY_EXPLOSIONS = "explosions";
    public static final String CATEGORY_CITIES = "cities";
    public static final String CATEGORY_CITY_SPHERES = "cityspheres";
    public static final String CATEGORY_CLIENT = "client";
    public static final String CATEGORY_BASEINFO = "baseinfo";

    private String name;
    private boolean isPublic;

    private String description = "Default generation, common cities, explosions";
    private String extraDescription = "";
    private String worldStyle = "standard";
    
    private String iconFile = "";
    private ResourceLocation icon;

    public int DEBRIS_TO_NEARBYCHUNK_FACTOR = 200;

    private String LIQUID_BLOCK = "minecraft:water";
    private IBlockState liquidBlock = null;

    private String BASE_BLOCK = "minecraft:stone";
    private IBlockState baseBlock = null;

    public float VINE_CHANCE = 0.009f;
    public float CHANCE_OF_RANDOM_LEAFBLOCKS = .1f;
    public int THICKNESS_OF_RANDOM_LEAFBLOCKS = 2;
    public boolean AVOID_FOLIAGE = false;
    public boolean AVOID_GENERATED_FLOWERS = false;
    public boolean AVOID_GENERATED_MUSHROOMS = false;
    public boolean AVOID_GENERATED_REEDS = false;
    public boolean AVOID_GENERATED_LILYPADS = false;
    public boolean AVOID_GENERATED_GRASS = false;
    public boolean AVOID_GENERATED_PUMPKINS = false;
    public boolean AVOID_GENERATED_CACTII = false;
    public boolean AVOID_GENERATED_TREES = false;
    public boolean AVOID_GENERATED_LAKE_WATER = false;
    public boolean AVOID_GENERATED_DESERT_WELL = false;
    public boolean AVOID_GENERATED_FOSSILS = false;

    public boolean RUBBLELAYER = true;
    public float RUBBLE_DIRT_SCALE = 3.0f;
    public float RUBBLE_LEAVE_SCALE = 6.0f;

    public boolean RUINS = true;
    public float RUIN_CHANCE = 0.05f;
    public float RUIN_MINLEVEL_PERCENT = 0.8f;
    public float RUIN_MAXLEVEL_PERCENT = 1.0f;

    public int GROUNDLEVEL = 71;
    public int WATERLEVEL_OFFSET = 8;

    public boolean HIGHWAY_REQUIRES_TWO_CITIES = true;
    public int HIGHWAY_LEVEL_FROM_CITIES_MODE = 0;
    public float HIGHWAY_MAINPERLIN_SCALE = 50.0f;
    public float HIGHWAY_SECONDARYPERLIN_SCALE = 10.0f;
    public float HIGHWAY_PERLIN_FACTOR = 2.0f;
    public int HIGHWAY_DISTANCE_MASK = 7;
    public boolean HIGHWAY_SUPPORTS = true;

    public float RAILWAY_DUNGEON_CHANCE = .01f;
    public boolean RAILWAYS_CAN_END = false;
    public boolean RAILWAYS_ENABLED = true;
    public boolean RAILWAY_STATIONS_ENABLED = true;

    public float DESTROY_LONE_BLOCKS_FACTOR = .05f;
    public float DESTROY_OR_MOVE_CHANCE = .4f;
    public int DESTROY_SMALL_SECTIONS_SIZE = 50;
    public boolean EXPLOSIONS_IN_CITIES_ONLY = true;

    public boolean GENERATE_SPAWNERS = true;
    public boolean GENERATE_LOOT = true;
    public boolean GENERATE_LIGHTING = false;
    public boolean AVOID_WATER = false;

    public float EXPLOSION_CHANCE = .002f;
    public int EXPLOSION_MINRADIUS = 15;
    public int EXPLOSION_MAXRADIUS = 35;
    public int EXPLOSION_MINHEIGHT = 75;
    public int EXPLOSION_MAXHEIGHT = 90;

    public float MINI_EXPLOSION_CHANCE = .03f;
    public int MINI_EXPLOSION_MINRADIUS = 5;
    public int MINI_EXPLOSION_MAXRADIUS = 12;
    public int MINI_EXPLOSION_MINHEIGHT = 60;
    public int MINI_EXPLOSION_MAXHEIGHT = 100;

    public float CITY_CHANCE = .02f;
    public int CITY_MINRADIUS = 50;
    public int CITY_MAXRADIUS = 128;
    public float CITY_THRESSHOLD = .2f;

    public float CITYSPHERE_FACTOR = 1.2f;
    public float CITYSPHERE_CHANCE = 0.7f;
    public float CITYSPHERE_SURFACE_VARIATION = 1.0f;
    public float CITYSPHERE_OUTSIDE_SURFACE_VARIATION = 1.0f;
    public float CITYSPHERE_MONORAIL_CHANCE = 0.8f;

    public int CITYSPHERE_OUTSIDE_GROUNDLEVEL = -1; // DEPRECATED

    public boolean CITYSPHERE_LANDSCAPE_OUTSIDE = false;
    public String CITYSPHERE_OUTSIDE_PROFILE = "";
    public boolean CITYSPHERE_ONLY_PREDEFINED = false;
    public int CITYSPHERE_MONORAIL_HEIGHT_OFFSET = -2;
    public boolean CITYSPHERE_SINGLE_BIOME = false;

    public int CITY_LEVEL0_HEIGHT = 75;
    public int CITY_LEVEL1_HEIGHT = 83;
    public int CITY_LEVEL2_HEIGHT = 91;
    public int CITY_LEVEL3_HEIGHT = 99;

    public Float CITY_DEFAULT_BIOME_FACTOR = 1.0f;
    
    public String[] CITY_BIOME_FACTORS = new String[] { "river=0", "frozen_river=0", "ocean=.7", "frozen_ocean=.7", "deep_ocean=.4" };
    public Map<String, Float> biomeFactorMap = null;

    public String GENERATOR_OPTIONS = "";

    public String[] ALLOWED_BIOME_FACTORS = new String[] { };
    public String[] MANUAL_BIOME_MAPPINGS = new String[] { };
    public BiomeSelectionStrategy BIOME_SELECTION_STRATEGY = BiomeSelectionStrategy.ORIGINAL;

    public float CHEST_WITHOUT_LOOT_CHANCE = .2f;
    public float BUILDING_WITHOUT_LOOT_CHANCE = .2f;
    public float BUILDING_CHANCE = .3f;
    public int BUILDING_MINFLOORS = 0;
    public int BUILDING_MAXFLOORS = 9;
    public int BUILDING_MINFLOORS_CHANCE = 4;
    public int BUILDING_MAXFLOORS_CHANCE = 6;
    public int BUILDING_MINCELLARS = 0;
    public int BUILDING_MAXCELLARS = 4;
    public float BUILDING_DOORWAYCHANCE = .6f;
    public float BUILDING_FRONTCHANCE = .2f;
    public float LIBRARY_CHANCE = .1f;
    public float DATACENTER_CHANCE = .1f;
    public float PARK_CHANCE = .2f;

    public float CORRIDOR_CHANCE = .7f;
    public float BRIDGE_CHANCE = .7f;
    public float FOUNTAIN_CHANCE = .05f;
    public float BUILDING2X2_CHANCE = .03f;
    public boolean BRIDGE_SUPPORTS = true;

    public int BEDROCK_LAYER = 1;

    public boolean GENERATE_VILLAGES = true;
    public boolean GENERATE_CAVES = true;
    public boolean GENERATE_RAVINES = true;
    public boolean GENERATE_MINESHAFTS = true;
    public boolean GENERATE_STRONGHOLDS = true;
    public boolean GENERATE_SCATTERED = true;
    public boolean GENERATE_OCEANMONUMENTS = true;
    public boolean GENERATE_MANSIONS = true;
    public boolean GENERATE_LAKES = true;
    public boolean GENERATE_DUNGEONS = true;

    public float HORIZON = -1f;
    public float FOG_RED = -1.0f;
    public float FOG_GREEN = -1.0f;
    public float FOG_BLUE = -1.0f;
    public float FOG_DENSITY = -1.0f;

    public String SPAWN_BIOME = "";
    public String SPAWN_CITY = "";
    public String SPAWN_SPHERE = "";
    public boolean SPAWN_NOT_IN_BUILDING = false;

    public int MAX_CAVE_HEIGHT = 128;

    public LandscapeType LANDSCAPE_TYPE = LandscapeType.DEFAULT;

    public boolean PREVENT_VILLAGES_IN_CITIES = true;
    public boolean PREVENT_LAKES_RAVINES_IN_CITIES = false;

    public LostCityProfile() {}
    
	public LostCityProfile(String name, boolean isPublic) {
        this.name = name;
        //this.inheritFrom = Optional.empty();
        this.isPublic = isPublic;
    }
/*
    public LostCityProfile(String name, LostCityProfile inheritFrom, boolean isPublic) {
        this.name = name;
        this.inheritFrom = Optional.ofNullable(inheritFrom);
        this.isPublic = isPublic;
    }
*/
    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }

    public ResourceLocation getIcon() {
        if (icon != null) {
            return icon;
        }
        if (iconFile == null || iconFile.isEmpty()) {
            return null;
        }
        icon = new ResourceLocation(LostCities.MODID, iconFile);
        return icon;
    }

    public boolean isPublic() {
        return isPublic;
    }
/*
    public String getCategoryCitySpheres() {
        return categoryCitySpheres;
    }

    public String getCategoryLostcity() {
        return categoryLostcity;
    }
*/
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public void setWorldStyle(String worldStyle) {
        this.worldStyle = worldStyle;
    }

    public String getWorldStyle() {
        return worldStyle;
    }

    public Map<String, Float> getBiomeFactorMap() {
        if (biomeFactorMap == null) {
            biomeFactorMap = new HashMap<>();
            for (String s : CITY_BIOME_FACTORS) {
                String[] split = StringUtils.split(s, '=');
                if (split.length < 2) {
                    LostCities.setup.getLogger().error("Badly specified biome factor. Must be <biome>=<factor>!");
                } else {
                    float f = Float.parseFloat(split[1]);
                    String biomeId = split[0];
                    Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeId));
                    if (biome != null) {
                        biomeFactorMap.put(Biome.REGISTRY.getNameForObject(biome).toString(), f);
                    }
                }
            }
        }
        return biomeFactorMap;
    }

    public boolean isDefault() {
        return LANDSCAPE_TYPE == LandscapeType.DEFAULT;
    }

    public boolean isFloating() {
        return LANDSCAPE_TYPE == LandscapeType.FLOATING;
    }

    public boolean isSpace() {
        return LANDSCAPE_TYPE == LandscapeType.SPACE;
    }

    public boolean isCavern() {
    	return LANDSCAPE_TYPE == LandscapeType.CAVERN;
    }

    public IBlockState getLiquidBlock() {
        if (liquidBlock == null) {
            Block b = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(LIQUID_BLOCK));
            if (b == null) {
                LostCities.setup.getLogger().error("Bad liquid block: " + LIQUID_BLOCK + "!");
                liquidBlock = Blocks.WATER.getDefaultState();
            } else {
                liquidBlock = b.getDefaultState();
            }
        }
        return liquidBlock;
    }

    public IBlockState getBaseBlock() {
        if (baseBlock == null) {
            Block b = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(BASE_BLOCK));
            if (b == null) {
                LostCities.setup.getLogger().error("Bad base block: " + BASE_BLOCK + "!");
                baseBlock = Blocks.STONE.getDefaultState();
            } else {
                baseBlock = b.getDefaultState();
            }
        }
        return baseBlock;
    }

/* 
end of function area
================================================================
Profile (Template) Builder
Classic configure builder
String name, LostCityProfile inheritFrom, boolean isPublic
when null==p3_cfg, p4_inheritFrom is useless
*/
    public void initLegacy(String p1_name,boolean p2_isPublic,Configuration p3_cfg,LostCityProfile p4_inheritFrom) {
    	this.name=p1_name;
    	this.isPublic=p2_isPublic;

    	if(null==p3_cfg){
    		return;
    	}
    	Configuration cfg=p3_cfg;
    	
    	Optional<LostCityProfile> inheritFrom;
    	if(null==p4_inheritFrom) {
    		inheritFrom=Optional.empty();
    	}else {
    		inheritFrom=Optional.empty();
    	}
    	
        // private void initLostcity(Configuration cfg) 
        {
            String categoryLostcity;
            categoryLostcity = LostCityProfile.CATEGORY_LOSTCITY + "_" + name;
            cfg.addCustomCategoryComment(categoryLostcity, "Settings related to the Lost City for the " + name + " profile");
            
            description = cfg.getString("description", categoryLostcity, inheritFrom.orElse(this).description, "The description of this profile");
            extraDescription = cfg.getString("extraDescription", categoryLostcity, inheritFrom.orElse(this).extraDescription, "Additional information");
            worldStyle = cfg.getString("worldStyle", categoryLostcity, inheritFrom.orElse(this).worldStyle, "The worldstyle used by this profile (defined in the assets)");
            iconFile = cfg.getString("icon", categoryLostcity, inheritFrom.orElse(this).iconFile, "The icon to use in the configuration screen (64x64)");

            LIQUID_BLOCK = cfg.getString("liquidBlock", categoryLostcity, inheritFrom.orElse(this).LIQUID_BLOCK, "Block to use as a liquid");
            BASE_BLOCK = cfg.getString("baseBlock", categoryLostcity, inheritFrom.orElse(this).BASE_BLOCK, "Block to use as the worldgen base");

            SPAWN_BIOME = cfg.getString("spawnBiome", categoryLostcity, inheritFrom.orElse(this).SPAWN_BIOME, "When this is set the player will always spawn in the given biome");
            SPAWN_CITY = cfg.getString("spawnCity", categoryLostcity, inheritFrom.orElse(this).SPAWN_CITY, "When this is set the player will always spawn in the given predefined city");
            SPAWN_SPHERE = cfg.getString("spawnSphere", categoryLostcity, inheritFrom.orElse(this).SPAWN_SPHERE, "When this is set the player will always spawn in the given predefined sphere. If you use <in> the player will always spawn in a random sphere. If you use <out> the player will always spawn outside a sphere");
            SPAWN_NOT_IN_BUILDING = cfg.getBoolean("spawnNotInBuilding", categoryLostcity, inheritFrom.orElse(this).SPAWN_NOT_IN_BUILDING, "If this is true the player will not spawn in a building. This can be used in combination with the other spawn settings");

            VINE_CHANCE = cfg.getFloat("vineChance", categoryLostcity, inheritFrom.orElse(this).VINE_CHANCE, 0.0f, 1.0f, "The chance that a block on the outside of a building will be covered with a vine");
            CHANCE_OF_RANDOM_LEAFBLOCKS = cfg.getFloat("randomLeafBlockChance", categoryLostcity, inheritFrom.orElse(this).CHANCE_OF_RANDOM_LEAFBLOCKS, 0.0f, 1.0f, "Chance that leafblocks will be generated at the border of a building and a street");
            THICKNESS_OF_RANDOM_LEAFBLOCKS = cfg.getInt("randomLeafBlockThickness", categoryLostcity, inheritFrom.orElse(this).THICKNESS_OF_RANDOM_LEAFBLOCKS, 1, 8,
                    "Frequency of leafblocks as seen from the sides of buildings");
            AVOID_FOLIAGE = cfg.getBoolean("avoidFoliage", categoryLostcity, inheritFrom.orElse(this).AVOID_FOLIAGE,
                    "If this is true then parks will have no foliage (trees and flowers currently)");
            AVOID_GENERATED_CACTII = cfg.getBoolean("avoidGeneratedCactii", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_CACTII,
                    "This will prevent biomes from generating cactii");
            AVOID_GENERATED_FLOWERS = cfg.getBoolean("avoidGeneratedFlowers", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_FLOWERS,
                    "This will prevent biomes from generating flowers");
            AVOID_GENERATED_GRASS = cfg.getBoolean("avoidGeneratedGrass", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_GRASS,
                    "This will prevent biomes from generating grass");
            AVOID_GENERATED_PUMPKINS = cfg.getBoolean("avoidGeneratedPumpkins", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_PUMPKINS,
                    "This will prevent biomes from generating pumpkins");
            AVOID_GENERATED_LILYPADS = cfg.getBoolean("avoidGeneratedLilypads", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_LILYPADS,
                    "This will prevent biomes from generating lilypads");
            AVOID_GENERATED_REEDS = cfg.getBoolean("avoidGeneratedReeds", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_REEDS,
                    "This will prevent biomes from generating reeds");
            AVOID_GENERATED_TREES = cfg.getBoolean("avoidGeneratedTrees", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_TREES,
                    "This will prevent biomes from generating trees");
            AVOID_GENERATED_MUSHROOMS = cfg.getBoolean("avoidGeneratedMushrooms", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_MUSHROOMS,
                    "This will prevent biomes from generating mushrooms");
            AVOID_GENERATED_LAKE_WATER = cfg.getBoolean("avoidGeneratedLakewater", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_LAKE_WATER,
                    "This will prevent the generation of water in lakes");
            AVOID_GENERATED_DESERT_WELL = cfg.getBoolean("avoidGeneratedDesertWell", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_DESERT_WELL,
                    "This will prevent the generation of desert wells");
            AVOID_GENERATED_FOSSILS = cfg.getBoolean("avoidGeneratedFossils", categoryLostcity, inheritFrom.orElse(this).AVOID_GENERATED_FOSSILS,
                    "This will prevent the generation of fossils");

            {
    	        String type = cfg.getString("landscapeType", categoryLostcity, inheritFrom.orElse(this).LANDSCAPE_TYPE.getName(),
    	                "Type of landscape",
    	                new String[] {
    	                        LandscapeType.DEFAULT.getName(),
    	                        LandscapeType.FLOATING.getName(),
    	                        LandscapeType.SPACE.getName(),
    	                        LandscapeType.CAVERN.getName() });
    	        LANDSCAPE_TYPE = LandscapeType.getTypeByName(type);
    	        if (LANDSCAPE_TYPE == null) {
    	            throw new RuntimeException("Bad landscape type: " + type + "!");
    	        }
            }

            RUBBLELAYER = cfg.getBoolean("rubbleLayer", categoryLostcity, inheritFrom.orElse(this).RUBBLELAYER,
                    "If this is true an alternative way to generate dirt/stone/sand + leave blocks is used that makes the city appear more overgrown");
            RUBBLE_DIRT_SCALE = cfg.getFloat("rubbleDirtScale", categoryLostcity, inheritFrom.orElse(this).RUBBLE_DIRT_SCALE, 0.0f, 100.0f,
                    "The scale of the dirt layer. Smaller values make the layer larger. Use 0 to disable");
            RUBBLE_LEAVE_SCALE = cfg.getFloat("rubbleLeaveScale", categoryLostcity, inheritFrom.orElse(this).RUBBLE_LEAVE_SCALE, 0.0f, 100.0f,
                    "The scale of the leave layer. Smaller values make the layer larger. Use 0 to disable");

            RUINS = cfg.getBoolean("ruins", categoryLostcity, inheritFrom.orElse(this).RUINS,
                    "If true there is a chance a building is ruined from the top (not caused by explosion damage)");
            RUIN_CHANCE = cfg.getFloat("ruinChance", categoryLostcity, inheritFrom.orElse(this).RUIN_CHANCE, 0.0f, 1.0f,
                    "If ruines are enabled this gives the chance that a building is ruined");
            RUIN_MINLEVEL_PERCENT = cfg.getFloat("ruinMinlevelPercent", categoryLostcity, inheritFrom.orElse(this).RUIN_MINLEVEL_PERCENT, 0.0f, 1.0f,
                    "If a building is ruined this indicates the minimum start height for the ruin destruction layer");
            RUIN_MAXLEVEL_PERCENT = cfg.getFloat("ruinMaxlevelPercent", categoryLostcity, inheritFrom.orElse(this).RUIN_MAXLEVEL_PERCENT, 0.0f, 1.0f,
                    "If a building is ruined this indicates the maximum start height for the ruin destruction layer");

            GROUNDLEVEL = cfg.getInt("groundLevel", categoryLostcity, inheritFrom.orElse(this).GROUNDLEVEL, 2, 256, "Ground level");
            WATERLEVEL_OFFSET = cfg.getInt("waterLevelOffset", categoryLostcity, inheritFrom.orElse(this).WATERLEVEL_OFFSET, -100, 100, "How much lower the water level is compared to the ground level (63)");


            CHEST_WITHOUT_LOOT_CHANCE = cfg.getFloat("chestWithoutLootChance", categoryLostcity, inheritFrom.orElse(this).CHEST_WITHOUT_LOOT_CHANCE, 0.0f, 1.0f, "The chance that a chest will have no loot");
            BUILDING_WITHOUT_LOOT_CHANCE = cfg.getFloat("buildingWithoutLootChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_WITHOUT_LOOT_CHANCE, 0.0f, 1.0f, "The chance that a building will have no loot and no spawners");
            BUILDING_CHANCE = cfg.getFloat("buildingChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_CHANCE, 0.0f, 1.0f, "The chance that a chunk in a city will have a building. Otherwise it will be a street");
            BUILDING_MINFLOORS = cfg.getInt("buildingMinFloors", categoryLostcity, inheritFrom.orElse(this).BUILDING_MINFLOORS, 0, 30, "The minimum number of floors (above ground) for a building (0 means the first floor only)");
            BUILDING_MAXFLOORS = cfg.getInt("buildingMaxFloors", categoryLostcity, inheritFrom.orElse(this).BUILDING_MAXFLOORS, 0, 30, "A cap for the amount of floors a city can have (above ground)");
            BUILDING_MINFLOORS_CHANCE = cfg.getInt("buildingMinFloorsChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_MINFLOORS_CHANCE, 1, 30, "The amount of floors of a building is equal to: " +
                    "MINFLOORS + random(MINFLOORS_CHANCE + (cityFactor + .1f) * (MAXFLOORS_CHANCE - MINFLOORS_CHANCE))");
            BUILDING_MAXFLOORS_CHANCE = cfg.getInt("buildingMaxFloorsChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_MAXFLOORS_CHANCE, 1, 30, "The amount of floors of a building is equal to: " +
                    "MINFLOORS + random(MINFLOORS_CHANCE + (cityFactor + .1f) * (MAXFLOORS_CHANCE - MINFLOORS_CHANCE))");

            BUILDING_MINCELLARS = cfg.getInt("buildingMinCellars", categoryLostcity, inheritFrom.orElse(this).BUILDING_MINCELLARS, 0, 7, "The minimum number of cellars (below ground). 0 means no cellar");
            BUILDING_MAXCELLARS = cfg.getInt("buildingMaxCellars", categoryLostcity, inheritFrom.orElse(this).BUILDING_MAXCELLARS, 0, 7, "The maximum number of cellars (below ground). 0 means no cellar");
            BUILDING_DOORWAYCHANCE = cfg.getFloat("buildingDoorwayChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_DOORWAYCHANCE, 0.0f, 1.0f, "The chance that a doorway will be generated at a side of a building (on any level). Only when possible");
            BUILDING_FRONTCHANCE = cfg.getFloat("buildingFrontChance", categoryLostcity, inheritFrom.orElse(this).BUILDING_FRONTCHANCE, 0.0f, 1.0f, "The chance that a building will have a 'front' part if this is possible (i.e. adjacent street)");
            LIBRARY_CHANCE = cfg.getFloat("libraryChance", categoryLostcity, inheritFrom.orElse(this).LIBRARY_CHANCE, 0.0f, 1.0f, "The chance that a 2x2 building will be a library");
            DATACENTER_CHANCE = cfg.getFloat("dataCenterChance", categoryLostcity, inheritFrom.orElse(this).DATACENTER_CHANCE, 0.0f, 1.0f, "The chance that a 2x2 building will be a data center");
            PARK_CHANCE = cfg.getFloat("parkChance", categoryLostcity, inheritFrom.orElse(this).PARK_CHANCE, 0.0f, 1.0f, "The chance that a non-building section can be a park section");

            BUILDING2X2_CHANCE = cfg.getFloat("building2x2Chance", categoryLostcity, inheritFrom.orElse(this).BUILDING2X2_CHANCE, 0.0f, 1.0f, "The chance that a chunk can possibly be the top-left chunk of 2x2 building. " +
                    "There actually being a 2x2 building also depends on the condition of those other chunks");
            CORRIDOR_CHANCE = cfg.getFloat("corridorChance", categoryLostcity, inheritFrom.orElse(this).CORRIDOR_CHANCE, 0.0f, 1.0f, "The chance that a chunk can possibly contain a corridor. " +
                    "There actually being a corridor also depends on the presence of adjacent corridors");
            BRIDGE_CHANCE = cfg.getFloat("bridgeChance", categoryLostcity, inheritFrom.orElse(this).BRIDGE_CHANCE, 0.0f, 1.0f, "The chance that a chunk can possibly contain a bridge. " +
                    "There actually being a bridge also depends on the presence of adjacent bridges and other conditions");
            BRIDGE_SUPPORTS = cfg.getBoolean("bridgeSupports", categoryLostcity, inheritFrom.orElse(this).BRIDGE_SUPPORTS,
                    "If true bridges get supports when needed. You can disable this if you have bridges that span void chunks");

            FOUNTAIN_CHANCE = cfg.getFloat("fountainChance", categoryLostcity, inheritFrom.orElse(this).FOUNTAIN_CHANCE, 0.0f, 1.0f, "The chance that a street section contains a fountain");

            RAILWAY_DUNGEON_CHANCE = cfg.getFloat("railwayDungeonChance", categoryLostcity, inheritFrom.orElse(this).RAILWAY_DUNGEON_CHANCE, 0.0f, 1.0f,
                    "The chance that a chunk next to a railway will have a railway dungeon");
            RAILWAYS_CAN_END = cfg.getBoolean("railwaysCanEnd", categoryLostcity, inheritFrom.orElse(this).RAILWAYS_CAN_END,
                    "If true the a place where a station would have been if there was a city above will have an 'ending' rail part if one side of the 'station' has no connections. Useful in case cities are rare");
            RAILWAYS_ENABLED = cfg.getBoolean("railwaysEnabled", categoryLostcity, inheritFrom.orElse(this).RAILWAYS_ENABLED,
                    "If true then railways are enabled. If false they are not (but stations will still generate)");
            RAILWAY_STATIONS_ENABLED = cfg.getBoolean("railwayStationsEnabled", categoryLostcity, inheritFrom.orElse(this).RAILWAY_STATIONS_ENABLED,
                    "If true then railway stations are enabled");

            HIGHWAY_REQUIRES_TWO_CITIES = cfg.getBoolean("highwayRequiresTwoCities", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_REQUIRES_TWO_CITIES,
                    "If true then a highway will only generate if both sides have a valid city. If false then one city is sufficient");
            HIGHWAY_LEVEL_FROM_CITIES_MODE = cfg.getInt("highwayLevelFromCities", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_LEVEL_FROM_CITIES_MODE,
                    0, 3, "0 (take height from top-left city), 1 (take minimum height from both cities), 2 (take maximum height from both cities), 3 (take average height)");
            HIGHWAY_DISTANCE_MASK = cfg.getInt("highwayDistanceMask", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_DISTANCE_MASK,
                    0, Integer.MAX_VALUE, "Mask to control how far highways can generate. Must be a power of 2 (minus 1). If 0 there are no highways at all");
            HIGHWAY_MAINPERLIN_SCALE = cfg.getFloat("highwayMainPerlinScale", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_MAINPERLIN_SCALE, 1.0f, 1000.0f,
                    "For highways on a certain axis, this value is used to scale the perlin noise generator on the main axis. Increasing this value will increase the frequency of highways but make them smaller");
            HIGHWAY_SECONDARYPERLIN_SCALE = cfg.getFloat("highwaySecondaryPerlinScale", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_SECONDARYPERLIN_SCALE, 1.0f, 1000.0f,
                    "For highways on a certain axis, this value is used to scale the perlin noise generator on the secondary axis. Increasing this value will increase the variation of nearby highways");
            HIGHWAY_PERLIN_FACTOR = cfg.getFloat("highwayPerlinFactor", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_PERLIN_FACTOR, -100, 100,
                    "The highway perlin noise is compared to this value. Setting this to 0 would give 50% chance of a highway being at a spot. Note that highways only generate on chunks a multiple of 8. Setting this very high will prevent highways from generating");
            HIGHWAY_SUPPORTS = cfg.getBoolean("highwaySupports", categoryLostcity, inheritFrom.orElse(this).HIGHWAY_SUPPORTS,
                    "If true highways get supports when needed. You can disable this if you have highways that span void chunks");

            BEDROCK_LAYER = cfg.getInt("bedrockLayer", categoryLostcity, inheritFrom.orElse(this).BEDROCK_LAYER, 0, 10,
                    "The height of the bedrock layer that is generated at the bottom of some world types. Set to 0 to disable this and get default bedrock generation");

            GENERATE_SPAWNERS = cfg.getBoolean("generateSpawners", categoryLostcity, inheritFrom.orElse(this).GENERATE_SPAWNERS,
                    "If true then the buildings will be full of spawners");
            GENERATE_LOOT = cfg.getBoolean("generateLoot", categoryLostcity, inheritFrom.orElse(this).GENERATE_LOOT,
                    "If true the chests in the buildings will contain loot");
            GENERATE_LIGHTING = cfg.getBoolean("generateLighting", categoryLostcity, inheritFrom.orElse(this).GENERATE_LIGHTING,
                    "If true then there will be minimal lighting in the buildings");
            AVOID_WATER = cfg.getBoolean("avoidWater", categoryLostcity, inheritFrom.orElse(this).AVOID_WATER,
                    "If true then all water will be avoided (replaced with air)");

            ALLOWED_BIOME_FACTORS = cfg.getStringList("allowedBiomeFactors", categoryLostcity, inheritFrom.orElse(this).ALLOWED_BIOME_FACTORS,
                    "List of biomes that are allowed in the world. Empty list is default all biomes. The factor controls how much that biome is favored over the others (higher means less favored!)");
            MANUAL_BIOME_MAPPINGS = cfg.getStringList("manualBiomeMappings", categoryLostcity, inheritFrom.orElse(this).MANUAL_BIOME_MAPPINGS,
                    "Use in combination with 'allowedBiomeFactors' to manually map some biomes to others. This is a list of the format oldbiome=newbiome");

            {
    	        String biomeSelectionStrategy = cfg.getString("biomeSelectionStrategy", categoryLostcity, inheritFrom.orElse(this).BIOME_SELECTION_STRATEGY.getName(),
    	                "This is used in combination with allowedBiomeFactors. 'original' is the old strategy. 'randomized' is a new strategy that tries to randomize the biomes better. 'varied' is similar but has a more relaxed biome distance function",
    	                new String[] {
    	                        BiomeSelectionStrategy.ORIGINAL.getName(),
    	                        BiomeSelectionStrategy.RANDOMIZED.getName(),
    	                        BiomeSelectionStrategy.VARIED.getName()
    	                });
    	        BIOME_SELECTION_STRATEGY = BiomeSelectionStrategy.getTypeByName(biomeSelectionStrategy);
    	        if (BIOME_SELECTION_STRATEGY == null) {
    	            throw new RuntimeException("Bad biome selection strategy: " + biomeSelectionStrategy + "!");
    	        }
            }

            GENERATOR_OPTIONS = cfg.getString("generatorOptions", categoryLostcity, inheritFrom.orElse(this).GENERATOR_OPTIONS,
                    "A json with generator options for the chunk generator");
        }
        
        // private void initExplosions(Configuration cfg) 
        {
            String categoryExplosions;
            categoryExplosions = LostCityProfile.CATEGORY_EXPLOSIONS + "_" + name;
            cfg.addCustomCategoryComment(categoryExplosions, "Settings related to explosions and damage for the " + name + " profile");
            
            DEBRIS_TO_NEARBYCHUNK_FACTOR = cfg.getInt("debrisToNearbyChunkFactor", categoryExplosions, inheritFrom.orElse(this).DEBRIS_TO_NEARBYCHUNK_FACTOR, 1, 10000, "A factor that determines how much debris will overflow from nearby damaged chunks. Bigger numbers mean less debris");

            DESTROY_LONE_BLOCKS_FACTOR = cfg.getFloat("destroyLoneBlocksFactor", categoryExplosions, inheritFrom.orElse(this).DESTROY_LONE_BLOCKS_FACTOR, 0.0f, 1.0f, "When a section of blocks in in an explosion the generator will count the number of " +
                    "blocks that are connected. The number of connections divided by the total number of blocks in a connected section is compared with this number. " +
                    "If it is smaller then the section of blocks is destroyed or moved down with gravity");
            DESTROY_OR_MOVE_CHANCE = cfg.getFloat("destroyOrMoveChance", categoryExplosions, inheritFrom.orElse(this).DESTROY_OR_MOVE_CHANCE, 0.0f, 1.0f, "When a section of blocks is to be moved or destroyed " +
                    "this chance gives the chance of removal (as opposed to moving with gravity)");
            DESTROY_SMALL_SECTIONS_SIZE = cfg.getInt("destroySmallSectionsSize", categoryExplosions, inheritFrom.orElse(this).DESTROY_SMALL_SECTIONS_SIZE, 1, 5000, "A section of blocks that is about to be moved or destroyed " +
                    "is always destroyed if it is smaller then this size");

            EXPLOSION_CHANCE = cfg.getFloat("explosionChance", categoryExplosions, inheritFrom.orElse(this).EXPLOSION_CHANCE, 0.0f, 1.0f, "The chance that a chunk will contain an explosion");
            EXPLOSION_MINRADIUS = cfg.getInt("explosionMinRadius", categoryExplosions, inheritFrom.orElse(this).EXPLOSION_MINRADIUS, 1, 1000, "The minimum radius of an explosion");
            EXPLOSION_MAXRADIUS = cfg.getInt("explosionMaxRadius", categoryExplosions, inheritFrom.orElse(this).EXPLOSION_MAXRADIUS, 1, 3000, "The maximum radius of an explosion");
            EXPLOSION_MINHEIGHT = cfg.getInt("explosionMinHeight", categoryExplosions, inheritFrom.orElse(this).EXPLOSION_MINHEIGHT, 1, 256, "The minimum height of an explosion");
            EXPLOSION_MAXHEIGHT = cfg.getInt("explosionMaxHeight", categoryExplosions, inheritFrom.orElse(this).EXPLOSION_MAXHEIGHT, 1, 256, "The maximum height of an explosion");

            MINI_EXPLOSION_CHANCE = cfg.getFloat("miniExplosionChance", categoryExplosions, inheritFrom.orElse(this).MINI_EXPLOSION_CHANCE, 0.0f, 1.0f, "The chance that a chunk will contain a mini explosion");
            MINI_EXPLOSION_MINRADIUS = cfg.getInt("miniExplosionMinRadius", categoryExplosions, inheritFrom.orElse(this).MINI_EXPLOSION_MINRADIUS, 1, 1000, "The minimum radius of a mini explosion");
            MINI_EXPLOSION_MAXRADIUS = cfg.getInt("miniExplosionMaxRadius", categoryExplosions, inheritFrom.orElse(this).MINI_EXPLOSION_MAXRADIUS, 1, 3000, "The maximum radius of a mini explosion");
            MINI_EXPLOSION_MINHEIGHT = cfg.getInt("miniExplosionMinHeight", categoryExplosions, inheritFrom.orElse(this).MINI_EXPLOSION_MINHEIGHT, 1, 256, "The minimum height of a mini explosion");
            MINI_EXPLOSION_MAXHEIGHT = cfg.getInt("miniExplosionMaxHeight", categoryExplosions, inheritFrom.orElse(this).MINI_EXPLOSION_MAXHEIGHT, 1, 256, "The maximum height of a mini explosion");

            EXPLOSIONS_IN_CITIES_ONLY = cfg.getBoolean("explosionsInCitiesOnly", categoryExplosions, inheritFrom.orElse(this).EXPLOSIONS_IN_CITIES_ONLY,
                    "If this is true the center of an explosion can only be in a city (the blast can still affect non-city chunks)");
        }
        
        // private void initStructures(Configuration cfg) 
        {
            String categoryStructures;
            categoryStructures = LostCityProfile.CATEGORY_STRUCTURES + "_" + name;
            cfg.addCustomCategoryComment(categoryStructures, "Settings related to structure generation for the " + name + " profile");

            GENERATE_OCEANMONUMENTS = cfg.get(categoryStructures, "generateOceanMonuments", inheritFrom.orElse(this).GENERATE_OCEANMONUMENTS, "Generate ocean monuments").getBoolean();
            GENERATE_MANSIONS = cfg.get(categoryStructures, "generateMansions", inheritFrom.orElse(this).GENERATE_MANSIONS, "Generate mansions").getBoolean();
            GENERATE_SCATTERED = cfg.get(categoryStructures, "generateScattered", inheritFrom.orElse(this).GENERATE_SCATTERED, "Generate scattered features (swamphunts, desert temples, ...)").getBoolean();
            GENERATE_STRONGHOLDS = cfg.get(categoryStructures, "generateStrongholds", inheritFrom.orElse(this).GENERATE_STRONGHOLDS, "Generate strongholds").getBoolean();
            GENERATE_VILLAGES = cfg.get(categoryStructures, "generateVillages", inheritFrom.orElse(this).GENERATE_VILLAGES, "Generate villages").getBoolean();
            GENERATE_CAVES = cfg.get(categoryStructures, "generateCaves", inheritFrom.orElse(this).GENERATE_CAVES, "Generate caves").getBoolean();
            GENERATE_RAVINES = cfg.get(categoryStructures, "generateRavines", inheritFrom.orElse(this).GENERATE_RAVINES, "Generate ravines").getBoolean();
            GENERATE_MINESHAFTS = cfg.get(categoryStructures, "generateMineshafts", inheritFrom.orElse(this).GENERATE_MINESHAFTS, "Generate mineshafts").getBoolean();
            GENERATE_LAKES = cfg.get(categoryStructures, "generateLakes", inheritFrom.orElse(this).GENERATE_LAKES, "Generate lakes (lava/water)").getBoolean();
            GENERATE_DUNGEONS = cfg.get(categoryStructures, "generateDungeons", inheritFrom.orElse(this).GENERATE_DUNGEONS, "Generate dungeons").getBoolean();
            MAX_CAVE_HEIGHT = cfg.getInt(categoryStructures, "maxCaveHeight", inheritFrom.orElse(this).MAX_CAVE_HEIGHT, 20, 240, "Maximum height at which vanilla caves can generate. Default is 128. Lower this if you don't want the caves to damage buildings");

            PREVENT_VILLAGES_IN_CITIES = cfg.get(categoryStructures, "preventVillagesInCities", inheritFrom.orElse(this).PREVENT_VILLAGES_IN_CITIES, "If true then an attempt will be made to prevent villages in cities. " +
                    "Note that enabling this option will likely require a low city " +
                    "density in order to actually get a reasonable chance for villages.").getBoolean();
            PREVENT_LAKES_RAVINES_IN_CITIES = cfg.get(categoryStructures, "preventLakesRavinesInCities", inheritFrom.orElse(this).PREVENT_LAKES_RAVINES_IN_CITIES,
                    "If true then no lakes and ravines will be generated in cities").getBoolean();
        }

        // private void initCities(Configuration cfg) 
        {
            String categoryCities;
            categoryCities = LostCityProfile.CATEGORY_CITIES + "_" + name;
            cfg.addCustomCategoryComment(categoryCities, "Settings related to city generation for the " + name + " profile");
            
            CITY_CHANCE = cfg.getFloat("cityChance", categoryCities, inheritFrom.orElse(this).CITY_CHANCE, 0.0f, 1.0f, "The chance this chunk will be the center of a city");
            CITY_MINRADIUS = cfg.getInt("cityMinRadius", categoryCities, inheritFrom.orElse(this).CITY_MINRADIUS, 1, 10000, "The minimum radius of a city");
            CITY_MAXRADIUS = cfg.getInt("cityMaxRadius", categoryCities, inheritFrom.orElse(this).CITY_MAXRADIUS, 1, 10000, "The maximum radius of a city");
            CITY_THRESSHOLD = cfg.getFloat("cityThresshold", categoryCities, inheritFrom.orElse(this).CITY_THRESSHOLD, 0.0f, 1.0f, "The center and radius of a city define a sphere. " +
                    "This thresshold indicates from which point a city is considered a city. " +
                    "This is important for calculating where cities are based on overlapping city circles (where the city thressholds are added)");
            CITY_BIOME_FACTORS = cfg.getStringList("cityBiomeFactors", categoryCities, inheritFrom.orElse(this).CITY_BIOME_FACTORS, "List of biomes with a factor to affect the city factor in that biome. Using the value 0 you can disable city generation in biomes");
            CITY_DEFAULT_BIOME_FACTOR = cfg.getFloat("cityBiomeFactorDefault", categoryCities, inheritFrom.orElse(this).CITY_DEFAULT_BIOME_FACTOR, 0.0f, 1.0f, "The default biome factor which is used if your biome is not specified in 'cityBiomeFactors'");

            CITY_LEVEL0_HEIGHT = cfg.getInt("cityLevel0Height", categoryCities, inheritFrom.orElse(this).CITY_LEVEL0_HEIGHT, 1, 255,
                    "Below this chunk height cities will be level 0");
            CITY_LEVEL1_HEIGHT = cfg.getInt("cityLevel1Height", categoryCities, inheritFrom.orElse(this).CITY_LEVEL1_HEIGHT, 1, 255,
                    "Below this chunk height cities will be level 1");
            CITY_LEVEL2_HEIGHT = cfg.getInt("cityLevel2Height", categoryCities, inheritFrom.orElse(this).CITY_LEVEL2_HEIGHT, 1, 255,
                    "Below this chunk height cities will be level 2");
            CITY_LEVEL3_HEIGHT = cfg.getInt("cityLevel3Height", categoryCities, inheritFrom.orElse(this).CITY_LEVEL3_HEIGHT, 1, 255,
                    "Below this chunk height cities will be level 3");
        }
        
        // private void initCitySpheres(Configuration cfg) 
        {
            String categoryCitySpheres;
            categoryCitySpheres = LostCityProfile.CATEGORY_CITY_SPHERES + "_" + name;
            cfg.addCustomCategoryComment(categoryCitySpheres, "Settings related to city sphere generation for the " + name + " profile");
            
            CITYSPHERE_FACTOR = cfg.getFloat("citySphereFactor", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_FACTOR, 0.1f, 10.0f, "Only used in 'space' landscape. This factor will be multiplied with the radius of the city to calculate the radius of the outer sphere");
            CITYSPHERE_CHANCE = cfg.getFloat("citySphereChance", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_CHANCE, 0.0f, 1.0f, "The chance that a city sphere will be generated");
            CITYSPHERE_SURFACE_VARIATION = cfg.getFloat("sphereSurfaceVariation", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_SURFACE_VARIATION, 0.0f, 1.0f, "Smaller numbers make the surface inside a city sphere more varied");
            CITYSPHERE_OUTSIDE_SURFACE_VARIATION = cfg.getFloat("outsideSurfaceVariation", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_OUTSIDE_SURFACE_VARIATION, 0.0f, 1.0f, "Smaller numbers make the surface outside a city sphere more varied");
            CITYSPHERE_MONORAIL_CHANCE = cfg.getFloat("monorailChance", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_MONORAIL_CHANCE, 0.0f, 1.0f, "The chance that a city will have a monorail connection in a certain direction. There will only be an actual connection if there is a city in that direction that also wants a monorail");
            CITYSPHERE_LANDSCAPE_OUTSIDE = cfg.getBoolean("landscapeOutside", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_LANDSCAPE_OUTSIDE,
                    "If this is true then there will be a landscape outside the city spheres");
            CITYSPHERE_ONLY_PREDEFINED = cfg.getBoolean("onlyPredefined", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_ONLY_PREDEFINED,
                    "If this is true then only predefined spheres are generated");
            CITYSPHERE_OUTSIDE_GROUNDLEVEL = cfg.getInt("outsideGroundLevel", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_OUTSIDE_GROUNDLEVEL, -1, 256, "Ground level for outside city spheres (DEPRECATED, USE GROUNDLEVEL OF OTHER PROFILE)");
            CITYSPHERE_OUTSIDE_PROFILE = cfg.getString("outsideProfile", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_OUTSIDE_PROFILE, "An optional profile to use for the outside world");
            CITYSPHERE_MONORAIL_HEIGHT_OFFSET = cfg.getInt("monorailOffset", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_MONORAIL_HEIGHT_OFFSET, -100, 100, "Offset compared to main height");
            CITYSPHERE_SINGLE_BIOME = cfg.getBoolean("singleBiome", categoryCitySpheres, inheritFrom.orElse(this).CITYSPHERE_SINGLE_BIOME,
                    "If this is true then every city sphere will be limited to one (random) biome");
        }
        
        // private void initClient(Configuration cfg)
        {
            String categoryClient;
            categoryClient = LostCityProfile.CATEGORY_CLIENT + "_" + name;
            cfg.addCustomCategoryComment(categoryClient, "Client side settings for the " + name + " profile");

            HORIZON = cfg.getFloat("horizon", categoryClient, inheritFrom.orElse(this).HORIZON, -1f, 256f, "This is used client-side (but only if the client has this mod) to set the height of the horizon");
            FOG_RED = cfg.getFloat("fogRed", categoryClient, inheritFrom.orElse(this).FOG_RED, -1f, 1f, "This is used client-side (but only if the client has this mod) for the fog color");
            FOG_GREEN = cfg.getFloat("fogGreen", categoryClient, inheritFrom.orElse(this).FOG_GREEN, -1f, 1f, "This is used client-side (but only if the client has this mod) for the fog color");
            FOG_BLUE = cfg.getFloat("fogBlue", categoryClient, inheritFrom.orElse(this).FOG_BLUE, -1f, 1f, "This is used client-side (but only if the client has this mod) for the fog color");
            FOG_DENSITY = cfg.getFloat("fogDensity", categoryClient, inheritFrom.orElse(this).FOG_DENSITY, -1f, 1f, "This is used client-side (but only if the client has this mod) for the fog density");
        }
        
    }

    public void fromJsonDeserialize(JsonObject p1) {
    	if(p1.has(CATEGORY_BASEINFO)) {
    		JsonObject cfg=p1.getAsJsonObject(CATEGORY_BASEINFO);
    		
    		name=cfg.get("name").getAsString();
    		isPublic=cfg.get("isPublic").getAsBoolean();
    	}

        // private void initLostcity(Configuration cfg) 
        if(p1.has(CATEGORY_LOSTCITY)){
            JsonObject cfg=p1.getAsJsonObject(CATEGORY_LOSTCITY);

            description = cfg.get("description").getAsString();
            extraDescription = cfg.get("extraDescription").getAsString();
            worldStyle = cfg.get("worldStyle").getAsString();
            iconFile = cfg.get("icon").getAsString();

            LIQUID_BLOCK = cfg.get("liquidBlock").getAsString();
            BASE_BLOCK = cfg.get("baseBlock").getAsString();

            SPAWN_BIOME = cfg.get("spawnBiome").getAsString();
            SPAWN_CITY = cfg.get("spawnCity").getAsString();
            SPAWN_SPHERE = cfg.get("spawnSphere").getAsString();
            SPAWN_NOT_IN_BUILDING = cfg.get("spawnNotInBuilding").getAsBoolean();

            VINE_CHANCE = cfg.get("vineChance").getAsFloat();
            CHANCE_OF_RANDOM_LEAFBLOCKS = cfg.get("randomLeafBlockChance").getAsFloat();
            THICKNESS_OF_RANDOM_LEAFBLOCKS = cfg.get("randomLeafBlockThickness").getAsInt();
            AVOID_FOLIAGE = cfg.get("avoidFoliage").getAsBoolean();
            AVOID_GENERATED_CACTII = cfg.get("avoidGeneratedCactii").getAsBoolean();
            AVOID_GENERATED_FLOWERS = cfg.get("avoidGeneratedFlowers").getAsBoolean();
            AVOID_GENERATED_GRASS = cfg.get("avoidGeneratedGrass").getAsBoolean();
            AVOID_GENERATED_PUMPKINS = cfg.get("avoidGeneratedPumpkins").getAsBoolean();
            AVOID_GENERATED_LILYPADS = cfg.get("avoidGeneratedLilypads").getAsBoolean();
            AVOID_GENERATED_REEDS = cfg.get("avoidGeneratedReeds").getAsBoolean();
            AVOID_GENERATED_TREES = cfg.get("avoidGeneratedTrees").getAsBoolean();
            AVOID_GENERATED_MUSHROOMS = cfg.get("avoidGeneratedMushrooms").getAsBoolean();
            AVOID_GENERATED_LAKE_WATER = cfg.get("avoidGeneratedLakewater").getAsBoolean();
            AVOID_GENERATED_DESERT_WELL = cfg.get("avoidGeneratedDesertWell").getAsBoolean();
            AVOID_GENERATED_FOSSILS = cfg.get("avoidGeneratedFossils").getAsBoolean();

            {
    	        String type = cfg.get("landscapeType").getAsString();
    	        LANDSCAPE_TYPE = LandscapeType.getTypeByName(type);
    	        if (LANDSCAPE_TYPE == null) {
    	            throw new RuntimeException("Bad landscape type: " + type + "!");
    	        }
            }

            RUBBLELAYER = cfg.get("rubbleLayer").getAsBoolean();
            RUBBLE_DIRT_SCALE = cfg.get("rubbleDirtScale").getAsFloat();
            RUBBLE_LEAVE_SCALE = cfg.get("rubbleLeaveScale").getAsFloat();

            RUINS = cfg.get("ruins").getAsBoolean();
            RUIN_CHANCE = cfg.get("ruinChance").getAsFloat();
            RUIN_MINLEVEL_PERCENT = cfg.get("ruinMinlevelPercent").getAsFloat();
            RUIN_MAXLEVEL_PERCENT = cfg.get("ruinMaxlevelPercent").getAsFloat();

            GROUNDLEVEL = cfg.get("groundLevel").getAsInt();
            WATERLEVEL_OFFSET = cfg.get("waterLevelOffset").getAsInt();


            CHEST_WITHOUT_LOOT_CHANCE = cfg.get("chestWithoutLootChance").getAsFloat();
            BUILDING_WITHOUT_LOOT_CHANCE = cfg.get("buildingWithoutLootChance").getAsFloat();
            BUILDING_CHANCE = cfg.get("buildingChance").getAsFloat();
            BUILDING_MINFLOORS = cfg.get("buildingMinFloors").getAsInt();
            BUILDING_MAXFLOORS = cfg.get("buildingMaxFloors").getAsInt();
            BUILDING_MINFLOORS_CHANCE = cfg.get("buildingMinFloorsChance").getAsInt();
            BUILDING_MAXFLOORS_CHANCE = cfg.get("buildingMaxFloorsChance").getAsInt();

            BUILDING_MINCELLARS = cfg.get("buildingMinCellars").getAsInt();
            BUILDING_MAXCELLARS = cfg.get("buildingMaxCellars").getAsInt();
            BUILDING_DOORWAYCHANCE = cfg.get("buildingDoorwayChance").getAsFloat();
            BUILDING_FRONTCHANCE = cfg.get("buildingFrontChance").getAsFloat();
            LIBRARY_CHANCE = cfg.get("libraryChance").getAsFloat();
            DATACENTER_CHANCE = cfg.get("dataCenterChance").getAsFloat();
            PARK_CHANCE = cfg.get("parkChance").getAsFloat();

            BUILDING2X2_CHANCE = cfg.get("building2x2Chance").getAsFloat();
            CORRIDOR_CHANCE = cfg.get("corridorChance").getAsFloat();
            BRIDGE_CHANCE = cfg.get("bridgeChance").getAsFloat();
            BRIDGE_SUPPORTS = cfg.get("bridgeSupports").getAsBoolean();

            FOUNTAIN_CHANCE = cfg.get("fountainChance").getAsFloat();

            RAILWAY_DUNGEON_CHANCE = cfg.get("railwayDungeonChance").getAsFloat();
            RAILWAYS_CAN_END = cfg.get("railwaysCanEnd").getAsBoolean();
            RAILWAYS_ENABLED = cfg.get("railwaysEnabled").getAsBoolean();
            RAILWAY_STATIONS_ENABLED = cfg.get("railwayStationsEnabled").getAsBoolean();

            HIGHWAY_REQUIRES_TWO_CITIES = cfg.get("highwayRequiresTwoCities").getAsBoolean();
            HIGHWAY_LEVEL_FROM_CITIES_MODE = cfg.get("highwayLevelFromCities").getAsInt();
            HIGHWAY_DISTANCE_MASK = cfg.get("highwayDistanceMask").getAsInt();
            HIGHWAY_MAINPERLIN_SCALE = cfg.get("highwayMainPerlinScale").getAsFloat();
            HIGHWAY_SECONDARYPERLIN_SCALE = cfg.get("highwaySecondaryPerlinScale").getAsFloat();
            HIGHWAY_PERLIN_FACTOR = cfg.get("highwayPerlinFactor").getAsFloat();
            HIGHWAY_SUPPORTS = cfg.get("highwaySupports").getAsBoolean();

            BEDROCK_LAYER = cfg.get("bedrockLayer").getAsInt();

            GENERATE_SPAWNERS = cfg.get("generateSpawners").getAsBoolean();
            GENERATE_LOOT = cfg.get("generateLoot").getAsBoolean();
            GENERATE_LIGHTING = cfg.get("generateLighting").getAsBoolean();
            AVOID_WATER = cfg.get("avoidWater").getAsBoolean();

            ALLOWED_BIOME_FACTORS = JsonUtil.getAsStringList(cfg.get("allowedBiomeFactors"));
            MANUAL_BIOME_MAPPINGS = JsonUtil.getAsStringList(cfg.get("manualBiomeMappings"));

            {
    	        String biomeSelectionStrategy = cfg.get("biomeSelectionStrategy").getAsString();
    	        BIOME_SELECTION_STRATEGY = BiomeSelectionStrategy.getTypeByName(biomeSelectionStrategy);
    	        if (BIOME_SELECTION_STRATEGY == null) {
    	            throw new RuntimeException("Bad biome selection strategy: " + biomeSelectionStrategy + "!");
    	        }
            }

            GENERATOR_OPTIONS = cfg.get("generatorOptions").getAsString();
        }
        
        // private void initExplosions(Configuration cfg) 
        if(p1.has(CATEGORY_EXPLOSIONS)){
        	JsonObject cfg=p1.getAsJsonObject(CATEGORY_EXPLOSIONS);
            
            DEBRIS_TO_NEARBYCHUNK_FACTOR = cfg.get("debrisToNearbyChunkFactor").getAsInt();

            DESTROY_LONE_BLOCKS_FACTOR = cfg.get("destroyLoneBlocksFactor").getAsFloat();
            DESTROY_OR_MOVE_CHANCE = cfg.get("destroyOrMoveChance").getAsFloat();
            DESTROY_SMALL_SECTIONS_SIZE = cfg.get("destroySmallSectionsSize").getAsInt();

            EXPLOSION_CHANCE = cfg.get("explosionChance").getAsFloat();
            EXPLOSION_MINRADIUS = cfg.get("explosionMinRadius").getAsInt();
            EXPLOSION_MAXRADIUS = cfg.get("explosionMaxRadius").getAsInt();
            EXPLOSION_MINHEIGHT = cfg.get("explosionMinHeight").getAsInt();
            EXPLOSION_MAXHEIGHT = cfg.get("explosionMaxHeight").getAsInt();

            MINI_EXPLOSION_CHANCE = cfg.get("miniExplosionChance").getAsFloat();
            MINI_EXPLOSION_MINRADIUS = cfg.get("miniExplosionMinRadius").getAsInt();
            MINI_EXPLOSION_MAXRADIUS = cfg.get("miniExplosionMaxRadius").getAsInt();
            MINI_EXPLOSION_MINHEIGHT = cfg.get("miniExplosionMinHeight").getAsInt();
            MINI_EXPLOSION_MAXHEIGHT = cfg.get("miniExplosionMaxHeight").getAsInt();

            EXPLOSIONS_IN_CITIES_ONLY = cfg.get("explosionsInCitiesOnly").getAsBoolean();
        }
        
        // private void initStructures(Configuration cfg) 
        if(p1.has(CATEGORY_STRUCTURES)){
            JsonObject cfg=p1.getAsJsonObject(CATEGORY_STRUCTURES);

            GENERATE_OCEANMONUMENTS = cfg.get("generateOceanMonuments").getAsBoolean();
            GENERATE_MANSIONS = cfg.get("generateMansions").getAsBoolean();
            GENERATE_SCATTERED = cfg.get("generateScattered").getAsBoolean();
            GENERATE_STRONGHOLDS = cfg.get("generateStrongholds").getAsBoolean();
            GENERATE_VILLAGES = cfg.get("generateVillages").getAsBoolean();
            GENERATE_CAVES = cfg.get("generateCaves").getAsBoolean();
            GENERATE_RAVINES = cfg.get("generateRavines").getAsBoolean();
            GENERATE_MINESHAFTS = cfg.get("generateMineshafts").getAsBoolean();
            GENERATE_LAKES = cfg.get("generateLakes").getAsBoolean();
            GENERATE_DUNGEONS = cfg.get("generateDungeons").getAsBoolean();
            MAX_CAVE_HEIGHT = cfg.get("maxCaveHeight").getAsInt();

            PREVENT_VILLAGES_IN_CITIES = cfg.get("preventVillagesInCities").getAsBoolean();
            PREVENT_LAKES_RAVINES_IN_CITIES = cfg.get("preventLakesRavinesInCities").getAsBoolean();
        }
        // private void initCities(Configuration cfg) 
        if(p1.has(CATEGORY_CITIES)){
        	JsonObject cfg=p1.getAsJsonObject(CATEGORY_CITIES);
            
            CITY_CHANCE = cfg.get("cityChance").getAsFloat();
            CITY_MINRADIUS = cfg.get("cityMinRadius").getAsInt();
            CITY_MAXRADIUS = cfg.get("cityMaxRadius").getAsInt();
            CITY_THRESSHOLD = cfg.get("cityThresshold").getAsFloat();
            CITY_BIOME_FACTORS = JsonUtil.getAsStringList(cfg.get("cityBiomeFactors"));
            CITY_DEFAULT_BIOME_FACTOR = cfg.get("cityBiomeFactorDefault").getAsFloat();

            CITY_LEVEL0_HEIGHT = cfg.get("cityLevel0Height").getAsInt();
            CITY_LEVEL1_HEIGHT = cfg.get("cityLevel1Height").getAsInt();
            CITY_LEVEL2_HEIGHT = cfg.get("cityLevel2Height").getAsInt();
            CITY_LEVEL3_HEIGHT = cfg.get("cityLevel3Height").getAsInt();
        }
        
        // private void initCitySpheres(Configuration cfg) 
        if(p1.has(CATEGORY_CITY_SPHERES)){
        	JsonObject cfg=p1.getAsJsonObject(CATEGORY_CITY_SPHERES);
            
            CITYSPHERE_FACTOR = cfg.get("citySphereFactor").getAsFloat();
            CITYSPHERE_CHANCE = cfg.get("citySphereChance").getAsFloat();
            CITYSPHERE_SURFACE_VARIATION = cfg.get("sphereSurfaceVariation").getAsFloat();
            CITYSPHERE_OUTSIDE_SURFACE_VARIATION = cfg.get("outsideSurfaceVariation").getAsFloat();
            CITYSPHERE_MONORAIL_CHANCE = cfg.get("monorailChance").getAsFloat();
            CITYSPHERE_LANDSCAPE_OUTSIDE = cfg.get("landscapeOutside").getAsBoolean();
            CITYSPHERE_ONLY_PREDEFINED = cfg.get("onlyPredefined").getAsBoolean();
            CITYSPHERE_OUTSIDE_GROUNDLEVEL = cfg.get("outsideGroundLevel").getAsInt();
            CITYSPHERE_OUTSIDE_PROFILE = cfg.get("outsideProfile").getAsString();
            CITYSPHERE_MONORAIL_HEIGHT_OFFSET = cfg.get("monorailOffset").getAsInt();
            CITYSPHERE_SINGLE_BIOME = cfg.get("singleBiome").getAsBoolean();
        }
        
        // private void initClient(Configuration cfg)
        if(p1.has(CATEGORY_CLIENT)){
        	JsonObject cfg=p1.getAsJsonObject(CATEGORY_CLIENT);

            HORIZON = cfg.get("horizon").getAsFloat();
            FOG_RED = cfg.get("fogRed").getAsFloat();
            FOG_GREEN = cfg.get("fogGreen").getAsFloat();
            FOG_BLUE = cfg.get("fogBlue").getAsFloat();
            FOG_DENSITY = cfg.get("fogDensity").getAsFloat();
        }
    }

    public JsonObject toJsonSerialize() {
    	JsonObject cfgroot=new JsonObject();
    	
    	{
    		JsonObject cfg=new JsonObject();
    		
    		cfg.addProperty("name",name);
    		cfg.addProperty("isPublic",isPublic);
    		
    		cfgroot.add(CATEGORY_BASEINFO, cfg);
    	}

        // private void initLostcity(Configuration cfg) 
        {
        	JsonObject cfg=new JsonObject();

        	cfg.addProperty("description",description);
        	cfg.addProperty("extraDescription",extraDescription);
        	cfg.addProperty("worldStyle",worldStyle);
        	cfg.addProperty("icon",iconFile);

        	cfg.addProperty("liquidBlock",LIQUID_BLOCK);
        	cfg.addProperty("baseBlock",BASE_BLOCK);

        	cfg.addProperty("spawnBiome",SPAWN_BIOME);
        	cfg.addProperty("spawnCity",SPAWN_CITY);
        	cfg.addProperty("spawnSphere",SPAWN_SPHERE);
        	cfg.addProperty("spawnNotInBuilding",SPAWN_NOT_IN_BUILDING);

        	cfg.addProperty("vineChance",VINE_CHANCE);
        	cfg.addProperty("randomLeafBlockChance",CHANCE_OF_RANDOM_LEAFBLOCKS);
        	cfg.addProperty("randomLeafBlockThickness",THICKNESS_OF_RANDOM_LEAFBLOCKS);
        	cfg.addProperty("avoidFoliage",AVOID_FOLIAGE);
        	cfg.addProperty("avoidGeneratedCactii",AVOID_GENERATED_CACTII);
        	cfg.addProperty("avoidGeneratedFlowers",AVOID_GENERATED_FLOWERS);
        	cfg.addProperty("avoidGeneratedGrass",AVOID_GENERATED_GRASS);
        	cfg.addProperty("avoidGeneratedPumpkins",AVOID_GENERATED_PUMPKINS);
        	cfg.addProperty("avoidGeneratedLilypads",AVOID_GENERATED_LILYPADS);
        	cfg.addProperty("avoidGeneratedReeds",AVOID_GENERATED_REEDS);
        	cfg.addProperty("avoidGeneratedTrees",AVOID_GENERATED_TREES);
        	cfg.addProperty("avoidGeneratedMushrooms",AVOID_GENERATED_MUSHROOMS);
        	cfg.addProperty("avoidGeneratedLakewater",AVOID_GENERATED_LAKE_WATER);
        	cfg.addProperty("avoidGeneratedDesertWell",AVOID_GENERATED_DESERT_WELL);
        	cfg.addProperty("avoidGeneratedFossils",AVOID_GENERATED_FOSSILS);

        	cfg.addProperty("landscapeType",LANDSCAPE_TYPE.getName());

        	cfg.addProperty("rubbleLayer",RUBBLELAYER);
        	cfg.addProperty("rubbleDirtScale",RUBBLE_DIRT_SCALE);
        	cfg.addProperty("rubbleLeaveScale",RUBBLE_LEAVE_SCALE);

        	cfg.addProperty("ruins",RUINS);
        	cfg.addProperty("ruinChance",RUIN_CHANCE);
        	cfg.addProperty("ruinMinlevelPercent",RUIN_MINLEVEL_PERCENT);
        	cfg.addProperty("ruinMaxlevelPercent",RUIN_MAXLEVEL_PERCENT);

        	cfg.addProperty("groundLevel",GROUNDLEVEL);
        	cfg.addProperty("waterLevelOffset",WATERLEVEL_OFFSET);


            cfg.addProperty("chestWithoutLootChance",CHEST_WITHOUT_LOOT_CHANCE);
            cfg.addProperty("buildingWithoutLootChance",BUILDING_WITHOUT_LOOT_CHANCE);
            cfg.addProperty("buildingChance",BUILDING_CHANCE);
            cfg.addProperty("buildingMinFloors",BUILDING_MINFLOORS);
            cfg.addProperty("buildingMaxFloors",BUILDING_MAXFLOORS);
            cfg.addProperty("buildingMinFloorsChance",BUILDING_MINFLOORS_CHANCE);
            cfg.addProperty("buildingMaxFloorsChance",BUILDING_MAXFLOORS_CHANCE);

            cfg.addProperty("buildingMinCellars",BUILDING_MINCELLARS);
            cfg.addProperty("buildingMaxCellars",BUILDING_MAXCELLARS);
            cfg.addProperty("buildingDoorwayChance",BUILDING_DOORWAYCHANCE);
            cfg.addProperty("buildingFrontChance",BUILDING_FRONTCHANCE);
            cfg.addProperty("libraryChance",LIBRARY_CHANCE);
            cfg.addProperty("dataCenterChance",DATACENTER_CHANCE);
            cfg.addProperty("parkChance",PARK_CHANCE);

            cfg.addProperty("building2x2Chance",BUILDING2X2_CHANCE);
            cfg.addProperty("corridorChance",CORRIDOR_CHANCE);
            cfg.addProperty("bridgeChance",BRIDGE_CHANCE);
            cfg.addProperty("bridgeSupports",BRIDGE_SUPPORTS);

            cfg.addProperty("fountainChance",FOUNTAIN_CHANCE);

            cfg.addProperty("railwayDungeonChance",RAILWAY_DUNGEON_CHANCE);
            cfg.addProperty("railwaysCanEnd",RAILWAYS_CAN_END);
            cfg.addProperty("railwaysEnabled",RAILWAYS_ENABLED);
            cfg.addProperty("railwayStationsEnabled",RAILWAY_STATIONS_ENABLED);

            cfg.addProperty("highwayRequiresTwoCities",HIGHWAY_REQUIRES_TWO_CITIES);
            cfg.addProperty("highwayLevelFromCities",HIGHWAY_LEVEL_FROM_CITIES_MODE);
            cfg.addProperty("highwayDistanceMask",HIGHWAY_DISTANCE_MASK);
            cfg.addProperty("highwayMainPerlinScale",HIGHWAY_MAINPERLIN_SCALE);
            cfg.addProperty("highwaySecondaryPerlinScale",HIGHWAY_SECONDARYPERLIN_SCALE);
            cfg.addProperty("highwayPerlinFactor",HIGHWAY_PERLIN_FACTOR);
            cfg.addProperty("highwaySupports",HIGHWAY_SUPPORTS);

            cfg.addProperty("bedrockLayer",BEDROCK_LAYER);

            cfg.addProperty("generateSpawners",GENERATE_SPAWNERS);
            cfg.addProperty("generateLoot",GENERATE_LOOT);
            cfg.addProperty("generateLighting",GENERATE_LIGHTING);
            cfg.addProperty("avoidWater",AVOID_WATER);

            cfg.add("allowedBiomeFactors",JsonUtil.setAsStringList(ALLOWED_BIOME_FACTORS));
            cfg.add("manualBiomeMappings",JsonUtil.setAsStringList(MANUAL_BIOME_MAPPINGS));

            cfg.addProperty("biomeSelectionStrategy",BIOME_SELECTION_STRATEGY.getName());

            cfg.addProperty("generatorOptions",GENERATOR_OPTIONS);
            
            cfgroot.add(CATEGORY_LOSTCITY, cfg);
        }
        
        // private void initExplosions(Configuration cfg) 
        {
        	JsonObject cfg=new JsonObject();
        	
        	cfg.addProperty("debrisToNearbyChunkFactor",DEBRIS_TO_NEARBYCHUNK_FACTOR);

            cfg.addProperty("destroyLoneBlocksFactor",DESTROY_LONE_BLOCKS_FACTOR);
            cfg.addProperty("destroyOrMoveChance",DESTROY_OR_MOVE_CHANCE);
            cfg.addProperty("destroySmallSectionsSize",DESTROY_SMALL_SECTIONS_SIZE);

            cfg.addProperty("explosionChance",EXPLOSION_CHANCE);
            cfg.addProperty("explosionMinRadius",EXPLOSION_MINRADIUS);
            cfg.addProperty("explosionMaxRadius",EXPLOSION_MAXRADIUS);
            cfg.addProperty("explosionMinHeight",EXPLOSION_MINHEIGHT);
            cfg.addProperty("explosionMaxHeight",EXPLOSION_MAXHEIGHT);

            cfg.addProperty("miniExplosionChance",MINI_EXPLOSION_CHANCE);
            cfg.addProperty("miniExplosionMinRadius",MINI_EXPLOSION_MINRADIUS);
            cfg.addProperty("miniExplosionMaxRadius",MINI_EXPLOSION_MAXRADIUS);
            cfg.addProperty("miniExplosionMinHeight",MINI_EXPLOSION_MINHEIGHT);
            cfg.addProperty("miniExplosionMaxHeight",MINI_EXPLOSION_MAXHEIGHT);

            cfg.addProperty("explosionsInCitiesOnly",EXPLOSIONS_IN_CITIES_ONLY);
            
            cfgroot.add(CATEGORY_EXPLOSIONS, cfg);
        }
        
        // private void initStructures(Configuration cfg) 
        {
        	JsonObject cfg=new JsonObject();

        	cfg.addProperty("generateOceanMonuments",GENERATE_OCEANMONUMENTS);
        	cfg.addProperty("generateMansions",GENERATE_MANSIONS);
        	cfg.addProperty("generateScattered",GENERATE_SCATTERED);
        	cfg.addProperty("generateStrongholds",GENERATE_STRONGHOLDS);
            cfg.addProperty("generateVillages",GENERATE_VILLAGES);
            cfg.addProperty("generateCaves",GENERATE_CAVES);
            cfg.addProperty("generateRavines",GENERATE_RAVINES);
            cfg.addProperty("generateMineshafts",GENERATE_MINESHAFTS);
            cfg.addProperty("generateLakes",GENERATE_LAKES);
            cfg.addProperty("generateDungeons",GENERATE_DUNGEONS);
            cfg.addProperty("maxCaveHeight",MAX_CAVE_HEIGHT);

            cfg.addProperty("preventVillagesInCities",PREVENT_VILLAGES_IN_CITIES);
            cfg.addProperty("preventLakesRavinesInCities",PREVENT_LAKES_RAVINES_IN_CITIES);
            
            cfgroot.add(CATEGORY_STRUCTURES, cfg);
        }
        // private void initCities(Configuration cfg) 
        {
        	JsonObject cfg=new JsonObject();

        	cfg.addProperty("cityChance",CITY_CHANCE);
        	cfg.addProperty("cityMinRadius",CITY_MINRADIUS);
        	cfg.addProperty("cityMaxRadius",CITY_MAXRADIUS);
            cfg.addProperty("cityThresshold",CITY_THRESSHOLD);
            cfg.add("cityBiomeFactors",JsonUtil.setAsStringList(CITY_BIOME_FACTORS));
            cfg.addProperty("cityBiomeFactorDefault",CITY_DEFAULT_BIOME_FACTOR);

            cfg.addProperty("cityLevel0Height",CITY_LEVEL0_HEIGHT);
            cfg.addProperty("cityLevel1Height",CITY_LEVEL1_HEIGHT);
            cfg.addProperty("cityLevel2Height",CITY_LEVEL2_HEIGHT);
            cfg.addProperty("cityLevel3Height",CITY_LEVEL3_HEIGHT);

            cfgroot.add(CATEGORY_CITIES, cfg);
        }
        
        // private void initCitySpheres(Configuration cfg) 
        {
        	JsonObject cfg=new JsonObject();
            
        	cfg.addProperty("citySphereFactor",CITYSPHERE_FACTOR);
        	cfg.addProperty("citySphereChance",CITYSPHERE_CHANCE);
        	cfg.addProperty("sphereSurfaceVariation",CITYSPHERE_SURFACE_VARIATION);
        	cfg.addProperty("outsideSurfaceVariation",CITYSPHERE_OUTSIDE_SURFACE_VARIATION);
            cfg.addProperty("monorailChance",CITYSPHERE_MONORAIL_CHANCE);
            cfg.addProperty("landscapeOutside",CITYSPHERE_LANDSCAPE_OUTSIDE);
            cfg.addProperty("onlyPredefined",CITYSPHERE_ONLY_PREDEFINED);
            cfg.addProperty("outsideGroundLevel",CITYSPHERE_OUTSIDE_GROUNDLEVEL);
            cfg.addProperty("outsideProfile",CITYSPHERE_OUTSIDE_PROFILE);
            cfg.addProperty("monorailOffset",CITYSPHERE_MONORAIL_HEIGHT_OFFSET);
            cfg.addProperty("singleBiome",CITYSPHERE_SINGLE_BIOME);
            
            cfgroot.add(CATEGORY_CITY_SPHERES, cfg);
        }
        
        // private void initClient(Configuration cfg)
        {
        	JsonObject cfg=new JsonObject();

        	cfg.addProperty("horizon",HORIZON);
        	cfg.addProperty("fogRed",FOG_RED);
        	cfg.addProperty("fogGreen",FOG_GREEN);
        	cfg.addProperty("fogBlue",FOG_BLUE);
        	cfg.addProperty("fogDensity",FOG_DENSITY);
            
            cfgroot.add(CATEGORY_CLIENT, cfg);
        }
        
        return cfgroot;
    }
    
}
