/**
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author arccha
 * 	Klasa umożliwiająca użytkowanie obrazków.
 */
public class Image extends GameObject implements Showable
{
	Icon			icon;
	BufferedImage	image;
	URL				url;

	/**
	 * 
	 */
	public Image(URL url)
	{
		this.url = url;
//		try
//		{
//			image = ImageIO.read(url);
//		}
//		catch (IOException e)
//		{
//			System.out.println("Coud not read image from specified URL: " + url);
//			e.printStackTrace();
//		}
		icon = new ImageIcon(url);
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
		gui.showImage(icon);
	}

}
