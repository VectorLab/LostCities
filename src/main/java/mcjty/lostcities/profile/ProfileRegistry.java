package mcjty.lostcities.profile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import mcjty.lostcities.LostCities;
import mcjty.lostcities.config.LostCityProfile;
import mcjty.lostcities.setup.ModSetup;
import mcjty.lostcities.varia.JsonUtil;
import net.minecraftforge.common.config.Configuration;

public class ProfileRegistry {

	// public **local** profile list
	private static final Map<String, LostCityProfile> REGISTRY = new HashMap<>();
	
	// This should be called by GuiLostCityConfiguration only
	public static Map<String, LostCityProfile> getLocalProfileAll() {
		return REGISTRY;
	}
	
	public static LostCityProfile getLocalProfileByName(String p1) {
		return REGISTRY.get(p1);
	}

	public static void init() {
		File v1 = new File(ModSetup.modConfigDir, "profile");
		if (!v1.isDirectory()) {
			if (v1.exists()) {
				v1.delete();
			}
			v1.mkdirs();
			LostCities.logger.info("Profile dir not found, create with default content.");
			Map<String, LostCityProfile> v2 = ProfileUnpacker.run();
			for (LostCityProfile v3 : v2.values()) {
				File v4 = new File(v1, v3.getName() + ".json");
				try {
					FileWriter v5 = new FileWriter(v4, true);
					JsonUtil.json.toJson(v3.toJsonSerialize(), v5);
					v5.flush();
					v5.close();
				} catch (IOException e) {
					LostCities.logger.catching(e);
				}
			}

		}
		for(File v2:v1.listFiles()) {
			if(!v2.isFile()) {
				LostCities.logger.warn("Profile dir find a sub dir here, which should not exist: {}",v2.getAbsolutePath());
				continue;
			}
			String v4=v2.getName();
			{
				int v5=v4.indexOf(".");
				if((v5==-1)||(v5==0)||(v5!=v4.lastIndexOf("."))) {
					LostCities.logger.warn("Profile dir find a invalid file name: {}",v2.getAbsolutePath());
					continue;
				}
			}
			LostCityProfile v3=null;
				if(v4.endsWith(".json")){
					JsonObject v6=null;
					try {
						v6=JsonUtil.json.fromJson(new FileReader(v2),JsonObject.class);
					} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
						LostCities.logger.catching(e);
						continue;
					}
					v3 = new LostCityProfile();
					v3.fromJsonDeserialize(v6);
				} else if(v4.endsWith(".cfg")) {
					LostCities.logger.info("Upgrade profile: {}",v2.getAbsolutePath());
					String name=v4.substring(0,v4.indexOf("."));
					if(v4.trim().isEmpty()) {
						LostCities.logger.warn("Profile name invalid: {}",v2.getAbsolutePath());
						continue;
					}
					
		            v3 = new LostCityProfile();
		            Configuration profileCfg = new Configuration(v2);
		            profileCfg.load();
		            v3.initLegacy(name,true,profileCfg,null);
					
					File v6 = new File(v1, v3.getName() + ".json");
					if(v6.exists()) {
						LostCities.logger.warn("Profile output already exists: {} -> {}",v2.getAbsolutePath(),v6.getAbsolutePath());
						continue;
					}
					try {
						FileWriter v7 = new FileWriter(v6, true);
						JsonUtil.json.toJson(v3.toJsonSerialize(), v7);
						v7.flush();
						v7.close();
						v2.delete();
						LostCities.logger.info("Upgrade successfully: {} , {} -> {}",v3.getName(),v2.getAbsolutePath(),v6.getAbsolutePath());
					} catch (IOException e) {
						LostCities.logger.catching(e);
					}
				}else{
					LostCities.logger.warn("Profile dir find a invalid file name: {}",v2.getAbsolutePath());
					continue;
				}
			
			REGISTRY.put(v3.getName(), v3);
		}
		LostCities.logger.info("Loaded {} Profile (s).",REGISTRY.size());
	}

}
