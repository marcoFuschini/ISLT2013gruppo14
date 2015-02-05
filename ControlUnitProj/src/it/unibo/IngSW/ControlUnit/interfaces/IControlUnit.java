package it.unibo.IngSW.ControlUnit.interfaces;

/**
 * @author Fabio
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public interface IControlUnit {

	public IDisplay m_IDisplay;
	public IControlCmdConsole m_IControlCmdConsole;

	public ISensorData[] receiveData();

	public string receiveInput();

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(string command);

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