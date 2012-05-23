package pl.vlo.biojpks.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class PlayerThread extends Thread
{
    private Socket socket;
    private Scanner scanner;
    private Writer writer;
    private Player player;
    private boolean isConnect;
    

    public PlayerThread(Socket socket)
    {
        this.socket = socket;
        try 
        {
			scanner = new Scanner(socket.getInputStream());
			writer = new OutputStreamWriter(socket.getOutputStream());
		}
        catch (IOException e)
        {
			e.printStackTrace();
		}
    }


	@Override
	public void run()
	{
		while(isConnect)
		{
			
		}
	}
}
