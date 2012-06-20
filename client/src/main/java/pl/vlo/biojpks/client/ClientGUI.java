/** 
 * 
 */
package pl.vlo.biojpks.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author arccha GUI dla bioJPKS.
 */
public class ClientGUI extends JFrame implements ActionListener
{

	private BorderLayout	layout;
	private JPanel			window;
	private JTextArea		que;	// pytanie
	private JTextArea		chat;	// chat glowny
	private JTextArea		input;	// linijka do wprowadzania
	private JTextArea		stat;	// status
	private JLabel			img;	// element na obrazek

	/**
	 * @throws HeadlessException
	 */
	public ClientGUI()
	{
		super();
		layout = new BorderLayout();

		window = new JPanel(layout);
		// window.setPreferredSize(new Dimension(800, 600));
		add(window);

		que = new JTextArea("PYTANIE");
		// que.setPreferredSize(new Dimension(800, 100));
		add(que, BorderLayout.NORTH);

		chat = new JTextArea("CHAT");
		// chat.setPreferredSize(new Dimension(800, 400));
		add(chat, BorderLayout.CENTER);

		input = new JTextArea("INPUT");
		// input.setPreferredSize(new Dimension(800, 100));
		add(input, BorderLayout.SOUTH);

		stat = new JTextArea("STATUS");
		// stat.setPreferredSize(new Dimension(100, 400));
		add(stat, BorderLayout.EAST);

		img = new JLabel("OBRAZEK");
		add(img, BorderLayout.WEST);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
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
