package it.unibo.IngSW.Tests.FanDevice;

import static org.junit.Assert.*;
import it.unibo.IngSW.ControlUnit.ControlUnitCommunicator;
import it.unibo.IngSW.FanDevice.FanDeviceDecorator;
import it.unibo.IngSW.FanDevice.SensorDataBuffer;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.Viewer.ViewerCommunicator;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.IFanDevice;
import it.unibo.IngSW.common.interfaces.ISensorData;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FanDeviceTest {

	private static final int VPORT=10001;
	private static final int CUPORT=10002;
	
	private FanDeviceDecorator fandec;
	private SensorDataBuffer buff=new SensorDataBuffer(100);
	private ISensorData[] datatosend=new ISensorData[]{new SensorData("nome", "val")};
	
	private void ok(String s){
		System.out.println("OK "+s);
	}
	
	private void ok(){
		ok("");
	}
	
	@Test
	public void test() {
		Thread cu= new Thread(new Runnable() {
			
			@Override
			public void run() {
				ControlUnitCommunicator cucomm=new ControlUnitCommunicator();
				try {
					cucomm.connect("127.0.0.1", CUPORT);
					cucomm.sendCommand("START");
					ok();
					ISensorData[] data=cucomm.receiveData();
					assertTrue(((SensorData)datatosend[0]).equals(data[0]));
				} catch (Exception e) {
					fail("eccezione non prevista");
					e.printStackTrace();
				}
				
				try{
				cucomm.receiveData();
				fail("receive data doveva lanciare eccezione");
				}catch (Exception e){
					
				}
			}
			
		});
		
		Thread v1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				ViewerCommunicator vcomm=new ViewerCommunicator();
				try {
					vcomm.connect("127.0.0.1", VPORT);
					ISensorData[] data=vcomm.receiveData();
					assertTrue(((SensorData)datatosend[0]).equals(data[0]));
				} catch (Exception e) {
					fail("eccezione non prevista");
					e.printStackTrace();
				}
				
				try{
					vcomm.receiveData();
					fail("receive data doveva lanciare eccezione");
					}catch (Exception e){
											
				}
			}
			
		});
		
		
		fandec=new FanDeviceDecorator(buff);
		try {
			cu.start();
			fandec.connect(VPORT, CUPORT);
			v1.start();
			String s=fandec.receiveCommand();
			ok(s);
			assertTrue(s.equals("START"));
			fandec.sendData(datatosend);
			fandec.disconnect();
		} catch (Exception e) {
			fail("eccezione non prevista");
			e.printStackTrace();
		}
		
		
	}


}
