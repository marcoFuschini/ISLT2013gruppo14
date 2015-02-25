package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceDecorator;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.FanDevice.interfaces.ISensorPoller;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.SensorName;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceMain {

	private static final double TLIMIT1=27.0;
	private static final double TLIMIT2=30.0;
	
	
	public FanDeviceMain(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		ISensorDataBuffer buffer=new SensorDataBuffer(2048);
		IFanDeviceDecorator fd=new FanDeviceDecorator(buffer);
		ISensor tach=new Sensor(new Tachometer(), SensorName.SPEED.toString());
		ISensor term=new Sensor(new Thermometer(), SensorName.TEMPERATURE.toString());
		ISensor[] tachArray=new ISensor[]{tach};
		ISensor[] termArray=new ISensor[]{term};
		ISensorPoller tachPoller=new SensorPoller(tachArray, buffer, 0);
		ISensorPoller termPoller=new SensorPoller(termArray, buffer, 1500);
		try {
			fd.connect(10001, 10002);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(tachPoller).start();
		new Thread(termPoller).start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					while(true){
						Double temp=null;
						Double oldTemp=null;
						ISensorData[] data =fd.getSensorData();
						fd.sendData(data);
						
						for(ISensorData d:data){
							if(d.getName().equals(SensorName.TEMPERATURE)){
								temp=Double.parseDouble(d.getValue());
								if(oldTemp!=null){
									if(oldTemp<=TLIMIT2 && temp>TLIMIT2){
										fd.incSpeed();
									}else if(oldTemp<=TLIMIT1 && temp>TLIMIT1){
										fd.stop();
									}									
								}
								oldTemp=temp;
							}
						}
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		
		try {
			while(true){
			String cmd=fd.receiveCommand();
			Command command=Command.StringToCommand(cmd);
			switch(command){
			case START:
				fd.start();
				break;
			case STOP:
				fd.stop();
				break;
			case INCSPEED:
				fd.incSpeed();
				break;
			case DECSPEED:
				fd.decSpeed();
				break;
			case LOWSPEED:
				fd.setSpeed(FanSpeed.LOWSPEED);
				break;
			case MEDIUMSPEED:
				fd.setSpeed(FanSpeed.MEDIUMSPEED);
				break;
			case HIGHSPEED:
				fd.setSpeed(FanSpeed.HIGHSPEED);
				break;
			default:
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}