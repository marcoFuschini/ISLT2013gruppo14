package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.interfaces.IButton;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IInputPoller extends Runnable {

	/*public IButton m_IButton;
	public IControlCmdConsole m_IControlCmdConsole;*/

	public void kill();

	public void run();

}