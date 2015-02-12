package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import it.unibo.IngSW.FanDevice.FanSpeed;
import it.unibo.IngSW.FanDevice.interfaces.IFanDevice;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class IFanDeviceAndTachometerTEST {

	IFanDevice fandev=new FanDevice();
	ISensor tac=new Tachometer();
	
	@Test
	public void test() {
		fandev.setSpeed(FanSpeed.ZEROSPEED);
		assertEquals(0d,tac.getValue());
		fandev.setSpeed(FanSpeed.MEDIUMSPEED);
		Thread.sleep(500);
		assertTrue((tac.getValue()>=FanSpeed.MEDIUMSPEED.getRevolMin())&&(tac.getValue()<=FanSpeed.MEDIUMSPEED.getRevolMax()));
		fandev.setSpeed(FanSpeed.LOWSPEED);
		Thread.sleep(500);
		assertTrue((tac.getValue()>=FanSpeed.LOWSPEED.getRevolMin())&&(tac.getValue()<=FanSpeed.LOWSPEED.getRevolMax()));
		fandev.setSpeed(FanSpeed.HIGHSPEED);
		Thread.sleep(500);
		assertTrue((tac.getValue()>=FanSpeed.HIGHSPEED.getRevolMin())&&(tac.getValue()<=FanSpeed.HIGHSPEED.getRevolMax()));
		fandev.setSpeed(FanSpeed.ZEROSPEED);
		Thread.sleep(5000);
		assertEquals(0d,tac.getValue());
	}

}
