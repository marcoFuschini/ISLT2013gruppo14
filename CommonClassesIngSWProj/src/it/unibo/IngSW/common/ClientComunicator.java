package Project;

import it.unibo.IngSW.common.interfaces.IComunication;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.58
 */
public class ClientComunicator implements IComunication {

	public ClientComunicator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDeviceIP
	 */
	public boolean connect(String fanDeviceIP){
		return false;
	}

	public boolean disconnect(){
		return false;
	}

	public String readData(){
		return "";
	}

	/**
	 * 
	 * @param data
	 */
	public void writeData(String data){

	}

}