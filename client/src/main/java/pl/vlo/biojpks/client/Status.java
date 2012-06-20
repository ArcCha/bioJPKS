/**
 * 
 */
package pl.vlo.biojpks.client;

/**
 * @author arccha Klasa przechowująca status obecny gry. Most między Client a
 *         ClientGUI.
 * 
 */
public class Status
{
	int			nPlayers;
	Player[]	players;

	/**
	 * @param nPlayers - liczba graczy
	 * @param players	- tablica z graczami
	 */
	public Status(int nPlayers, Player[] players)
	{
		super();
		this.nPlayers = nPlayers;
		this.players = players;
	}

}
