/**
 * 
 */

package pl.vlo.biojpks.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arccha
 * 
 */
public class Connection
{
	static final String	host	= "lol";
	private Socket		socket;
	static final int	port	= 6667;
	private final static Logger logger = LoggerFactory.getLogger(Connection.class);
	

	public void connect()
	{
		try
		{
			socket = new Socket(host, port);
		}
		catch (IOException e)
		{
			logger.error("Attempt to connect failed.");
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
