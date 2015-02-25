package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.Command;
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
	 * @throws Exception 
	 */
	public void connect(String fanDeviceIP, int fanDevicePort) throws Exception;

	public void disconnect() throws Exception;

	public String readCommand();

	/**
	 * 
	 * @param data
	 * @throws Exception 
	 */
	public ISensorData[] receiveData() throws Exception;

	/**
	 * 
	 * @param command
	 * @throws Exception 
	 */
	public void sendCommand(Command command) throws Exception;

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data);

}