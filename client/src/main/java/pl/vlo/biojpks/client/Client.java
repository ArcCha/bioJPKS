
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
		connection = new Connection();		//przeciez to nie ma konstruktora?!
		protocol = new Protocol(connection);
		gui = new ClientGUI();
	}

	/**
	 * @author arccha Ta metoda ma sluchac serwera i reagowac na komedny.
	 */
	private void listenEventServer()
	{
		throw new RuntimeException();
	}

	public static void main(String[] args)
	{
		//Client client = new Client();
		ClientGUI test = new ClientGUI();
		Player [] players = new Player[3];
		players[0] = new Player("franek");
		players[1] = new Player("kuba");
		players[2] = new Player("dupad12");		//DUPA = Debilu, upraszczaj pierdolone algorytmy.
		Status stat = new Status(3,players);
		stat.showInGame(test);
		while (true)	//nie mam  lepszego pomyslu jak to zatrzymac zeby mi nie znikalo od razu.
		{
			
		}
		//client.listenEventServer();
	}
}