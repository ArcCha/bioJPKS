/** 
 * 
 */
package pl.vlo.biojpks.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author arccha Klasa ogarniająca protokół.
 * 
 */
public class Protocol
{
	enum Command
	{
		STATUS, QUESTION, OK, BAD, IMAGE, NULL;
	}

	private Command			command;
	private Socket			socket;
	private Scanner			scan;
	private PrintWriter		printer;
	
	public Protocol(Connection connection)
	{
		this.socket = connection.getSocket();
		try
		{
			scan = new Scanner(socket.getInputStream());
			printer = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException e)
		{
			System.err.println("IO is missing.");
			e.printStackTrace();
		}
	}

	public Showable poll()
	{
		return parse(whatCome());
	}

	/**
	 * @param whatCome
	 * @return
	 */
	private Showable parse(Command whatCome)
	{
		
	}

	/**
	 * 
	 */
	private Command whatCome()
	{
		while (socket.isConnected())
		{
			if (scan.hasNextLine())
			{
				String tmp = scan.nextLine();
				switch (tmp)
				{
					case "QUESTION":
						command = Command.QUESTION;
						break;
					case "IMAGE":
						command = Command.IMAGE;
						break;
					case "BAD":
						command = Command.BAD;
						break;
					case "OK":
						command = Command.OK;
						break;
					case "STATUS":
						command = Command.STATUS;
						break;
				}
			}
		}
		return command;
	}

	private void chooseParser()
	{
		switch (command)
		{
			case QUESTION :
								break;
			
		}
	}

	private Question parseQuestion()
	{
		return new Question(scan.nextLine(), scan.nextLine());
	}

}