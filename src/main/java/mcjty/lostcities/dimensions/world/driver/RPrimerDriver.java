package mcjty.lostcities.dimensions.world.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.Level;

import mcjty.lostcities.LostCities;

public class RPrimerDriver {
	
	public static void setDriver(String a) {
		init();
		LostCities.setup.getLogger().log(Level.INFO, "RPrimerDriver switch to: {}",a);
		
		cur_n=a;
		if(REGISTRY.containsKey(a)) {
			cur_v=REGISTRY.get(a);
			return;
		}else {
			cur_v=null;
			LostCities.setup.getLogger().log(Level.WARN, "PrimerDriver not found: {}",a);
			return;
		}
	}
	
	public static void addDriver(String a,Class<? extends IPrimerDriver> b) {
		init();
		Objects.requireNonNull(b);
		LostCities.setup.getLogger().log(Level.INFO, "RPrimerDriver register: {} -> {}",a,b.getName());
		REGISTRY.put(a,b);
	}

	public static final IPrimerDriver createPrimeDriver() {
		if(null!=cur_v) {
			try {
				return cur_v.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LostCities.setup.getLogger().log(Level.ERROR, "Unable to create PrimerDriver instance from class: {}",cur_v.getName());
				e.printStackTrace();
			}
		}
		
		if(null!=cur_n) {
			if(REGISTRY.containsKey(cur_n)) {
				cur_v=REGISTRY.get(cur_n);
				
				try {
					return cur_v.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					LostCities.setup.getLogger().log(Level.ERROR, "Unable to create PrimerDriver instance from class: {}",cur_v.getName());
				}
				
				return null;
			}else {
				LostCities.setup.getLogger().log(Level.ERROR, "Unable to create PrimerDriver from name: {}",cur_n);
				return null;
			}
		}
		
		throw new UnsupportedOperationException("Unable to create PrimerDriver, config seems not loaded");
	}
	
	/** ======== private ======== */
	public static void init(){
		if(REGISTRY instanceof Map) {
			return;
		}
		if(null==LostCities.setup.getLogger()) {
			RuntimeException e=new RuntimeException(RPrimerDriver.class.getName()+"Cannot init before PreInit called");
			e.printStackTrace(System.err);
			System.err.println(e.getMessage());
			throw e;
		}
		LostCities.setup.getLogger().log(Level.INFO, "RPrimerDriver loading...");
		REGISTRY=new HashMap<>();
		addDriver("Optimized", OptimizedDriver.class);
		addDriver("Safe", SafeDriver.class);
	}
	
	public static String cur_n=null;
	public static Class<? extends IPrimerDriver> cur_v=null;
	public static Map<String,Class<? extends IPrimerDriver>> REGISTRY=null;

}
