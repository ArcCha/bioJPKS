/**
 * 
 */
package pl.vlo.biojpks.client;

import java.util.Scanner;

/**
 * @author arccha
 *
 */
public class QuestionParser extends Parser
{

	public QuestionParser(Scanner scanner)
	{
		super(scanner);
	}

	/* (non-Javadoc)
	 * @see pl.vlo.biojpks.client.Parser#parse()
	 */
	@Override
	public Question parse()
	{
		return new Question(scanner.nextLine());
	}

}
