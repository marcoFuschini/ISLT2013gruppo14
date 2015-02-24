package it.unibo.IngSW.Tests.FanDevice;

import static org.junit.Assert.*;
import it.unibo.IngSW.ControlUnit.ControlUnitCommunicator;
import it.unibo.IngSW.FanDevice.FanDeviceCommunicator;
import it.unibo.IngSW.Viewer.ViewerCommunicator;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;

import org.junit.Assert;
import org.junit.Test;

public class ServerComunicatorTest {

	private static final int CUPORT=10001;
	private static final int VPORT=10002;
	
	private FanDeviceCommunicator fdcomm=new FanDeviceCommunicator();
	private ViewerCommunicator vcomm1=new ViewerCommunicator();
	private ViewerCommunicator vcomm2=new ViewerCommunicator();
	private ControlUnitCommunicator ccomm=new ControlUnitCommunicator();
	
	
	private void scrivi(String s){
		System.out.println(s);
	}
	
	@Test
	public void test() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					fdcomm.connect(VPORT, CUPORT);
					String s=fdcomm.receiveCommand();
					scrivi(s);
					fdcomm.sendData(new ISensorData[]{new SensorData("nome1", "val1")});
					ok();
					
//					fdcomm.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		});
		
		t.start();
		try {
			ccomm.connect("127.0.0.1", CUPORT);
			vcomm1.connect("127.0.0.1", VPORT);
			vcomm2.connect("127.0.0.1", VPORT);
			
			ccomm.sendCommand(JSONConverter.commandToJSON("START"));
			ISensorData[] data1=vcomm1.receiveData();
			ISensorData[] data2=vcomm2.receiveData();
			SensorData sd1=(SensorData)data1[0];
			SensorData sd2=(SensorData)data2[0];
			assertTrue(sd1.equals(sd2));
			
			ccomm.disconnect();
			vcomm1.disconnect();
			vcomm2.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void ok() {
		System.out.println("ok");
	}


}
