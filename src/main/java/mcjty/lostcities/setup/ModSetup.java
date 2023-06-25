package mcjty.lostcities.setup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.logging.log4j.Logger;

import mcjty.lostcities.ForgeEventHandlers;
import mcjty.lostcities.LostCities;
import mcjty.lostcities.TerrainEventHandlers;
import mcjty.lostcities.config.ConfigSetup;
import mcjty.lostcities.config.LostCityConfiguration;
import mcjty.lostcities.dimensions.ModDimensions;
import mcjty.lostcities.dimensions.world.lost.cityassets.AssetRegistries;
import mcjty.lostcities.network.PacketHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModSetup {

    public static boolean chisel = false;
    public static boolean biomesoplenty = false;
    public static boolean atg = false;
    public static boolean neid = false;
    public static boolean jeid = false;

    private Logger logger;
    public static File modConfigDir;

    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        PacketHandler.registerMessages("lostcities");

        setupModCompat();
        
        {
        	modConfigDir = new File(e.getModConfigurationDirectory(),"lostcities");
        }

        
        ConfigSetup.init();
        ModDimensions.init();

        LootTableList.register(new ResourceLocation(LostCities.MODID, "chests/lostcitychest"));
        LootTableList.register(new ResourceLocation(LostCities.MODID, "chests/raildungeonchest"));
    }

    private void setupModCompat() {
        chisel = Loader.isModLoaded("chisel");
        biomesoplenty = Loader.isModLoaded("biomesoplenty") || Loader.isModLoaded("BiomesOPlenty");
//        atg = Loader.isModLoaded("atg"); // @todo
        neid = Loader.isModLoaded("neid");
        jeid = Loader.isModLoaded("jeid");
    }

    public Logger getLogger() {
        return logger;
    }

    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());
        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEventHandlers());
    }

    public void postInit(FMLPostInitializationEvent e) {
        ConfigSetup.postInit();
//        ConfigSetup.profileConfigs.clear();

        AssetRegistries.reset();
        
        File dir_assets=new File(modConfigDir,"assets");
        if(!dir_assets.isDirectory()){
    		if(dir_assets.exists()) {
    			dir_assets.delete();
    		}
        	copyResDir("/assets/lostcities/citydata",dir_assets);
        }
/*
        {
        	// no way to edit resources dir after build
        	String[] ASSETS = new String[] {
                    "/assets/lostcities/citydata/conditions.json",
                    "/assets/lostcities/citydata/palette.json",
                    "/assets/lostcities/citydata/palette_desert.json",
                    "/assets/lostcities/citydata/palette_chisel.json",
                    "/assets/lostcities/citydata/palette_chisel_desert.json",
                    "/assets/lostcities/citydata/highwayparts.json",
                    "/assets/lostcities/citydata/railparts.json",
                    "/assets/lostcities/citydata/monorailparts.json",
                    "/assets/lostcities/citydata/buildingparts.json",
                    "/assets/lostcities/citydata/library.json"
            };
            for (String path : ASSETS) {
            	try(InputStream inputstream = LostCities.class.getResourceAsStream(path)) {
            		AssetRegistries.load(inputstream, path);
            	} catch (IOException ex) {
            		throw new UncheckedIOException(ex);
            	}
            }
        }
*/
	
        // assets dir
        {
        	int i=0;
	        for (File file : dir_assets.listFiles()) {
	        	if(file.isFile()&&file.getName().endsWith(".json")) {
	        		AssetRegistries.load(file);
	        		++i;
	        	}
	        }
	        LostCities.logger.info("Loaded {} Assets (s).",i);
        }

        if (LostCityConfiguration.DEBUG) {
            logger.info("Asset parts loaded: " + AssetRegistries.PARTS.getCount());
            AssetRegistries.showStatistics();
        }
    }
    
	private static void copyResDir(String from, File to) {
		  try {
		    // Get the URL of the resource directory
		    URL fromUrl = LostCities.class.getResource(from);
		    // Check if the resource exists and is a directory
		    if (fromUrl != null && fromUrl.getProtocol().equals("jar")) {
		      // Get the jar file and the entry name of the resource directory
		      JarURLConnection jarConnection = (JarURLConnection) fromUrl.openConnection();
		      JarFile jarFile = jarConnection.getJarFile();
		      String entryName = jarConnection.getEntryName();
		      // Iterate over the entries in the jar file
		      Enumeration<JarEntry> entries = jarFile.entries();
		      while (entries.hasMoreElements()) {
		        JarEntry entry = entries.nextElement();
		        // Check if the entry name starts with the resource directory name
		        if (entry.getName().startsWith(entryName)) {
		          // Get the relative path of the entry
		          String relativePath = entry.getName().substring(entryName.length());
		          // Create a file object for the destination file or directory
		          File destFile = new File(to, relativePath);
		          // If the entry is a directory, create it in the destination
		          if (entry.isDirectory()) {
		            destFile.mkdir();
		          } else {
		            // If the entry is a file, copy its contents to the destination file
		            InputStream in = jarFile.getInputStream(entry);
		            OutputStream out = new FileOutputStream(destFile);
		            byte[] buffer = new byte[1024];
		            int len;
		            while ((len = in.read(buffer)) > 0) {
		              out.write(buffer, 0, len);
		            }
		            in.close();
		            out.close();
		          }
		        }
		      }
		    } else {
		      throw new IOException("Resource not found or not a directory: " + from);
		    }
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}
}
