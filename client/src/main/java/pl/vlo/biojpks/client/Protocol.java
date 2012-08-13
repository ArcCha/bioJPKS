/** 
 * 
 */

package pl.vlo.biojpks.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

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

	private Socket		socket;
	private Scanner		scanner;
	private PrintWriter	printer;

	public Protocol(Connection connection)
	{
		this.socket = connection.getSocket();
		try
		{
			scanner = new Scanner(socket.getInputStream());
			printer = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException e)
		{
			System.err.println("IO is missing.");
			e.printStackTrace();
		}
	}

	public void poll() // czemu showable?
	{
		throw new RuntimeErrorException(null);
		//return parse(chooseParser{whatCome()));
	}

	/**
	 * @param whatCome
	 * @return
	 */
	private void parse(Parser parser)
	{

	}

	private Parser chooseParser(Command whatCome)
	{
		switch (whatCome)
		{
			case QUESTION:
				return new QuestionParser(scanner);
			case IMAGE:
				
				break;
			case BAD:		//tak sobie mysle, czy nie lepiej by bylo dac jakas superkomende w protokole nad tym.
				
				break;
			case OK:
				
				break;
			case STATUS:
				return new StatusParser(scanner);
		}
		throw new RuntimeErrorException(null, "Could not determine proper parser");
	}

	/**
	 * 
	 */
	private Command whatCome()
	{
		while (socket.isConnected())
		{
			if (scanner.hasNextLine())
			{
				String tmp = scanner.nextLine();
				switch (tmp)
				{
					case "QUESTION":
						return Command.QUESTION;
					case "IMAGE":
						return Command.IMAGE;
					case "BAD":
						return Command.BAD;
					case "OK":
						return Command.OK;
					case "STATUS":
						return Command.STATUS;
				}
			}
		}
		return Command.NULL;
	}

	private Question parseQuestion()
	{
		return new Question(scanner.nextLine(), scanner.nextLine());
	}

}