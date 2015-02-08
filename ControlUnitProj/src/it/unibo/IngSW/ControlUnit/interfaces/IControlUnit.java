package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.interfaces.IComunication;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 08-feb-2015 17.14.03
 */
public interface IControlUnit {

	public IDisplay m_IDisplay=null;
	public IComunication m_IComunication=null;
	public IControlCmdConsole m_IControlCmdConsole=null;

	/**
	 * 
	 * @param elementDisplay
	 */
	public void addElementDisplay(IElementDisplay elementDisplay);

	public boolean isAlive();

	public ISensorData[] receiveData();

	public String receiveInput();

	/**
	 * 
	 * @param displayName
	 */
	public void removeElementDisplay(String displayName);

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

	public void turnOff();

}