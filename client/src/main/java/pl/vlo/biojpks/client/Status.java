/**
 * 
 */

package pl.vlo.biojpks.client;

import java.util.Vector;

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
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		for (int i = 0; i < players.length; i++)
		{
			data.add(new Vector<String>());			//ten kawałek bolał...
			data.get(i).add(players[i].nick);
			data.get(i).add(players[i].points.toString());
			System.out.println(i);
		}
		gui.showStatus(data);
	}
}
