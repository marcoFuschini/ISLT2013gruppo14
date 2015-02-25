package it.unibo.IngSW.ControlUnit;

import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.FanSpeed;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlCmdConsole implements IControlCmdConsole {

	private ArrayBlockingQueue<String> buffer;

	public ControlCmdConsole() {
		buffer = new ArrayBlockingQueue<String>(ControlUnit.CMDBUFFERMAXSIZE);
	}

	public boolean decSpeed() {
		try {
			buffer.put(Command.DECSPEED.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean incSpeed() {
		try {
			buffer.put(Command.INCSPEED.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String readCommand() {
		try {
			return buffer.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 
	 * @param speed
	 */
	public boolean setSpeed(FanSpeed speed) {
		try {
			switch (speed) {
			case LOWSPEED:
				buffer.put(Command.LOWSPEED.toString());
				break;
			case MEDIUMSPEED:
				buffer.put(Command.MEDIUMSPEED.toString());
				break;
			case HIGHSPEED:
				buffer.put(Command.HIGHSPEED.toString());
				break;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean start() {
		System.out.println("inserisco start nel buffer");
		try {
			buffer.put(Command.START.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean stop() {
		try {
			buffer.put(Command.STOP.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}