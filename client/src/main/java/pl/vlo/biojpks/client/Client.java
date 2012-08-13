package pl.vlo.biojpks.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	private Connection connection;	
	private ClientGUI			gui;
	private Protocol		protocol;
	
	/**
	 * 
	 */
	public Client()
	{
		super();
		connection = new Connection();
		protocol = new Protocol(connection);
		gui = new ClientGUI();
		try
		{
			socket = new Socket(Connection.host, Connection.port); // host?
		}
		catch (UnknownHostException e)
		{
			System.err.println("Hostname unknown.");
		}
		catch (IOException e)
		{
			System.err.println("IO is missing.");
		}
	}

	protected void finalize()
	{
		try
		{
			socket.close();
		}
		catch (IOException e)
		{
			System.err.println("IO is missing.");
			e.printStackTrace();
		}
	}

	public int get()
	{
		return 1;
	}
	
	public static void main()
	{
		Client client = new Client();
		client.listenServer();
	}

	/**
	 * 
	 */
	private void listenEventServer()
	{
		throw new RuntimeException();
	}
}