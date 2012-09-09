/** 
 * 
 */

package pl.vlo.biojpks.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arccha Klasa ogarniająca protokół.
 * 
 */
public class Protocol
{
	enum Command
	{
		STATUS, QUESTION, ANSWER, IMAGE, MESSAGE, NULL;
	}

	private Socket		socket;
	private Scanner		scanner;
	private PrintWriter	printer;
	private final static Logger logger = LoggerFactory.getLogger(Protocol.class);

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
			logger.error("IO is missing.");
			e.printStackTrace();
		}
	}

	public GameObject poll() // czemu showable?
	{
		return parse(chooseParser(whatCome()));
	}

	/**
	 * @param whatCome
	 * @return
	 */
	private GameObject parse(Parser parser)
	{
			GameObject gameobject = parser.parse();
			return gameobject;
	}

	private Parser chooseParser(Command whatCome)
	{
		switch (whatCome)
		{
			case QUESTION:
				return new QuestionParser(scanner);
			case IMAGE:
				return new ImageParser(scanner);
			case ANSWER:
				return new GoodOrNotParser(scanner);
			case STATUS:
				return new StatusParser(scanner);
			case MESSAGE:
				return new MessageParser(scanner);
		}
		logger.error("Could not determine proper parser");
		throw new RuntimeErrorException(null);
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
					case "ANSWER":
						return Command.ANSWER;
					case "STATUS":
						return Command.STATUS;
					case "MESSAGE":
						return Command.MESSAGE;
				}
			}
		}
		logger.error("Parsing incoming command failed");
		throw new RuntimeErrorException(null);
	}
	
	public void sendMessageToServer(Message mess)
	{
		printer.print(mess.nick);
		printer.print(mess.text);
	}
}