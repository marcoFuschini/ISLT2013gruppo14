package it.unibo.IngSW.FanDevice.interfaces;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public interface ISensorPoller extends Runnable {
/*
	public ISensorDataBuffer m_ISensorDataBuffer;
	public ISensor m_ISensor;
*/
	public void kill();

}