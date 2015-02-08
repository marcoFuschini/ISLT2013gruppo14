package it.unibo.IngSW.FanDevice.interfaces;

import it.unibo.IngSW.common.SensorData;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Fabio
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface ISensor extends Runnable{
	
	public void kill();

	public void pause();

	public void resume();

}