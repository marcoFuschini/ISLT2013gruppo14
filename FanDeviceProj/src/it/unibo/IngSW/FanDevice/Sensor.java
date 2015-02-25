package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.SensorName;
import it.unibo.IngSW.common.interfaces.IBasicSensor;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class Sensor implements ISensor {

	private IBasicSensor sensor;
	private String name;
	public Sensor(IBasicSensor bSensor,String sensorName){
		sensor=bSensor;
		name=sensorName;
	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return name;
	}

	public double getValue(){
		return sensor.getValue();
	}

}