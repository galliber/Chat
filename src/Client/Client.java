package Client;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String args[]) throws IOException, ClassNotFoundException 
	{
		//Server ip in ""
		String ip="";
		Socket s=new Socket(ip, 1211);
		
		Send send=new Send(s);
		send.start();
		Receive receive=new Receive(s);
		receive.start();
		
		
	}
}