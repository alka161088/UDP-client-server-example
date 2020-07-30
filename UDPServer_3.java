/****************************************************************
Author : Alka Raghav
Compile: javac UDPServer_3.java
Run    : java UDPServer_3
****************************************************************/

import java.net.*;
import java.io.*;

public class UDPServer_3{
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
				 
				try {
				    Process process = Runtime.getRuntime().exec(value.trim());

				    StringBuffer sb = new StringBuffer();
				 
				    BufferedReader reader = new BufferedReader(
				            new InputStreamReader(process.getInputStream()));
				    String line;
				    while ((line = reader.readLine()) != null) {
				        System.out.println(line);
				        sb.append(line);
				    }

				    String singleStr = sb.toString();

				    DatagramPacket reply = new DatagramPacket(singleStr.getBytes(), singleStr.getBytes().length,  request.getAddress(),request.getPort()); 
					aSocket.send(reply);
				 
				    reader.close();
				 
				} catch (IOException e) {
					String singleStr = e.toString();

				    DatagramPacket reply = new DatagramPacket(singleStr.getBytes(), singleStr.getBytes().length,  request.getAddress(),request.getPort()); 
					aSocket.send(reply);

				}

				
			}
		} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {System.out.println("IO: " + e.getMessage());
		} finally {if (aSocket != null) aSocket.close();}
	}
}
