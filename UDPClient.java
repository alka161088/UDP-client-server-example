/****************************************************************
Author : Alka Raghav
Compile: javac UDPClient.java
Run    : java UDPClient
****************************************************************/

import java.net.*;
import java.io.*;

public class UDPClient{
	public static void main(String args[]){
		// args give message contents and server hostname
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			InetAddress aHost = InetAddress.getByName(args[0]);
			int serverPort = 6789;
			
			while(true){
				System.out.println("Enter a character string: as input: ");
				String input = System.console().readLine();
				byte [] m = input.getBytes();
				DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
				aSocket.send(request);
				byte[] buffer = new byte[1000];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(reply);
				System.out.println("Reply: " + new String(reply.getData()) + "\n");
			}
			
		} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		} catch (IOException e){System.out.println("IO: " + e.getMessage());
		} finally { if(aSocket != null) aSocket.close();}
	}
}
	