package it.unibo.IngSW.FanDevice;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.IngSW.FanDevice.interfaces.IPassiveSensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.01
 */
public class PassivePoller implements ISensor {
	
	public static final int DT=1500;//1.5 sec di attesa per la lettura dei sensori

	public ArrayList<IPassiveSensor> m_IPassiveSensor;

	public PassivePoller(ArrayBlockingQueue<ISensorData[]> dataBuffer){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param newSensor
	 */
	public void addSensor(IPassiveSensor newSensor){
		
	}

	/**
	 * 
	 * @param newSensor
	 */
	public void removeSensor(IPassiveSensor newSensor){

	}

	public void resume(){

	}
	public void kill(){

	}

	public void pause(){

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}