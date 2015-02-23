package it.unibo.IngSW.Viewer;
import it.unibo.IngSW.Viewer.interfaces.IViewerCommunicator;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class ViewerCommunicator implements IViewerCommunicator {
	
	protected ICommunicator comm;
	protected int fdID;
	
	public ViewerCommunicator(){
		comm=new Communicator();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort){
		fdID=comm.connect(fanDeviceIP, fanDevicePort);
	}

	public void disconnect(){
		comm.disconnect(fdID);
	}

	public ISensorData[] receiveData(){
		String msg=comm.read(fdID);
		ISensorData[] data = JSONConverter.JSONToSensorData(msg);
		return data;
	}

}