package com.spbt.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * JSON工具类
 * 
 */
public class GsonUtil {

	private static Gson gson = null;  
    static {  
        if (gson == null) {  
            gson = new Gson();  
        }  
    }  
  
    private GsonUtil() {  
    }  
  
    public static String gsonString(Object object) {  
        String gsonString = null;  
        if (gson != null) {  
            gsonString = gson.toJson(object);  
        }  
        return gsonString;  
    }  
  
  
    public static <T> T gsonToBean(String gsonString, Class<T> cls) {  
        T t = null;  
        if (gson != null) {  
            t = gson.fromJson(gsonString, cls);  
        }  
        return t;  
    }  
  
  
  
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {  
        List<T> list = null;  
        if (gson != null) {  
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {  
            }.getType());  
        }  
        return list;  
    }  
 
    public static <T> List<T> jsonToList(String json, Class<T> cls) {  
        Gson gson = new Gson();  
        List<T> list = new ArrayList<T>();  
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();  
        for(final JsonElement elem : array){  
            list.add(gson.fromJson(elem, cls));  
        }  
        return list;  
    }  
  
  
    public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {  
        List<Map<String, T>> list = null;  
        if (gson != null) {  
            list = gson.fromJson(gsonString,  
                    new TypeToken<List<Map<String, T>>>() {  
                    }.getType());  
        }  
        return list;  
    }  
  
    /**
     * List<Object> 转换JSON
     * @param list
     * @return
     */
    public static String getJsonData(List<?> list) {
    	  Gson gson = new Gson();
    	  String jsonstring = gson.toJson(list);
    	  return jsonstring;
    	}
  
    /** 
     * gson转换Map
     *  
     * @param gsonString 
     * @return 
     */  
    public static <T> Map<String, T> gsonToMaps(String gsonString) {  
        Map<String, T> map = null;  
        if (gson != null) {  
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {  
            }.getType());  
        }  
        return map;  
    }  

	/**
	 * 获取JsonObject
	 * @param json
	 * @return
	 */
	public static JsonObject parseJson(String json){
		JsonParser parser = new JsonParser();
	    JsonObject jsonObj = parser.parse(json).getAsJsonObject();
		return jsonObj;
	}
	
	/**
	 * 根据json字符串返回Map对象
	 * @param json
	 * @return
	 */
	public static Map<String,Object> toMap(String json){
		return GsonUtil.toMap(GsonUtil.parseJson(json));
	}

	/**
	 * 将JSONObjec对象转换成Map-List集合
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(JsonObject json){
	    Map<String, Object> map = new HashMap<String, Object>();
	    Set<Entry<String, JsonElement>> entrySet = json.entrySet();
	    for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ){
	    	Entry<String, JsonElement> entry = iter.next();
	    	String key = entry.getKey();
	    	Object value = entry.getValue();
	        if(value instanceof JsonArray)
	            map.put((String) key, toList((JsonArray) value));
	        else if(value instanceof JsonObject)
	            map.put((String) key, toMap((JsonObject) value));
	        else
	            map.put((String) key, value);
	    }
	    return map;
	}

	/**
	 * 将JSONArray对象转换成List集合
	 * @param json
	 * @return
	 */
	public static List<Object> toList(JsonArray json){
	    List<Object> list = new ArrayList<Object>();
	    for (int i=0; i<json.size(); i++){
	    	Object value = json.get(i);
	    	if(value instanceof JsonArray){
	            list.add(toList((JsonArray) value));
	    	}
	        else if(value instanceof JsonObject){
	            list.add(toMap((JsonObject) value));
	        }
	        else{
	            list.add(value);
	        }
	    }
	    return list;
	}
}
