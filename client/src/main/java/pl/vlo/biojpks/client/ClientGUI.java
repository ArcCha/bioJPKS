/** 
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arccha GUI dla bioJPKS.
 */
public class ClientGUI extends JFrame
{

	/**
	 * 
	 */
	private BorderLayout				layout;
	private JPanel						window;
	private JTextPane					question;											// pytanie
	private JTextPane					chat;												// chat glowny
	private JTextField					input;												// input
	private JTable						status;
	private JLabel						img;												// element na obrazek
	private Vector<Vector<String>>		data;
	private DefaultTableModel			model;
	private Vector<String>				columnNames;
	private TableRowSorter<TableModel>	sorter;
	private final static Logger			logger	= LoggerFactory.getLogger(ClientGUI.class);
	private StyledDocument				quePane;
	private StyledDocument				chatPane;
	private String						nick = null;
	private Client						client;
	private GetLogin					getlogin;

	/**
	 * @throws HeadlessException
	 */
	public ClientGUI(Client client)
	{
		super();
		this.client = client;
		getlogin = new GetLogin(this, "Podaj swój nick");
		setName("bioJPKS");
		setTitle("bioJPKS");
		layout = new BorderLayout();
		window = new JPanel(layout);
		add(window);

		String quetest = new String("Pytanie " + "dwustringowe");
		quePane = new DefaultStyledDocument();
		try
		{
			quePane.insertString(0, quetest, null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Sample question have gone... who cares where?");
			e.printStackTrace();
		}
		question = new JTextPane(quePane);
		question.setEditable(false);
		add(question, BorderLayout.NORTH);

		String chatInit = new String("Witaj w aplikacji bioJPKS!" + "\n");
		chatPane = new DefaultStyledDocument();
		try
		{
			chatPane.insertString(0, chatInit, null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Cannot initialize chatPane");
			e.printStackTrace();
		}
		chat = new JTextPane(chatPane);
		chat.setEditable(false);
		add(chat, BorderLayout.CENTER);

		input = new JTextField();
		input.addActionListener(client);
		add(input, BorderLayout.SOUTH);

		columnNames = new Vector<String>();
		columnNames.add("Nick");
		columnNames.add("Points");
		data = new Vector<Vector<String>>();
		model = new DefaultTableModel(data, columnNames);
		status = new JTable(model);
		status.getColumnModel().getColumn(0).setMaxWidth(25);
		status.getColumnModel().getColumn(1).setMaxWidth(15);
		sorter = new TableRowSorter<TableModel>(status.getModel());
		status.setRowSorter(sorter);
		JScrollPane scrollPane = new JScrollPane(status);
		status.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.EAST);

		img = new JLabel(new ImageIcon(ClientGUI.class.getResource("/images/logo.gif")));
		add(img, BorderLayout.WEST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void showMessage(String nick, String text) // troche mi sie nie
														// podoba ta metoda
	{
		try
		{
			chatPane.insertString(chatPane.getLength(), nick + ": " + text + "\n", null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Cannot show message");
			e.printStackTrace();
		}
	}

	public void showQuestion(String que)
	{
		try
		{
			quePane.remove(0, quePane.getLength());
		}
		catch (BadLocationException e1)
		{
			logger.warn("Cannot clear question pane.");
			e1.printStackTrace();
		}
		try
		{
			quePane.insertString(0, que, null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Cannot load question to GUI"); // to sie w ogole moze
														// zdarzyc?
			e.printStackTrace();
		}
	}

	public void showStatus(Vector<Vector<String>> data)
	{
		this.data = data;
		model.setDataVector(data, columnNames); // ustawiam na pale nowy vector
												// z danymi, a jak widac nizej
												// chcialem rzucic eventem, ze
												// JTable powinien sie
												// odswiezyc. wiem, ze wtedy
												// powinienem dodac listenera do
												// modelu, tak tez probowalem,
												// ale co ja mam wtedy wklepac w
												// samego listenera?
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
		sorter.setSortKeys(sortKeys);
		// model.newDataAvailable(new TableModelEvent(model));
	}

	public void showImage(Icon icon)
	{
		img.setIcon(icon); // czy jakbym to wsadził do klasy Image to to
							// by było brzydkie bardzo? -> gui.img.setIcon...
	}

	public Message getMessage()
	{
		String messText = input.getText();
		input.setText("");
		return new Message(nick, messText);
	}

	public String getNick()
	{
		return nick;
	}

	public void setNick(String nick)
	{
		this.nick = nick;
	}

}
