/**
 * 
 */
package pl.vlo.biojpks.client;

/**
 * @author arccha Klasa, która przechowuje nick gracza i ilość zdobytych przez
 *         niego punktów.
 * 
 */
public class Player
{
	String	nick;
	int		points;

	public Player(String nick)
	{
		this.nick = nick;
		this.points = 0;
	}
}
