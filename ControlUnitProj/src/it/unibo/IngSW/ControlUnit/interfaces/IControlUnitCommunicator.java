package it.unibo.IngSW.ControlUnit.interfaces;
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
	 * @throws Exception 
	 */
	public void connect(String fanDeviceIP, int fanDevicePort) throws Exception;

	public void disconnect() throws Exception;

	public ISensorData[] receiveData() throws Exception;

	/**
	 * 
	 * @param command
	 * @throws Exception 
	 */
	public void sendCommand(String command) throws Exception;

}