package Server;

import java.net.ServerSocket;

public class Server 
{
	public static void main(String[]args)
	{
		try
		{
			ServerSocket server=new ServerSocket(1211);
			ClientThread[] threadArr=new ClientThread[50];
			for(int i=0;i<threadArr.length;i++)
			{
				threadArr[i]=new ClientThread(server.accept(), threadArr);
				threadArr[i].start();
			}
		} catch(Exception e)
		{
			System.out.println("Smth went wrong");
		}
	}
}
