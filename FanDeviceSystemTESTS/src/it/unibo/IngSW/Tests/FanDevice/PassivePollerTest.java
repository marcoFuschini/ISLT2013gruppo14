package it.unibo.IngSW.Tests.FanDevice;

import static org.junit.Assert.*;

import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.IngSW.FanDevice.PassivePoller;
import it.unibo.IngSW.FanDevice.interfaces.IPassiveSensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.interfaces.ISensorData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PassivePollerTest {
	
	PassivePoller pp;
	IPassiveSensor sen;
	ArrayBlockingQueue<ISensorData[]>dataBuffer=new ArrayBlockingQueue<ISensorData[]>(5);

	@Test
	public void testAddRemoveSensor() {
		pp=new PassivePoller(dataBuffer);
		sen=new IPassiveSensor() {
			
			@Override
			public String getValue() {
				return "1";
			}
			
			@Override
			public String getName() {
				return "PRIMO";
			}
		};
		pp.addSensor(sen);
		
		assertEquals("Add not work",sen, pp.m_IPassiveSensor.get(0));
		
		int c=pp.m_IPassiveSensor.size();
		pp.removeSensor(sen);
		
		assertEquals("Remove not work",c-1, pp.m_IPassiveSensor.size());
	}
	
	@Test
	public void testPauseKill() {
		pp=new PassivePoller(dataBuffer);
		sen=new IPassiveSensor() {
			
			@Override
			public String getValue() {
				return "1";
			}
			
			@Override
			public String getName() {
				return "PRIMO";
			}
		};
		pp.addSensor(sen);
		
		Thread t = new Thread(pp);
		t.start();
		
		try {
			Thread.sleep(PassivePoller.DT+500);
			pp.pause();
			int c=dataBuffer.size();
			assertNotEquals("Thread sedData error",0,c);
			
			Thread.sleep(PassivePoller.DT*2);	
			assertEquals("pause blocca il thread",c, dataBuffer.size());
			
			pp.kill();
			Thread.sleep(PassivePoller.DT*2);
			
			assertFalse("kill error", t.isAlive());
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
