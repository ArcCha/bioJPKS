/**
 * 
 */

package pl.vlo.biojpks.client;

import java.util.Scanner;

/**
 * @author arccha
 * 
 */
public class StatusParser extends Parser
{
	public StatusParser(Scanner scanner)
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
		int nPlayers;
		nPlayers = scanner.nextInt();
		Player[] players = new Player[nPlayers];
		for (int i = 0; i < nPlayers; i++)
		{
			players[i] = new Player(scanner.nextInt(), scanner.next());
		}
		Status status = new Status(nPlayers, players);
		return status;
	}

}
