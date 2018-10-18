package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread
{
	Socket socket;
	ClientThread[] ct;
	PrintStream print;
	
	public ClientThread(Socket socket, ClientThread[] ct) throws IOException
	{
		this.socket=socket;
		this.ct=ct;
		print=new PrintStream(socket.getOutputStream());
	}
	
	@Override
	public void run()
	{
		try
		{
			PrintStream ps=new PrintStream(socket.getOutputStream());
			Scanner sc=new Scanner(socket.getInputStream());
			ps.println("Enter your name: ");
			String name=sc.nextLine();
			final String pass="1337";
			
			String cpass;
			int counter=1;
			while(counter!=0)
			{
				ps.println("Enter the server's password: ");
				cpass=sc.nextLine();
				if(cpass.equals(pass))
				{
					Message ms=new Message(name, ct);
					ms.start();
					counter=0;
					String str;
					while((str=sc.nextLine())!=null)
					{
						if(str!=null)
						{
							Send t=new Send(name+": "+str, ct);
							t.start();
						}
					}
				}
				if(counter>5)
				{
					ps.println("Too much entries!");
					break;
				}
				else
				{
					ps.println("Wrong password!");
				}
				counter++;
			}
			socket.close();
			sc.close();
			
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	
}
