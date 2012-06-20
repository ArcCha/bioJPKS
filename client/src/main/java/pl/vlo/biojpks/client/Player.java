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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getPoints() + "   " + getNick();
	}

	public Player(String nick)
	{
		this.nick = nick;
		this.points = 0;
	}

	/**
	 * @return the nick
	 */
	public String getNick()
	{
		return nick;
	}

	/**
	 * @param nick the nick to set
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
	 * @param points the points to set
	 */
	public void setPoints(int points)
	{
		this.points = points;
	}

}
