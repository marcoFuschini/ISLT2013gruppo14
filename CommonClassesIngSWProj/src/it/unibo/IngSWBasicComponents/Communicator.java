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
	private HashMap<Integer, ServerSocket> servers = new HashMap<Integer, ServerSocket>();

	@Override
	public int connect(String ip, int port) throws Exception {

		if ("server".equals(ip)) {
			ServerSocket ss = servers.get(port);
			if (ss == null) {
				ss = new ServerSocket(port);
				servers.put(port, ss);
			}
			synchronized (this) {
				ids.add(ss.accept());
				return (ids.size() - 1);
			}
		} else {
			Socket s = new Socket();
			s.connect(new InetSocketAddress(ip, port), 5000);
			synchronized (this) {
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
		ids.set(connectionId, null);
	}

	@Override
	public String read(int connectionId) throws Exception {
		arraylistTest(connectionId);
		Socket s = ids.get(connectionId);
		InputStreamReader isr=new InputStreamReader(s.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String str=br.readLine();
		//br.close();
		return str;
	}

	@Override
	public void write(int connectionId, String data) throws Exception {
		arraylistTest(connectionId);
		Socket s = ids.get(connectionId);
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		/*OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
		BufferedWriter bw=new BufferedWriter(osw);
		bw.write(data);*/
		pw.println(data);
		if(!s.isConnected()){
			throw new Exception("socket not connected");
		};
		//bw.close();
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
