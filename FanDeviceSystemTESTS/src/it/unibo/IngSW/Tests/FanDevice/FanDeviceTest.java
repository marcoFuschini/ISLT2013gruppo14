package it.unibo.IngSW.Tests.FanDevice;

import static org.junit.Assert.fail;
import it.unibo.IngSW.FanDevice.FanSpeed;
import it.unibo.IngSW.FanDevice.interfaces.IActuator;
import it.unibo.IngSW.FanDevice.interfaces.IFanDevice;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.IComunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FanDeviceTest {

	IFanDevice fd;
	IActuator fan;
	ArrayBlockingQueue<SensorData[]> dataBuffer=new ArrayBlockingQueue<>(20);
	IComunication comm;
	ISensor sensor;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		comm=new IComunication() {
			
			@Override
			public void writeData(String data) {
								
			}
			
			@Override
			public String readData() {
				return "dataRead";
			}
			
			@Override
			public boolean disconnect() {
				return true;
			}
			
			@Override
			public boolean connect(String fanDeviceIP) {
				return true;
			}
		};
		
		sensor= new ISensor() {
			boolean live=true;
			Semaphore pause=new Semaphore(1);
			
			@Override
			public void run() {
				try {
					do{
						pause.acquire();
						dataBuffer.put(new SensorData[] {new SensorData("sensorTest", "23")});
						Thread.sleep(1000);
						pause.release();
					}while(live);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void resume() {
				pause.release();
			}
			
			@Override
			public void pause() {
				try {
					pause.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void kill() {
				live=false;				
			}
		};
		
		fan = new IActuator() {
			
			@Override
			public void setSpeed(FanSpeed speed) {
				
			}
			
			@Override
			public void incSpeed() {
				
			}
			
			@Override
			public void decSpeed() {
				
			}
		};
	}

	@AfterClass
	public void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddSensor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testReceiveCommand() {
		fail("Not yet implemented");
	}

	@Test
	public void testReceiveSensorData() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSensor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendDataSensorDataArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSpeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendDataISensorDataArray() {
		fail("Not yet implemented");
	}

}
