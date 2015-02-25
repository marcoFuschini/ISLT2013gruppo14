package it.unibo.IngSW.utils;

import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.ISensorData;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONConverter {
	
	public static String SensorDataToJSON (ISensorData[] data) throws Exception{
		JSONArray jarr=new JSONArray();
		JSONObject jobj;
		for(int i=0;i<data.length;i++){
			jobj=new JSONObject();
			jobj.put("name", data[i].getName());
			jobj.put("value", data[i].getValue());
			jarr.put(jobj);
		}
		return jarr.toString();
	}
	
	public static ISensorData[] JSONToSensorData (String msg) throws Exception{
		JSONObject jobj;
		ISensorData[] data=null;
		JSONArray jarr=new JSONArray(msg);
		data=new SensorData[jarr.length()]; 
		for(int i=0;i<jarr.length();i++){
			jobj=jarr.getJSONObject(i);
			data[i]=new SensorData(jobj.getString("name"),jobj.getString("value"));
		}
		return data;
	}
	
	public static String commandToJSON(Command command) throws Exception{
		JSONObject jobj=new JSONObject();
		jobj.put("command", command);
		return jobj.toString();
	}
	
	public static Command JSONToCommand(String json) throws Exception{
		JSONObject jobj;
		Command command;
		jobj=new JSONObject(json);
		command=(Command)jobj.get("command");
		return command;
	}
}
