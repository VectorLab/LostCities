package mcjty.lostcities;

import java.util.Optional;
import java.util.function.Function;

import org.apache.logging.log4j.Logger;

import mcjty.lostcities.api.ILostCities;
import mcjty.lostcities.commands.CommandBuildPart;
import mcjty.lostcities.commands.CommandDebug;
import mcjty.lostcities.commands.CommandExportBuilding;
import mcjty.lostcities.commands.CommandExportPart;
import mcjty.lostcities.dimensions.world.WorldTypeTools;
import mcjty.lostcities.dimensions.world.lost.BiomeInfo;
import mcjty.lostcities.dimensions.world.lost.BuildingInfo;
import mcjty.lostcities.dimensions.world.lost.City;
import mcjty.lostcities.dimensions.world.lost.CitySphere;
import mcjty.lostcities.dimensions.world.lost.Highway;
import mcjty.lostcities.dimensions.world.lost.Railway;
import mcjty.lostcities.setup.IProxy;
import mcjty.lostcities.setup.ModSetup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;

@Mod(modid = LostCities.MODID, name="The Lost Cities",
        dependencies =
                        "after:forge@[" + LostCities.MIN_FORGE11_VER + ",)",
        version = LostCities.VERSION,
        acceptedMinecraftVersions = "[1.12,1.13)",
        acceptableRemoteVersions = "*")
public class LostCities {
    public static final String MODID = "lostcities";
    public static final String VERSION = "2.0.23";
    public static final String MIN_FORGE11_VER = "13.19.0.2176";

    @SidedProxy(clientSide="mcjty.lostcities.setup.ClientProxy", serverSide="mcjty.lostcities.setup.ServerProxy")
    public static IProxy proxy;
    public static ModSetup setup = new ModSetup();
    public static Logger logger;

    @Mod.Instance("lostcities")
    public static LostCities instance;

    public static LostCitiesImp lostCitiesImp = new LostCitiesImp();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	logger=e.getModLog();
        setup.preInit(e);
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        setup.init(e);
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        setup.postInit(e);
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandDebug());
        event.registerServerCommand(new CommandExportBuilding());
        event.registerServerCommand(new CommandExportPart());
        event.registerServerCommand(new CommandBuildPart());
        cleanCaches();
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {
        cleanCaches();
        WorldTypeTools.cleanChunkGeneratorMap();
    }

    private void cleanCaches() {
        BuildingInfo.cleanCache();
        Highway.cleanCache();
        Railway.cleanCache();
        BiomeInfo.cleanCache();
        City.cleanCache();
        CitySphere.cleanCache();
        WorldTypeTools.cleanCache();
    }

    @Mod.EventHandler
    public void imcCallback(FMLInterModComms.IMCEvent event) {
        for (FMLInterModComms.IMCMessage message : event.getMessages()) {
            if (message.key.equalsIgnoreCase("getLostCities")) {
                Optional<Function<ILostCities, Void>> value = message.getFunctionValue(ILostCities.class, Void.class);
                if (value.isPresent()) {
                    value.get().apply(lostCitiesImp);
                } else {
                    setup.getLogger().warn("Some mod didn't return a valid result with getLostCities!");
                }
            }
        }
    }
    
    public static final String CHUNK_GENERATOR_TAG=MODID+"Profile";
    
}
