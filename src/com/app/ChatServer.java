package com.app;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args){
		try {
			ServerSocket ss = new ServerSocket(2019);
			Socket s=ss.accept();
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			
			BufferedReader bRead=new BufferedReader(new InputStreamReader(System.in));
			
			String msgin="",msgout="";
			
			while (!msgin.equals("end")) {
				msgin=din.readUTF();
				System.out.println(msgin);
				msgout=bRead.readLine();
				dout.writeUTF(msgout);
				dout.flush();
			}
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
