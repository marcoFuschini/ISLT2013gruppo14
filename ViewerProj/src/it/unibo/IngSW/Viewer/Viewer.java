package it.unibo.IngSW.Viewer;

import it.unibo.IngSW.Viewer.interfaces.IViewer;
import it.unibo.IngSW.common.ClientComunicator;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.03
 */
public class Viewer implements IViewer {

	public ClientComunicator m_ClientComunicator=null;
	public IDisplay m_IDisplay=null;

	public Viewer(){

	}

	public void finalize() throws Throwable {

	}

	@Override
	public ISensorData[] receiveData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showSensorData(ISensorData[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showState(ISensorData stateData) {
		// TODO Auto-generated method stub
		
	}

}