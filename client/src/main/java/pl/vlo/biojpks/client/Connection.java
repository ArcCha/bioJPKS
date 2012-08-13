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
	private Socket socket;
	static final int	port	= 6667;
	
	
	public void connect() throws UnknownHostException, IOException
	{
		socket = new Socket(host,Connection.port);
	}


	/**
	 * @return the socket
	 */
	public Socket getSocket()
	{
		return socket;
	}


	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}


	
	
	

}
