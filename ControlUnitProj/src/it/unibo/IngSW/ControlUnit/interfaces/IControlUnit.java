package it.unibo.IngSW.ControlUnit.interfaces;

import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public interface IControlUnit {

	public IDisplay m_IDisplay=null;
	public IControlCmdConsole m_IControlCmdConsole=null;

	public ISensorData[] receiveData();

	public String receiveInput();

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command);

	/**
	 * 
	 * @param data
	 */
	public void showSensorData(ISensorData[] data);

	/**
	 * 
	 * @param state
	 */
	public void showState(ISensorData state);

}