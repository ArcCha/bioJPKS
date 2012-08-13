/**
 * 
 */

package pl.vlo.biojpks.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author arccha
 * 
 */
public class Connection
{
	static final String	host	= "lol";
	private Socket		socket;
	static final int	port	= 6667;

	public void connect()
	{
		try
		{
			socket = new Socket(host, port);
		}
		catch (IOException e)
		{
			System.out.println("Wystapil blad w nawiazywaniu polaczenia.");
			e.printStackTrace();
		}
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket()
	{
		return socket;
	}

	/**
	 * @param socket
	 *            the socket to set
	 */
	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}

}
