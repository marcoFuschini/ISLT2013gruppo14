package it.unibo.IngSW.FanDevice.interfaces;

import it.unibo.IngSW.FanDevice.FanSpeed;
import it.unibo.IngSW.common.interfaces.ISensorData;


/**
 * sendData traduce l'array di SensorData in una stringa JSON che verrr� inviata
 * fisicamente mediante la procedura write di ServerComunicator
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface IFanDevice {

	public ISensor m_ISensor=null;

	public void decSpeed();

	public void incSpeed();

	public String receiveCommand();

	public ISensorData[] receiveSensorData();

	/**
	 * 
	 * @param dataToSend
	 */
	public void sendData(ISensorData[] dataToSend);

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed);

	public void start();

	public void stop();

}