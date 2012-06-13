package pl.vlo.biojpks.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
	private static final int	port	= 6667;
	private static final String	host	= "lol";
	private static Socket				socket;
	private static PrintWriter			writer;
	private static Scanner				scan;
	private static String command;
	/**
	 * 
	 */
	public Client()
	{
		super();
		try
		{
			socket = new Socket(host, port); // host?
			writer = new PrintWriter(socket.getOutputStream());
			scan = new Scanner(socket.getInputStream());
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
		writer.close();
		scan.close();
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

	public static void main(String[] args)
	{
		Client client = new Client();
		while(socket.isConnected() && scan.hasNextLine())
		{
			command = scan.nextLine();
			switch (command)	//Java 7 daje możliwość porównywania stringów, o ile się nie mylę.
			{
				case "QUESTION":
					
					break;

				default:
					break;
			}
		}
	}
}