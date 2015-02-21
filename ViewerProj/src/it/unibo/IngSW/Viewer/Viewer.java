package it.unibo.IngSW.Viewer;
import it.unibo.IngSW.Viewer.interfaces.IViewer;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class Viewer implements IViewer {

	public Viewer(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDevicePort
	 * @param fanDeviceIP
	 */
	public void connect(int fanDevicePort, String fanDeviceIP){

	}

	public void diconnect(){

	}

	public ISensorData[] receiveData(){
		return null;
	}

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data){

	}

}