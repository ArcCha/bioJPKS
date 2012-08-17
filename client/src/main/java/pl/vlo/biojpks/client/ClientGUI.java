/** 
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 * @author arccha GUI dla bioJPKS.
 */
public class ClientGUI extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private BorderLayout			layout;
	private JPanel					window;
	private JTextArea				question;	// pytanie
	private JTextArea				chat;		// chat glowny
	private JTextArea				input;		// linijka do wprowadzania
												// private JTextArea status; //
												// status
	private JTable					status;
	private JLabel					img;		// element na obrazek
	private Vector<Vector<String>>	data;
	private DefaultTableModel		model;
	private Vector<String>	columnNames;

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

		columnNames = new Vector<String>();
		columnNames.add("Nick");
		columnNames.add("Points");
		data = new Vector<Vector<String>>();
		model = new DefaultTableModel(data, columnNames);
		status = new JTable(model);
		// status.getColumnModel().getColumn(0).setMaxWidth(200);
		// status.getColumnModel().getColumn(1).setPreferredWidth(20);
		// status.getColumnModel().getColumn(1).setMaxWidth(20);
		JScrollPane scrollPane = new JScrollPane(status);
		status.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.EAST);

		img = new JLabel("OBRAZEK");
		add(img, BorderLayout.WEST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void showStatus(Vector<Vector<String>> data)
	{
		this.data = data;
		model.setDataVector(data, columnNames);
		//model.newDataAvailable(new TableModelEvent(model));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
