package it.unibo.IngSW.FanDevice;

import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorDataBuffer implements ISensorDataBuffer {

	private ArrayBlockingQueue<ISensorData[]> buf;
	
	public SensorDataBuffer(){
		buf=new ArrayBlockingQueue<ISensorData[]>(2048);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param data
	 * @throws InterruptedException 
	 */
	public void put(ISensorData[] data) throws InterruptedException{
		buf.put(data);
	}

	public ISensorData[] take() throws InterruptedException{
		return buf.take();
	}

}