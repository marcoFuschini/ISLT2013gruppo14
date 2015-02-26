package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceDecorator;
import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.SensorName;
import it.unibo.IngSW.common.interfaces.IFanDevice;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceDecorator implements IFanDeviceDecorator {

	private ISensorDataBuffer buffer;
	private IFanDeviceCommunicator comm;
	private IFanDevice fd;
	private FanSpeed currentSpeed;
	private boolean active;
	
	public FanDeviceDecorator(ISensorDataBuffer buf,IFanDevice fd){
		comm=new FanDeviceCommunicator();
		buffer=buf;
//		fd=new FanDevice();
		this.fd=fd;
		currentSpeed=FanSpeed.ZEROSPEED;
		active=false;
	}

	public void finalize() throws Throwable {
		
	}

	/**
	 * 
	 * @param viewerPort
	 * @param controlUnitPort
	 * @throws Exception 
	 */
	public void connect(int viewerPort, int controlUnitPort) throws Exception{
		comm.connect(viewerPort, controlUnitPort);
	}

	public void decSpeed(){
		if(active){
			switch(currentSpeed){
				case HIGHSPEED:
					fd.setSpeed(FanSpeed.MEDIUMSPEED);
					break;
				case MEDIUMSPEED:
					fd.setSpeed(FanSpeed.LOWSPEED);
					break;
				default: 
			}
		}
	}

	public ISensorData[] getSensorData() throws InterruptedException{
		ISensorData[] data=buffer.take();
		ISensorData[] newData=new ISensorData[data.length+1];
		for(int i=0;i<data.length;i++){
			newData[i]=data[i];
		}
		if(active){
			newData[newData.length-1]=new SensorData(SensorName.STATE.toString(), "1.0");
		}else{
			newData[newData.length-1]=new SensorData(SensorName.STATE.toString(), "0.0");
		}
		return newData;
	}

	public void incSpeed(){
		if(active){
			switch(currentSpeed){
				case LOWSPEED:
					fd.setSpeed(FanSpeed.MEDIUMSPEED);
					break;
				case MEDIUMSPEED:
					fd.setSpeed(FanSpeed.HIGHSPEED);
					break;
				default: 
			}
		}
	}

	public String receiveCommand() throws Exception{
		return comm.receiveCommand();
	}

	/**
	 * 
	 * @param data
	 * @throws Exception 
	 */
	public void sendData(ISensorData[] data) throws Exception{
		comm.sendData(data);
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed){
		currentSpeed=speed;
		if(active){
			fd.setSpeed(currentSpeed);
		}
	}

	@Override
	public void start() {
		if(active||currentSpeed==FanSpeed.ZEROSPEED){
			return;
		}
		fd.setSpeed(currentSpeed);
		active=true;
	}

	@Override
	public void stop() {
		if(!active){
			return;
		}
		currentSpeed=FanSpeed.ZEROSPEED;
		fd.setSpeed(currentSpeed);
		active=false;
	}

	@Override
	public void disconnect() {
		comm.disconnect();
	}

}