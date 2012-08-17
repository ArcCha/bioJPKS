/**
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * @author arccha
 * 
 */
public class Image extends GameObject implements Showable
{
	ImageIcon	picture;
	BufferedImage image;

	/**
	 * 
	 */
	public Image()
	{
		// TODO Auto-generated constructor stub
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
