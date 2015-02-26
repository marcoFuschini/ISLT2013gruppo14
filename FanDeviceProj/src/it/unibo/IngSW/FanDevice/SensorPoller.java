package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.FanDevice.interfaces.ISensorPoller;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorPoller implements ISensorPoller {
	private ISensor[] sensors;
	private ISensorDataBuffer buf;
	private boolean run;
	private int dt;
	public SensorPoller(ISensor[] sensors,ISensorDataBuffer buffer,int deltaTimeMillis){
		this.sensors=sensors;
		buf=buffer;
		run=true;
		dt=deltaTimeMillis;
	}

	public void finalize() throws Throwable {

	}

	public void kill(){
		run=false;
	}

	@Override
	public void run() {
		while(run){
			try {
				Thread.sleep(dt);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
			ISensorData[] data=new SensorData[sensors.length];
			for(int i=0;i<sensors.length;i++){
				data[i]=new SensorData(sensors[i].getName(),""+sensors[i].getValue());
			}
			try {
				buf.put(data);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
//		System.out.println("SensorPoller terminato");
	}

}