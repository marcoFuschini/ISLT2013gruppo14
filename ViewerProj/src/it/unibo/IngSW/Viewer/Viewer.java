package Project;
import DomainModel.IViewer;
import DomainModel.IDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.03
 */
public class Viewer implements IViewer {

	public ClientComunicator m_ClientComunicator;
	public IDisplay m_IDisplay;

	public Viewer(){

	}

	public void finalize() throws Throwable {

	}

	public SensorData[] receiveData(){
		return null;
	}

	/**
	 * 
	 * @param data
	 */
	public void showSensorData(SensorData[] data){

	}

	/**
	 * 
	 * @param stateData
	 */
	public void showState(SensorData stateData){

	}

}