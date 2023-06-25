package mcjty.lostcities.config;

import org.apache.logging.log4j.Level;

import mcjty.lostcities.LostCities;
import mcjty.lostcities.dimensions.world.driver.RPrimerDriver;
import mcjty.lostcities.setup.ModSetup;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class LostCityConfiguration {

    /*
    {"coordinateScale":375.0,"heightScale":6000.0,"lowerLimitScale":1025.0,"upperLimitScale":200.0,"depthNoiseScaleX":200.0,"depthNoiseScaleZ":200.0,"depthNoiseScaleExponent":0.5,"mainNoiseScaleX":80.0,"mainNoiseScaleY":160.0,"mainNoiseScaleZ":80.0,"baseSize":1.0,"stretchY":5.65,"biomeDepthWeight":1.0,"biomeDepthOffset":0.0,"biomeScaleWeight":1.0,"biomeScaleOffset":0.0,"seaLevel":47,"useCaves":true,"useDungeons":true,"dungeonChance":100,"useStrongholds":true,"useVillages":true,"useMineShafts":true,"useTemples":true,"useMonuments":true,"useRavines":true,"useWaterLakes":true,"waterLakeChance":1,"useLavaLakes":true,"lavaLakeChance":80,"useLavaOceans":false,"fixedBiome":-1,"biomeSize":1,"riverSize":5,"dirtSize":18,"dirtCount":8,"dirtMinHeight":0,"dirtMaxHeight":256,"gravelSize":22,"gravelCount":8,"gravelMinHeight":0,"gravelMaxHeight":256,"graniteSize":22,"graniteCount":8,"graniteMinHeight":95,"graniteMaxHeight":255,"dioriteSize":22,"dioriteCount":8,"dioriteMinHeight":95,"dioriteMaxHeight":255,"andesiteSize":22,"andesiteCount":8,"andesiteMinHeight":95,"andesiteMaxHeight":255,"coalSize":17,"coalCount":20,"coalMinHeight":125,"coalMaxHeight":255,"ironSize":9,"ironCount":23,"ironMinHeight":134,"ironMaxHeight":255,"goldSize":9,"goldCount":4,"goldMinHeight":175,"goldMaxHeight":255,"redstoneSize":8,"redstoneCount":8,"redstoneMinHeight":175,"redstoneMaxHeight":255,"diamondSize":8,"diamondCount":3,"diamondMinHeight":175,"diamondMaxHeight":255,"lapisSize":7,"lapisCount":2,"lapisCenterHeight":150,"lapisSpread":16}
     */
    public static final String CATEGORY_GENERAL = "general";

    public static final String ADDITIONAL_DIMENSIONS_COMMENT = "List of additional Lost City dimensions. Format '<id>:<profile>'";
    public static final String LIGHTING_UPDATE_COMMENT = "List of blocks for which a lighting update is needed";
//    public static final String ASSET_COMMENT = "List of asset libraries loaded in the specified order. " +
//            "If the path starts with '/' it is going to be loaded directly from the classpath. If the path starts with '$' it is loaded from the config directory";
    public static final String WORLDTYPES_COMMENT = "List of other worldtypes (id) that this mod will try " +
            "to work with. The worldtype has to support the IChunkPrimerFactory API for this to work";
    public static final String PROFILES_COMMENT = "List of all supported profiles (used for world creation). Warning! Make sure there is always a 'default' profile!";
    public static final String PRIVATE_PROFILES_COMMENT = "List of privatep profiles that cannot be selected by the player but are only used as a child profile of another one";

//    public static final String[] DEFAULT_PROFILES = new String[]{"default", "cavern", "nodamage", "rarecities", "floating", "space", "waterbubbles", "biosphere", "onlycities", "tallbuildings", "safe", "ancient", "wasteland", "chisel", "atlantis", "realistic"};
//    public static final String[] PRIVATE_PROFILES = new String[]{"bio_wasteland", "water_empty"};

    public static String[] BLOCKS_REQUIRING_LIGHTING_UPDATES = new String[] {
            "minecraft:glowstone",
            "minecraft:lit_pumpkin",
            "minecraft:magma"
    };

    public static String[] ADDITIONAL_DIMENSIONS = new String[] {};

    public static String[] ADAPTING_WORLDTYPES = new String[] {};

    public static int VERSION = 8;

//    public static final Map<String, LostCityProfile> profiles = new HashMap<>();
//    public static final Map<String, LostCityProfile> standardProfiles = new HashMap<>();

    public static String DIMENSION_PROFILE = "default";
    public static String DEFAULT_PROFILE = "default";
    public static int DIMENSION_ID = 111;
    public static boolean DIMENSION_BOP = true;
    
    public static boolean UNMANAGED_PROFILE_TO_CLIENT=false;

    public static boolean DEBUG = false;
    //private static boolean OPTIMIZED_CHUNKGEN = true;

    public static String SPECIAL_BED_BLOCK = Blocks.DIAMOND_BLOCK.getRegistryName().toString();

    public static void init(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General settings");
/*
        int oldVersion = 0;
        if (cfg.hasKey(CATEGORY_GENERAL, "version")) {
            oldVersion = cfg.getInt("version", CATEGORY_GENERAL, VERSION, 0, 10000, "Config version. Do not modify this manually!");
        }
*/
        Property versionProperty = new Property("version", Integer.toString(VERSION), Property.Type.INTEGER);
        versionProperty.setComment("Config version. Do not modify this manually!");
        cfg.getCategory(CATEGORY_GENERAL).put("version", versionProperty);

/*
        //initStandardProfiles();

        String[] profileList;

        if (oldVersion != VERSION) {
            LostCities.setup.getLogger().info("Upgrading Lost Cities config from " + oldVersion + " to " + VERSION + "!");

            String[] configuredAssets = cfg.getStringList("assets", CATEGORY_GENERAL, ASSETS, ASSET_COMMENT);
            List<String> mergedAssets = new ArrayList<>();
            Collections.addAll(mergedAssets, ASSETS);
            for (String asset : configuredAssets) {
                if (!mergedAssets.contains(asset)) {
                    mergedAssets.add(asset);
                }
            }
            cfg.getCategory(CATEGORY_GENERAL).remove("assets");
            ASSETS = cfg.getStringList("assets", CATEGORY_GENERAL, mergedAssets.toArray(new String[mergedAssets.size()]), ASSET_COMMENT);


            String[] defaultValues = DEFAULT_PROFILES;
            profileList = cfg.getStringList("profiles", CATEGORY_GENERAL,
                    defaultValues, PROFILES_COMMENT);
            List<String> mergedProfiles = new ArrayList<>();
            Collections.addAll(mergedProfiles, defaultValues);
            for (String profile : profileList) {
                if (!mergedProfiles.contains(profile)) {
                    mergedProfiles.add(profile);
                }
            }
            cfg.getCategory(CATEGORY_GENERAL).remove("profiles");
            profileList = cfg.getStringList("profiles", CATEGORY_GENERAL,
                    mergedProfiles.toArray(new String[mergedProfiles.size()]), PROFILES_COMMENT);
        } else {
            //ASSETS = cfg.getStringList("assets", CATEGORY_GENERAL, ASSETS, ASSET_COMMENT);

            profileList = cfg.getStringList("profiles", CATEGORY_GENERAL,
                    DEFAULT_PROFILES, PROFILES_COMMENT);

        }
*/
        BLOCKS_REQUIRING_LIGHTING_UPDATES = cfg.getStringList("blocksRequiringLightingUpdates", CATEGORY_GENERAL, BLOCKS_REQUIRING_LIGHTING_UPDATES, LIGHTING_UPDATE_COMMENT);

        ADAPTING_WORLDTYPES = cfg.getStringList("adaptingWorldTypes", CATEGORY_GENERAL, ADAPTING_WORLDTYPES, WORLDTYPES_COMMENT);

        ADDITIONAL_DIMENSIONS = cfg.getStringList("additionalDimensions", CATEGORY_GENERAL, ADDITIONAL_DIMENSIONS, ADDITIONAL_DIMENSIONS_COMMENT);

        DIMENSION_PROFILE = cfg.getString("dimensionProfile", CATEGORY_GENERAL, DIMENSION_PROFILE, "The 'profile' to use for generation of the Lost City dimension");
        DEFAULT_PROFILE = cfg.getString("defaultProfile", CATEGORY_GENERAL, DEFAULT_PROFILE, "The default 'profile' to use for the overworld");
        DIMENSION_ID = cfg.getInt("dimensionId", CATEGORY_GENERAL, DIMENSION_ID, -10000, 10000, "The 'ID' of the Lost City Dimension. Set to -1 if you don't want this dimension");
        DIMENSION_BOP = cfg.getBoolean("dimensionBoP", CATEGORY_GENERAL, DIMENSION_BOP, "If true and if Biomes O Plenty is present the dimension will use BoP biomes");
        SPECIAL_BED_BLOCK = cfg.getString("specialBedBlock", CATEGORY_GENERAL, SPECIAL_BED_BLOCK, "Block to put underneath a bed so that it qualifies as a teleporter bed");

        DEBUG = cfg.getBoolean("debug", CATEGORY_GENERAL, DEBUG, "Enable debugging/logging");
        String OPTIMIZED_CHUNKGEN = cfg.getString("optimizedChunkgen", CATEGORY_GENERAL, "Optimized", "Disable this if you have mods like NEID or JEID installed. Note that when NEID or JEID is present this is disabled by default");
        if ((ModSetup.neid || ModSetup.jeid)&&"Optimized".equals(OPTIMIZED_CHUNKGEN)) {
            LostCities.setup.getLogger().log(Level.ERROR, "NEID or JEID detected: Optimized PrimerDriver unapplicate, fallback to Safe.");
            OPTIMIZED_CHUNKGEN = "Safe";
        }
        RPrimerDriver.setDriver(OPTIMIZED_CHUNKGEN);
        
        UNMANAGED_PROFILE_TO_CLIENT = cfg.getBoolean("unmanagedProfileToClient", CATEGORY_GENERAL, UNMANAGED_PROFILE_TO_CLIENT, "Allow client read unmanaged dimension config");

        return;
    }
/*
    public static String[] getPrivateProfiles(Configuration cfg) {
        return cfg.getStringList("privateProfiles", CATEGORY_GENERAL,
                PRIVATE_PROFILES, PRIVATE_PROFILES_COMMENT);
    }
*/
}
