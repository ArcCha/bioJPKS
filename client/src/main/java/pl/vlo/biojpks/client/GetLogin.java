/**
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arccha
 * 
 */
public class GetLogin extends JFrame implements ActionListener
{

	private JPanel				panel;
	private ClientGUI			gui;
	public JTextField			nickInput;
	private final static Logger	logger	= LoggerFactory.getLogger(GetLogin.class);

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public GetLogin(ClientGUI gui, String title) throws HeadlessException
	{
		super(title);
		this.gui = gui;

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		add(panel);
		nickInput = new JTextField(25);
		panel.add(nickInput);
		nickInput.addActionListener(this);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String nick = nickInput.getText();
		gui.setNick(nick);
		logger.info("Nick set to: " + nick);
		setVisible(false);
		gui.setVisible(true);
	}

}