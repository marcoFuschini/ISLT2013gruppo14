package it.unibo.IngSW.Viewer;
import it.unibo.IngSW.Viewer.interfaces.IViewerCommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class ViewerCommunicator implements IViewerCommunicator {

	public ViewerCommunicator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort){

	}

	public void disconnect(){

	}

	public ISensorData[] receiveData(){
		return null;
	}

}