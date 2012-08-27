/**
 * 
 */
package pl.vlo.biojpks.client;

import java.util.Scanner;

/**
 * @author arccha
 *
 */
public class MessageParser extends Parser
{

	/**
	 * @param scanner
	 */
	public MessageParser(Scanner scanner)
	{
		super(scanner);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see pl.vlo.biojpks.client.Parser#parse()
	 */
	@Override
	public GameObject parse()
	{
		return new Message(scanner.nextLine(), scanner.nextLine());
	}

}
