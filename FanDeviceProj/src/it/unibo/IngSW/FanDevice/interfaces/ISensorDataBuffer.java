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
	 * @throws InterruptedException 
	 */
	public void put(ISensorData[] data) throws InterruptedException;

	public ISensorData[] take() throws InterruptedException;

}