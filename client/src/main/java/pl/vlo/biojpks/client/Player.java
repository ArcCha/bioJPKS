/**
 * 
 */

package pl.vlo.biojpks.client;

/**
 * @author arccha Klasa, która przechowuje nick gracza i ilość zdobytych przez
 *         niego punktów.
 * 
 */
public class Player extends GameObject implements Showable
{
	String	nick;
	int		points;
	
	public Player(String nick)
	{
		this.nick = nick;
		this.points = 0;
	}

	public Player(int points, String nick)
	{
		this.nick = nick;
		this.points = points;
	}

	/**
	 * @return the nick
	 */
	public String getNick()
	{
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set
	 */
	public void setNick(String nick)
	{
		this.nick = nick;
	}

	/**
	 * @return the points
	 */
	public int getPoints()
	{
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points)
	{
		this.points = points;
	}

	@Override
	public void showInGame(ClientGUI gui)
	{
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}
