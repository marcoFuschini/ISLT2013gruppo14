package it.unibo.IngSW.Viewer;
import it.unibo.IngSW.Viewer.interfaces.IViewer;
import it.unibo.IngSW.Viewer.interfaces.IViewerCommunicator;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class Viewer implements IViewer {

	private IViewerCommunicator communicator;
	private IDisplay display;
	
	public Viewer(IViewerCommunicator communicator, IDisplay display){
		this.communicator=communicator;
		this.display=display;
	}

	public void connect(int fanDevicePort, String fanDeviceIP){
		try {
			communicator.connect(fanDeviceIP, fanDevicePort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void diconnect(){
		try {
			communicator.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ISensorData[] receiveData(){
		try {
			return communicator.receiveData();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateData(ISensorData[] data){
		for(ISensorData d:data){
			display.writeData(d.getValue(), d.getName());
		}
	}

}