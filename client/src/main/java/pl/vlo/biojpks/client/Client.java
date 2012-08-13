
package pl.vlo.biojpks.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	private Connection	connection;
	private ClientGUI	gui;
	private Protocol	protocol;

	/**
	 * 
	 */
	public Client()
	{
		super();
		connection = new Connection();
		protocol = new Protocol(connection);
		gui = new ClientGUI();
	}

	/**
	 * 	@author arccha
	 * 		Ta metoda ma sluchac serwera i reagowac na komedny.
	 */
	private void listenEventServer()
	{
		throw new RuntimeException();
	}

	public static void main()
	{
		Client client = new Client();
		client.listenEventServer();
	}
}