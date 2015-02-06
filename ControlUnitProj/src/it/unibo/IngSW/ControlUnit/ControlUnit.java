package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.common.ClientComunicator;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public class ControlUnit implements IControlUnit{

	public ClientComunicator m_ClientComunicator;
	public IControlCmdConsole m_IControlCmdConsole;
	public IDisplay m_IDisplay;

	public ControlUnit(){

	}

	public void finalize() throws Throwable {

	}

	@Override
	public ISensorData[] receiveData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String receiveInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendCommand(String command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showSensorData(ISensorData[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showState(ISensorData state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addElementDisplay(IElementDisplay elementDisplay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeElementDisplay(IElementDisplay elementDisplay) {
		// TODO Auto-generated method stub
		
	}

}