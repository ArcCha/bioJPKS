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
	private static Socket		socket;
	private static PrintWriter	writer;
	private static Scanner		scan;
	private static String		command;
	private static Question		question;
	private static Status		status;
	private ClientGUI			gui;
	private static Player		player;

	/**
	 * 
	 */
	public Client()
	{
		super();
		gui = new ClientGUI();
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
	
	public int get()
	{
		return 1;
	}
	public static void main()
	{
		Client client = new Client();
		while (socket.isConnected() && scan.hasNextLine())
		{
			command = scan.nextLine();
			switch (command)
			// Java 7 daje możliwość porównywania stringów, o ile się nie mylę.
			{
				case "QUESTION":

					break;
				case "IMAGE":

					break;
				case "STATUS":

					break;
				case "OK":

					break;
				case "BAD":

					break;
				default:
					System.out.println("cos sie wykrzaczylo");
					break;
			}
		}
	}
}