/**
 * 
 */

package pl.vlo.biojpks.client;

/**
 * @author arccha
 * 
 */
public class GoodOrNot extends GameObject implements Showable
{

	private String	result;

	/**
	 * 
	 */
	public GoodOrNot(String result)
	{
		this.result = result;
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
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}
