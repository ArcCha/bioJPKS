/**
 * 
 */
package pl.vlo.biojpks.client;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * @author arccha
 * 	GUI dla bioJPKS.
 */
public class ClientGUI extends JFrame implements ActionListener
{

	/**
	 * @throws HeadlessException
	 */
	public ClientGUI() throws HeadlessException
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param gc
	 */
	public ClientGUI(GraphicsConfiguration gc)
	{
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public ClientGUI(String title) throws HeadlessException
	{
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param gc
	 */
	public ClientGUI(String title, GraphicsConfiguration gc)
	{
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

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
