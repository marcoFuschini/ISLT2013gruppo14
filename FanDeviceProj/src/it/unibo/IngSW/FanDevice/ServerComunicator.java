package it.unibo.IngSW.FanDevice;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.02
 */
public class ServerComunicator implements IComunication {

	public ServerComunicator(){

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