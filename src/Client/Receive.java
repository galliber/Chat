package Client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Receive extends Thread
{
	private Socket client;
	public Receive(Socket client)
	{
		this.client=client;
	}
	
	@Override
	public void run()
	{
		try
		{
		String str;
		Scanner sc=new Scanner(client.getInputStream());
		
		while((str=sc.nextLine()) != null)
		{
			if(str!=null)
				System.out.println(str);
		}
		}catch(Exception e)
		{
			System.out.println("Disconnected!");
		}
	}
}
