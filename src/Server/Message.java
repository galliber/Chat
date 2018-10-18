package Server;

public class Message extends Thread
{
	String str;
	ClientThread[] ct;
	public Message(String str, ClientThread[] ct)
	{
		this.str=str;
		this.ct=ct;
	}
	
	@Override
	public void run()
	{
		for(int i=0;i<ct.length;i++)
		{
			ct[i].print.println(str+" has connected.");
		}
	}
}
