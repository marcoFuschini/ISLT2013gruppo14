package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorDataBuffer implements ISensorDataBuffer {

	public SensorDataBuffer(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param data
	 */
	public void put(ISensorData[] data){

	}

	public ISensorData[] take(){
		return null;
	}

}