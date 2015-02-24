package it.unibo.IngSW.common.interfaces;

/**
 * La connect funziona come server se come stringa passiamo "server" e come client
 * se passiamo un indirizzo in decimal dotted.
 * @author Fabio
 * @version 1.0
 * @created 17-feb-2015 18.00.01
 */
public interface ICommunicator {

	/**
	 * 
	 * @param ip
	 * @param port
	 */
	public int connect(String ip, int port) throws Exception;

	/**
	 * 
	 * @param connectionId
	 */
	public void disconnect(int connectionId) throws Exception;

	public void closeServer(int serverPort) throws Exception;
	/**
	 * 
	 * @param connectionId
	 */
	public String read(int connectionId) throws Exception;

	/**
	 * 
	 * @param connectionId
	 * @param data
	 */
	public void write(int connectionId, String data) throws Exception;

}