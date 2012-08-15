/**
 * 
 */

package pl.vlo.biojpks.client;

import javax.management.RuntimeErrorException;

/**
 * @author arccha Klasa przechowująca status obecny gry. Most między Client a
 *         ClientGUI.
 * 
 */
public class Status extends GameObject implements Showable
{
	int			nPlayers;
	Player[]	players;

	/**
	 * @param nPlayers
	 *            - liczba graczy
	 * @param players
	 *            - tablica z graczami
	 */
	public Status(int nPlayers, Player[] players)
	{
		super();
		this.nPlayers = nPlayers;
		this.players = players;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * pl.vlo.biojpks.client.Showable#showInGame(pl.vlo.biojpks.client.ClientGUI
	 * )
	 */
	@Override
	public void showInGame(ClientGUI gui)
	{
		String output = "";
		for (int i = 0; i < players.length; i++)
		{
			output = output + players[i].nick;
			output += players[i].points + "\n";
			System.out.println(output);
		}
		gui.showStatus(output);
	}

}
