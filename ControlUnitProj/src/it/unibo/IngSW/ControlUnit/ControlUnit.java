package Project;
import DomainModel.IControlCmdConsole;
import DomainModel.IDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public class ControlUnit {

	public ClientComunicator m_ClientComunicator;
	public IControlCmdConsole m_IControlCmdConsole;
	public IDisplay m_IDisplay;

	public ControlUnit(){

	}

	public void finalize() throws Throwable {

	}

	public string receiveCommand(){
		return "";
	}

	public SensorData[] receiveData(){
		return null;
	}

	/**
	 * 
	 * @param cmd
	 */
	public void sendCommand(string cmd){

	}

	/**
	 * 
	 * @param data
	 */
	public showSensorData(SensorData[] data){

	}

	/**
	 * 
	 * @param state
	 */
	public void showState(SensorData state){

	}

}