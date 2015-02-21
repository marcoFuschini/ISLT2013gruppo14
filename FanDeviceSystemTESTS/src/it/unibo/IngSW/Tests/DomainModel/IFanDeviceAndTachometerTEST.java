package it.unibo.IngSW.Tests.DomainModel;



import static org.junit.Assert.assertTrue;
import it.unibo.IngSW.Simulatori.SimFanDevice;
import it.unibo.IngSW.Simulatori.SimTachometer;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.IFanDevice;
import it.unibo.IngSW.common.interfaces.ITachometer;

import org.junit.Test;

public class IFanDeviceAndTachometerTEST {

	IFanDevice fandev = new SimFanDevice();
	ITachometer tac = new SimTachometer((SimFanDevice)fandev);

	@Test
	public void test() {
		try {
			double val;
			fandev.setSpeed(FanSpeed.ZEROSPEED);
			val=tac.getValue();
			assertTrue("0="+val,0d==val);
			fandev.setSpeed(FanSpeed.MEDIUMSPEED);
			Thread.sleep(500);
			val=tac.getValue();
			assertTrue((val >= FanSpeed.MEDIUMSPEED.getRevolMin())
					&& (val <= FanSpeed.MEDIUMSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.LOWSPEED);
			
			Thread.sleep(500);
			val=tac.getValue();
			assertTrue((val >= FanSpeed.LOWSPEED.getRevolMin())
					&& (val <= FanSpeed.LOWSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.HIGHSPEED);
			
			Thread.sleep(500);
			val=tac.getValue();
			assertTrue((val >= FanSpeed.HIGHSPEED.getRevolMin())
					&& (val <= FanSpeed.HIGHSPEED.getRevolMax()));
			fandev.setSpeed(FanSpeed.ZEROSPEED);
			
			Thread.sleep(5000);
			val=tac.getValue();
			assertTrue("0="+val,0d==val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
