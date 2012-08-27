
package pl.vlo.biojpks.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ActionListener
{
	private Connection			connection;
	private ClientGUI			gui;
	private Protocol			protocol;
	private final static Logger	logger	= LoggerFactory.getLogger(Client.class);

	/**
	 * 
	 */
	public Client()
	{
		super();
//		connection = new Connection(); // przeciez to nie ma konstruktora?!
//		protocol = new Protocol(connection);
		gui = new ClientGUI(this);
	}

	/**
	 * @author arccha Ta metoda ma sluchac serwera i reagowac na komedny.
	 */
	private void listenEventServer()
	{
		throw new RuntimeException();
	}

	private void startSample()
	{
		logger.info("Starting sample");
		Player[] players = new Player[3];
		players[0] = new Player(3, "franek");
		players[1] = new Player(5, "kuba");
		players[2] = new Player(1, "dupad12"); // DUPA = Debilu, upraszczaj
												// pierdolone algorytmy.
		Status stat = new Status(3, players);
		stat.showInGame(gui);

		Image imgtest = new Image(Client.class.getResource("/images/logo1.gif"));
		imgtest.showInGame(gui);

		Question queTest = new Question("To be or not to be?");
		queTest.showInGame(gui);

		Message mesTest = new Message("ja", "Test message");
		mesTest.showInGame(gui);

		while (true) // nie mam lepszego pomyslu jak to zatrzymac zeby mi nie
						// znikalo od razu.
		{

		}
	}

	public static void main(String[] args)
	{
		logger.info("Trying to set up new client...");
		Client client = new Client();
		logger.info("New client established.");
		client.startSample();
		// client.listenEventServer();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Message mess = gui.getMessage();
		protocol.sendMessageToServer(mess);
		logger.info("Message sent to server: " + mess.toString());
	}
}