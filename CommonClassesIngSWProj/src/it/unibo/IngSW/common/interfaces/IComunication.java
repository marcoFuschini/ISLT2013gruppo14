package it.unibo.IngSW.common.interfaces;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public interface IComunication {

	/**
	 * 
	 * @param fanDeviceIP
	 */
	public boolean connect(String fanDeviceIP);

	public boolean disconnect();

	public String readData();

	/**
	 * 
	 * @param data
	 */
	public void writeData(String data);

}