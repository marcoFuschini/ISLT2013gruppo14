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
	
	public Viewer(IDisplay display){
		this.communicator=new ViewerCommunicator();
		this.display=display;
	}

	public void connect(String fanDeviceIP,int fanDevicePort) throws Exception{
			communicator.connect(fanDeviceIP, fanDevicePort);
	}

	public void diconnect() throws Exception{
			communicator.disconnect();
	}

	public ISensorData[] receiveData() throws Exception{
			return communicator.receiveData();
	}

	public void updateData(ISensorData[] data){
		for(ISensorData d:data){
			display.writeData(d.getValue(), d.getName());
		}
		display.refresh();
	}

}