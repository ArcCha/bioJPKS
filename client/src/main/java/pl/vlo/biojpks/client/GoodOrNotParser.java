/**
 * 
 */

package pl.vlo.biojpks.client;

import java.util.Scanner;

/**
 * @author arccha
 * 
 */
public class GoodOrNotParser extends Parser
{

	/**
	 * @param scanner
	 */
	public GoodOrNotParser(Scanner scanner)
	{
		super(scanner);
	}

	/*
	 * (non-Javadoc)
	 * @see pl.vlo.biojpks.client.Parser#parse()
	 */
	@Override
	public GameObject parse()
	{
		return new GoodOrNot(scanner.next());
	}

}
