package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import it.unibo.IngSW.FanDevice.FanDevice;
import it.unibo.IngSW.FanDevice.FanSpeed;
import it.unibo.IngSW.FanDevice.interfaces.IFanDevice;
import it.unibo.IngSW.Tests.CLASSES.Tachometer;
import it.unibo.IngSW.Tests.CLASSES.interfaces.ITachometer;

import org.junit.Test;

public class IFanDeviceAndTachometerTEST {

	IFanDevice fandev = new FanDevice();
	ITachometer tac = new Tachometer();

	@Test
	public void test() {
		try {
			fandev.setSpeed(FanSpeed.ZEROSPEED);
			assertEquals(0d, tac.getValue());
			fandev.setSpeed(FanSpeed.MEDIUMSPEED);
			Thread.sleep(500);
			assertTrue((tac.getValue() >= FanSpeed.MEDIUMSPEED.getRevolMin())
					&& (tac.getValue() <= FanSpeed.MEDIUMSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.LOWSPEED);
			Thread.sleep(500);
			assertTrue((tac.getValue() >= FanSpeed.LOWSPEED.getRevolMin())
					&& (tac.getValue() <= FanSpeed.LOWSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.HIGHSPEED);
			Thread.sleep(500);
			assertTrue((tac.getValue() >= FanSpeed.HIGHSPEED.getRevolMin())
					&& (tac.getValue() <= FanSpeed.HIGHSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.ZEROSPEED);
			Thread.sleep(5000);
			assertEquals(0d, tac.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
