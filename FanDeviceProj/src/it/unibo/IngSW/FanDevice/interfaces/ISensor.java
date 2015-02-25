package it.unibo.IngSW.FanDevice.interfaces;
import it.unibo.IngSW.common.SensorName;
import it.unibo.IngSW.common.interfaces.IBasicSensor;

/**
 * il thread stesso invia i dati al fanDevice
 * 
 * estende runnable
 * 
 * Qui ancora non sappiamo bene quale sarà il meccanismo di comunicazione tra FD e
 * sensori per cui abbiamo messo un generico getData()
 * @author Marco
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface ISensor {

//	public IBasicSensor m_IBasicSensor;

	public String getName();

	public double getValue();

}