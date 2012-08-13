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

	private Socket		socket;
	private Scanner		scan;
	private PrintWriter	printer;

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

	public void poll() // czemu showable?
	{
		return parse(whatCome());
	}

	/**
	 * @param whatCome
	 * @return
	 */
	private void parse(Command whatCome)
	{

	}

	private void chooseParser()
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
		return new Question(scan.nextLine(), scan.nextLine());
	}

}