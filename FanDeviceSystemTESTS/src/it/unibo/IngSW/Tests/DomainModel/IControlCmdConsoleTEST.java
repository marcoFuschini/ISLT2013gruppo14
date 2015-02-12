package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.*;

import java.util.Timer;
import java.util.concurrent.Semaphore;

import it.unibo.IngSW.ControlUnit.ControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.FanDevice.FanSpeed;

import org.junit.Test;

public class IControlCmdConsoleTEST {

	IControlCmdConsole cmd=new ControlCmdConsole();
	
	@Test
	public void test() {
		String com;
		cmd.start();
		com=cmd.readCommand();
		assertEquals("\"command\": \"START\"", com);
		cmd.incSpeed();
		com=cmd.readCommand();
		assertEquals("\"command\": \"INC\"", com);
		cmd.decSpeed();
		com=cmd.readCommand();
		assertEquals("\"command\": \"DEC\"", com);
		cmd.setSpeed(FanSpeed.MEDIUMSPEED);
		com=cmd.readCommand();
		assertEquals("\"command\": \"SETSPEED\",\"value\":\"MEDIUMSPEED\"", com);
		cmd.stop();
		com=cmd.readCommand();
		assertEquals("\"command\": \"STOP\"", com);
		
		
		cmd.incSpeed();
		cmd.decSpeed();
		com=cmd.readCommand();
		assertEquals("\"command\": \"INC\"", com);		
		com=cmd.readCommand();
		assertEquals("\"command\": \"DEC\"", com);
	
		Thread t =new Thread(new Runnable() {
			@Override
			public void run() {
				
				long pre=System.currentTimeMillis();
				com=cmd.readCommand();
				long post=System.currentTimeMillis();
				assertTrue((post-pre)>=4500);
			}
		});
		
		t.start();
		Thread.sleep(5000);
		cmd.incSpeed();
		
	}

}
