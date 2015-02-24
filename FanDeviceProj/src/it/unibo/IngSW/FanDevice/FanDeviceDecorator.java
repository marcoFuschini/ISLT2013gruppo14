package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceDecorator;
import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceDecorator implements IFanDeviceDecorator {

	private ISensorDataBuffer buffer;
	private IFanDeviceCommunicator comm;
	private FanDevice fd;
	private FanSpeed currentSpeed;
	private boolean active;
	
	public FanDeviceDecorator(IFanDeviceCommunicator comm,ISensorDataBuffer buf){
		this.comm=comm;
		buffer=buf;
		fd=new FanDevice();
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
		return buffer.take();
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

}