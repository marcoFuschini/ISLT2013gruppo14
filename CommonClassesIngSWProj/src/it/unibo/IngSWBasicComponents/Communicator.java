package it.unibo.IngSWBasicComponents;

import it.unibo.IngSW.common.interfaces.ICommunicator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Communicator implements ICommunicator {

	private ArrayList<Socket> ids = new ArrayList<Socket>();
	private ArrayList<BufferedReader> brs=new ArrayList<BufferedReader>();
	private ArrayList<PrintWriter> pws=new ArrayList<PrintWriter>();
	private HashMap<Integer, ServerSocket> servers = new HashMap<Integer, ServerSocket>();

	@Override
	public int connect(String ip, int port) throws Exception {
		if ("server".equals(ip)) {
			ServerSocket ss = servers.get(port);
			if (ss == null) {
				ss = new ServerSocket(port);
				servers.put(port, ss);
			}
			Socket s=ss.accept();

			synchronized (this) {
				brs.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
				pws.add(new PrintWriter(s.getOutputStream(),true));
				ids.add(s);
				return (ids.size() - 1);
			}
		} else {
			Socket s = new Socket();
			s.connect(new InetSocketAddress(ip, port), 5000);

			synchronized (this) {
				brs.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
				pws.add(new PrintWriter(s.getOutputStream(),true));
				ids.add(s);
				return (ids.size()-1);
			}
		}
	}

	@Override
	public void disconnect(int connectionId) throws Exception {
		arraylistTest(connectionId);
		Socket s = ids.get(connectionId);
		s.close();
		pws.get(connectionId).close();
		brs.get(connectionId).close();
		ids.set(connectionId,null);
		pws.set(connectionId,null);
		brs.set(connectionId,null);
	}
	
	@Override
	public void closeServer(int serverPort) throws Exception{
		ServerSocket ss=servers.get(new Integer(serverPort));
		if(ss==null){
			throw new Exception("server port not open");
		}else{
			ss.close();
			servers.remove(new Integer(serverPort));
		}
	}

	@Override
	public String read(int connectionId) throws Exception {
		arraylistTest(connectionId);
		String str=brs.get(connectionId).readLine();
		return str;
	}

	@Override
	public void write(int connectionId, String data) throws Exception {
		arraylistTest(connectionId);
		pws.get(connectionId).println(data);
	}

	private void arraylistTest(int i) throws Exception {
		synchronized (this) {
			if ((i >= ids.size()) || (i < 0)) {
				throw new Exception("Invalid ID");
			} else {
				if (ids.get(i) == null) {
					throw new Exception("Socket not present");
				}
			}
		}
	}
}