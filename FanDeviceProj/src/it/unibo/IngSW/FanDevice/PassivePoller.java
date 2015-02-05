package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.IPassiveSensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.01
 */
public class PassivePoller implements ISensor {

	public IPassiveSensor m_IPassiveSensor;

	public PassivePoller(){

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


}