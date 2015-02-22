package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.Display;
import it.unibo.IngSW.common.TachometerDisplay;
import it.unibo.IngSW.common.ThermometerDisplay;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnitMain {

	private static IControlUnit controlUnit;
	private static Display display;
	private static IControlUnitCommunicator communicator;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		//init
		communicator=new ControlUnitCommunicator();
		display=new Display(new IElementDisplay[]{
				new TachometerDisplay(),
				new ThermometerDisplay()
		});
		controlUnit=new ControlUnit(communicator, display);
		
		
	}

}