package de.us.rpi.basetest;

import java.net.InetAddress;


public class HelloWorld {

	public static void main(String[] args) {
		try {
			String hostname = InetAddress.getLocalHost().getHostName();
			System.out.println("Hallo Welt, von "+hostname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
