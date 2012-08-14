/** 
 * 
 */
package pl.vlo.biojpks.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author arccha GUI dla bioJPKS.
 */
public class ClientGUI extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private BorderLayout	layout;
	private JPanel			window;
	private JTextArea		question;	// pytanie
	private JTextArea		chat;	// chat glowny
	private JTextArea		input;	// linijka do wprowadzania
	private JTextArea		status;	// status
	private JLabel			img;	// element na obrazek

	/**
	 * @throws HeadlessException
	 */
	public ClientGUI()
	{
		super();
		
		setPreferredSize(new Dimension(800, 600));
		
		layout = new BorderLayout();
		window = new JPanel(layout);
		add(window);

		question = new JTextArea("PYTANIE");
		add(question, BorderLayout.NORTH);

		chat = new JTextArea("CHAT");
		add(chat, BorderLayout.CENTER);

		input = new JTextArea("INPUT");
		add(input, BorderLayout.SOUTH);

		status = new JTextArea("STATUS");
		add(status, BorderLayout.EAST);

		img = new JLabel("OBRAZEK");
		add(img, BorderLayout.WEST);
		
		status.setText("DUPA");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void showStatus(String stat)
	{
		status.setText(stat);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
