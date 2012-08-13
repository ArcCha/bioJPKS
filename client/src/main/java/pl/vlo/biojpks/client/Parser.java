/**
 * 
 */

package pl.vlo.biojpks.client;

import java.util.Scanner;

/**
 * @author arccha
 * 
 */
public abstract class Parser
{
	protected Scanner	scanner;

	public Parser(Scanner scanner)
	{
		this.scanner = scanner;
	}

	public abstract GameObject parse();
}
