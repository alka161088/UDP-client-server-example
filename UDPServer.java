/****************************************************************
Author : Alka Raghav
Compile: javac UDPServer.java
Run    : java UDPServer
****************************************************************/

import java.net.*;
import java.io.*;

public class UDPServer{
	public static void main(String args[]){
		DatagramSocket aSocket = null;
		try{
			aSocket = new DatagramSocket(6789);
			System.out.println("UDP Server listening on port :"+6789);
			while(true){
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				String value = new String(request.getData(), "UTF-8");
				System.out.println("Received from client :"+value);
				DatagramPacket reply = new DatagramPacket(request.getData(),
				request.getLength(), request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
		} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {System.out.println("IO: " + e.getMessage());
		} finally {if (aSocket != null) aSocket.close();}
	}
}
