package network.body;

import java.util.ArrayList;
import java.util.Arrays;

public class client {

	public String IP = "0.0.0.0";
	ArrayList<String> dataIP = new ArrayList<String>();
	ArrayList<String> backupIP = new ArrayList<String>();

	public client(String IP, String[] dataIP, String[] backupIP) {
		this.IP = IP;
		this.dataIP.addAll(Arrays.asList(dataIP));
		this.backupIP.addAll(Arrays.asList(backupIP));
	}

	public void dataIPadd(String[] IP) {
		this.dataIP.addAll(Arrays.asList(IP));
	}

	public void backupIPadd(String[] IP) {
		this.dataIP.addAll(Arrays.asList(IP));
	}

	public void dataIPset(String[] IP) {
		this.dataIP = (ArrayList<String>) Arrays.asList(IP);
	}

	public void backupIPset(String[] IP) {
		this.dataIP = (ArrayList<String>) Arrays.asList(IP);
	}
}
