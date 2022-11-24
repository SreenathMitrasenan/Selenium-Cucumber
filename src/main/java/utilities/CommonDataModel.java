package utilities;

import java.util.HashMap;
import java.util.Map;

public class CommonDataModel {
	private Map<String ,Map<String,Object>> providerMap;
	private static CommonDataModel esysLookup;

	//public get instance method 
	public static CommonDataModel getInstance() {
	if(esysLookup==null) {
		synchronized(CommonDataModel.class){
			if(esysLookup==null) {
				esysLookup=new CommonDataModel();
			}
		}
	}
	return esysLookup;
	
	}
	private CommonDataModel() { // private constructor to restrict invocation from outside
		if(providerMap==null) {
			providerMap=new HashMap<>();
		}
	}
	
	public boolean add(final String uri, final Map<String ,Object> objectMap) {
		providerMap.put(uri, objectMap);
		return true;
		
	}
	public boolean removeMap(final String uri) {
		providerMap.remove(uri);
		return true;
		
	}
	public Map<String,Object> provide(final String uri) {
		if(providerMap.get(uri)!=null) {
			return providerMap.get(uri);
		}
		return null;
		
	}
	public void clear() {
		providerMap.clear();
	}
	public boolean containsKey(final String key) {
		return providerMap.containsKey(key);
		
	}
	
	

}
