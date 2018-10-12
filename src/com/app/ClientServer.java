package com.app;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServer {
	public static void main(String[] args) {
		
		Socket s;
		try {
			s = new Socket("127.0.0.7", 2019);
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			
			BufferedReader bRead=new BufferedReader(new InputStreamReader(System.in));
			
			String msgin="",msgout="";
			
			while (!msgin.equals("end")) {
				msgout=bRead.readLine();
				dout.writeUTF(msgout);
				msgin=din.readUTF();
				System.out.println(msgin);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
