/**
 * 
 */
package pl.vlo.biojpks.client;

/**
 * @author arccha
 *
 */
public class Message extends GameObject implements Showable
{

	String nick; //nadawca
	String text; //treść
	
	/**
	 * 
	 */
	public Message(String nick, String text)
	{
		this.nick = nick;
		this.text = text;
	}

	@Override
	public void showInGame(ClientGUI gui)
	{
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}
