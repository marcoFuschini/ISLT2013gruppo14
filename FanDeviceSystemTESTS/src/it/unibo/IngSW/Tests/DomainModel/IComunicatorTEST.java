package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.unibo.IngSW.Tests.CLASSES.Communicator;
import it.unibo.IngSW.Tests.CLASSES.interfaces.ICommunicator;

import org.junit.Test;

public class IComunicatorTEST {

	private final int serverPort1=10001,serverPort2=10002;
	ICommunicator server, client,client2;

	private void scrivi(String s){
		System.out.println(s);
	}
	@Test
	public void test() {
		server=new Communicator();
		client=new Communicator();
		client2=new Communicator();
		int cid=0,cid2=0;
		Thread st = new Thread(new Runnable() {
			@Override
			public void run() {
				int rcid=0;
				int rcid2=0;
				try{
					scrivi("ProvoConnessione1");
					rcid=server.connect("server",serverPort1);
					scrivi("Connesso1 id="+rcid+" provo2");
					rcid2=server.connect("server",serverPort2);
					scrivi("Connesso2 id="+rcid2+" provoread2");
					assertEquals("sono2",server.read(rcid2));
					scrivi("provoread1");
					assertEquals("sono1", server.read(rcid));
					server.write(rcid,"sei1");
					server.write(rcid2,"sei2");
					server.disconnect(rcid);
				}catch(Exception e){
					scrivi("THREAD EX");
					e.printStackTrace();
					fail("Server error");
				}
				try{
					String s=server.read(rcid2);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					fail("Server disconnect error");
				}
			}
		});
		
		try{
			client.connect(null,serverPort1);
			fail("connect wrong parameters");
		}catch(Exception e){
			
		}
		try{
			client.connect("",serverPort1);
			fail("connect wrong parameters");
		}catch(Exception e){
			
		}
		try{
			client.connect("127.0.0.1",-1);
			fail("connect wrong parameters");
		}catch(Exception e){
			
		}
		try{
			client.read(100);
			fail("read wrong cid");
		}catch(Exception e){
			
		}
		try{
			client.write(100,"ciao");
			fail("write wrong cid");
		}catch(Exception e){
			
		}
		try{
			client.disconnect(100);
			fail("disconnect wrong cid");
		}catch(Exception e){
			
		}
	/*	long pre=0,post;
		try{
			pre=System.currentTimeMillis();
			client.connect("127.0.0.1",10001);
			fail("connect timeout error");
		}catch(Exception e){
			e.printStackTrace();
			post=System.currentTimeMillis();
			assertTrue("Pre:"+pre+" Post:"+post,(post-pre)>=5000);
		}*/
		
		st.start();
		try{
			cid=client.connect("127.0.0.1",serverPort1);
			cid2=client2.connect("127.0.0.1",serverPort2);
			client2.write(cid2,"sono2");
			client.write(cid,"sono1");
			assertEquals("sei2",client2.read(cid2));
			assertEquals("sei1", client.read(cid));
			client2.disconnect(cid2);
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Client error");
			return;
		}
		try{
			String s=client.read(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fail("Client disconnect error");
		}
		
		
		
	}
}
