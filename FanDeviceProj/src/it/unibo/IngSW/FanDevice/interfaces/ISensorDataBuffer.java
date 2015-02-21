package it.unibo.IngSW.FanDevice.interfaces;

import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public interface ISensorDataBuffer {

	/**
	 * 
	 * @param data
	 */
	public void put(ISensorData[] data);

	public ISensorData[] take();

}