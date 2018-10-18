package Client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Send extends Thread
{
	private Socket client;
	public Send(Socket client)
	{
		this.client=client;
	}
	
	@Override
	public void run()
	{
		try
		{
		Scanner sc2=new Scanner(System.in);
		PrintStream ps=new PrintStream(client.getOutputStream());
		
		while(true)
		{
			ps.println(sc2.nextLine());
			ps.flush();
		}
		}
		catch (IOException e)
		{
			System.out.println("error");
		}
	}
}
