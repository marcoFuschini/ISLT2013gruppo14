package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.unibo.IngSW.Tests.CLASSES.Communication;
import it.unibo.IngSW.Tests.CLASSES.interfaces.ICommunicator;

import org.junit.Test;

public class IComunicationTEST {

	ICommunicator server, client,client2;

	@Test
	public void test() {
		server=new Communication();
		client=new Communication();
		client2=new Communication();
		int cid,cid2=0;
		Thread st = new Thread(new Runnable() {
			@Override
			public void run() {
				int rcid=0;
				int rcid2=0;
				try{
					rcid=server.connect("server",10001);
					rcid2=server.connect("server",10001);
					assertEquals("sono2",server.read(rcid2));
					assertEquals("sono1", server.read(rcid));
					server.write(rcid,"sei1");
					server.write(rcid2,"sei2");
					server.disconnect(rcid);
				}catch(Exception e){
					e.printStackTrace();
					fail("Server error");
				}
				try{
					String s=server.read(rcid2);
				}finally{
					fail("Server disconnect error");
				}
			}
		});
		
		try{
			client.connect(null,10001);
			fail("connect wrong parameters");
		}catch(Exception e){
			
		}
		try{
			client.connect("",10001);
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
		long pre=0,post;
		try{
			pre=System.currentTimeMillis();
			client.connect("127.0.0.1",10001);
			fail("connect timeout error");
		}catch(Exception e){
			post=System.currentTimeMillis();
			assertTrue((post-pre)>=5000);
		}
		
		st.start();
		try{
			cid=client.connect("127.0.0.1",10001);
			cid2=client2.connect("127.0.0.1",10001);
			client.write(cid,"sono1");
			client2.write(cid2,"sono2");
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
		}finally{
			fail("Client disconnect error");
		}
		
		
		
	}
}
