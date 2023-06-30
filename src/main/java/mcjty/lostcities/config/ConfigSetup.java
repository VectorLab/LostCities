package mcjty.lostcities.config;

import java.io.File;

import mcjty.lostcities.LostCities;
import mcjty.lostcities.profile.ProfileRegistry;
import mcjty.lostcities.setup.ModSetup;
import net.minecraftforge.common.config.Configuration;

public class ConfigSetup {

    private static Configuration mainConfig;
//    public static Map<String, Configuration> profileConfigs = new HashMap<>();

    public static void init() {
    	ProfileRegistry.init();
        mainConfig = new Configuration(new File(ModSetup.modConfigDir, "general.cfg"));
        Configuration cfg = mainConfig;
        try {
            cfg.load();
            LostCityConfiguration.init(cfg);
        } catch (Exception e1) {
        	LostCities.logger.error( "Problem loading config file!");
        	LostCities.logger.catching(e1);
        } finally {
            if (mainConfig.hasChanged()) {
                mainConfig.save();
            }
/*
            for (Configuration config : profileConfigs.values()) {
                if (config.hasChanged()) {
                    config.save();
                }
            }
*/
        }
    }
/*
    private static void initProfiles(String[] profileList, boolean isPublic) {
        for (String name : profileList) {
            LostCityProfile profile = new LostCityProfile(name, LostCityConfiguration.standardProfiles.get(name), isPublic);
            Configuration profileCfg = new Configuration(new File(ModSetup.modConfigDir, "profile_" + name + ".cfg"));
            profileCfg.load();
            profile.init(profileCfg);
            LostCityConfiguration.profiles.put(name, profile);
            profileConfigs.put(name, profileCfg);
        }
    }
// No responsible for old configure version
    private static void fixConfigs() {
        for (Map.Entry<String, LostCityProfile> entry : LostCityConfiguration.profiles.entrySet()) {
            String name = entry.getKey();
            LostCityProfile profile = entry.getValue();
            if (profile.CITYSPHERE_OUTSIDE_GROUNDLEVEL != -1) {
                // We have to fix this
                if (!profile.CITYSPHERE_OUTSIDE_PROFILE.isEmpty()) {
                    String otherName = profile.CITYSPHERE_OUTSIDE_PROFILE;
                    LostCityProfile otherProfile = LostCityConfiguration.profiles.get(otherName);
                    if (otherProfile != null) {
                        LostCities.setup.getLogger().info("Migrating deprecated 'outsideGroundLevel' from '" + name + "' to '" + otherName + "'");
                        otherProfile.GROUNDLEVEL = profile.CITYSPHERE_OUTSIDE_GROUNDLEVEL;
                        otherProfile.WATERLEVEL_OFFSET = profile.WATERLEVEL_OFFSET;
                        profileConfigs.get(otherName).getCategory(otherProfile.getCategoryLostcity()).get("groundLevel").set(otherProfile.GROUNDLEVEL);
                        profileConfigs.get(otherName).getCategory(otherProfile.getCategoryLostcity()).get("waterLevelOffset").set(otherProfile.WATERLEVEL_OFFSET);
                    }
                }

                profile.CITYSPHERE_OUTSIDE_GROUNDLEVEL = -1;
                profile.WATERLEVEL_OFFSET = 8;
                profileConfigs.get(name).getCategory(profile.getCategoryCitySpheres()).get("outsideGroundLevel").set(profile.CITYSPHERE_OUTSIDE_GROUNDLEVEL);
                profileConfigs.get(name).getCategory(profile.getCategoryLostcity()).get("waterLevelOffset").set(profile.WATERLEVEL_OFFSET);
            }
        }
    }
*/
    public static void postInit() {
        if (mainConfig.hasChanged()) {
            mainConfig.save();
        }
/*
        for (Configuration config : profileConfigs.values()) {
            if (config.hasChanged()) {
                config.save();
            }
        }
*/
    }
}
