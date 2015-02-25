package it.unibo.IngSW.ControlUnit;

import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IInputPoller;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.IButton;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class InputPoller implements IInputPoller {

	private IControlCmdConsole controlCmdConsole;
	private IButton[] buttons;
	private boolean run = true;

	// i bottoni sono da passare in fila
	// start,stop,low,mid,hig,dec,inc
	public InputPoller(IControlCmdConsole controlcmdconsole, IButton[] buttons) {
		this.controlCmdConsole = controlcmdconsole;
		this.buttons = buttons;
		Thread t = new Thread(this);
		t.start();
	}

	public void finalize() throws Throwable {

	}

	public void kill() {
		run = false;
	}

	public void run() {
		System.out.println("INPUTPOLLER: inizio loop");
		do {
			if (buttons[0].isPressed()) {
				if (!controlCmdConsole.start()) {
					run = false;
				}
				;
			}
			if (buttons[1].isPressed()) {
				if (!controlCmdConsole.stop()) {
					run = false;
				}
				;
			}
			if (buttons[2].isPressed()) {
				if (!controlCmdConsole.setSpeed(FanSpeed.LOWSPEED)) {
					run = false;
				}
				;
			}
			if (buttons[3].isPressed()) {
				if (!controlCmdConsole.setSpeed(FanSpeed.MEDIUMSPEED)) {
					run = false;
				}
				;
			}
			if (buttons[4].isPressed()) {
				if (!controlCmdConsole.setSpeed(FanSpeed.HIGHSPEED)) {
					run = false;
				}
				;
			}
			if (buttons[5].isPressed()) {

				if (!controlCmdConsole.decSpeed()) {
					run = false;
				}
				;
			}
			if (buttons[6].isPressed()) {

				if (!controlCmdConsole.incSpeed()) {
					run = false;
				}
				;
			}
		} while (run);
		
		System.out.println("INPUTPOLLER: chiudo");
	}

}