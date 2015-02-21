package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IControlUnit {

	/*
	public IControlCmdConsole m_IControlCmdConsole;
	public IInputPoller m_IInputPoller;
	public IDisplay m_IDisplay;
	public IControlUnitCommunicator m_IControlUnitCommunicator;
*/
	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort);

	public void disconnect();

	public String readCommand();

	/**
	 * 
	 * @param data
	 */
	public void receiveData(ISensorData[] data);

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command);

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data);

}