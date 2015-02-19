package it.unibo.IngSW.FanDevice.interfaces;

import it.unibo.IngSW.FanDevice.FanSpeed;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * sendData traduce l'array di SensorData in una stringa JSON che verrr� inviata
 * fisicamente mediante la procedura write di ServerComunicator
 * @author Marco
 * @version 1.0
 * @updated 05-feb-2015 17.27.23
 */
public interface IFanDevice {

	public void setSpeed(FanSpeed speed);

}