package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.02
 */
public class SensorData implements ISensorData {

	public String sensorName;
	public String sensorValue;

	public SensorData(String name,String value){
		sensorName=name;
		sensorValue=value;
	}

	public void finalize() throws Throwable {

	}

}