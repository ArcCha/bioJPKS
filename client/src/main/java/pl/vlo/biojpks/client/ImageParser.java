/**
 * 
 */

package pl.vlo.biojpks.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author arccha
 * 
 */
public class ImageParser extends Parser
{

	/**
	 * @param scanner
	 */
	public ImageParser(Scanner scanner)
	{
		super(scanner);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * @see pl.vlo.biojpks.client.Parser#parse()
	 */
	@Override
	public GameObject parse()
	{
		String urlString = scanner.next();
		URL url = null;
		if (urlString == "DEFAULT")
		{
			url = ImageParser.class.getResource("/image/logo.gif");
		}
		else
		{

			try
			{
				url = new URL(urlString);
			}
			catch (MalformedURLException e)
			{
				System.out.println("Incorrect URL.");
				e.printStackTrace();
			}
		}
		return new Image(url);
	}

}