package mcjty.lostcities.varia;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class JsonUtil {
	
	public static final Gson json=new Gson();
	
	public static String[] getAsStringList(JsonElement p1){
		if(!p1.isJsonArray()) {
			return null;
		}
		JsonArray v1=p1.getAsJsonArray();
		List<String> v2=new ArrayList<>();
		for(JsonElement v3:v1) {
			v2.add(v3.getAsString());
		}
		return v2.toArray(new String[0]);
	}

	public static JsonArray setAsStringList(String[] p1) {
		JsonArray v1=new JsonArray();
		for(String v2:p1) {
			v1.add(v2);
		}
		return v1;
	}
	
}
