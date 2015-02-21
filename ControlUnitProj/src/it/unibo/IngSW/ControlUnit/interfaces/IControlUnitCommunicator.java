package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IControlUnitCommunicator {

//	public ICommunicator m_ICommunicator;

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort);

	public void disconnect();

	public ISensorData[] receiveData();

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command);

}