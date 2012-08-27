/** 
 * 
 */

package pl.vlo.biojpks.client;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
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
public class ClientGUI extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private BorderLayout				layout;
	private JPanel						window;
	private JTextPane					question;		// pytanie
	private JTextArea					chat;			// chat glowny
	private JTextArea					input;			// linijka do
														// wprowadzania
														// private JTextArea
														// status;
														// //
														// status
	private JTable						status;
	private JLabel						img;			// element na obrazek
	private Vector<Vector<String>>		data;
	private DefaultTableModel			model;
	private Vector<String>				columnNames;
	private TableRowSorter<TableModel>	sorter;
	private final static Logger logger = LoggerFactory.getLogger(ClientGUI.class);
	private StyledDocument	doc;

	/**
	 * @throws HeadlessException
	 */
	public ClientGUI()
	{
		super();
		setName("bioJPKS");
		setTitle("bioJPKS");
		// setPreferredSize(new Dimension(800, 600));

		layout = new BorderLayout();
		window = new JPanel(layout);
		add(window);

		String quetest = new String("Pytanie " + "dwustringowe");
		doc = new DefaultStyledDocument();
		try
		{
			doc.insertString(0, quetest, null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Sample question have gone... who cares where?");
			e.printStackTrace();
		}
		question = new JTextPane(doc);
		question.setEditable(false);
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
		sorter = new TableRowSorter<TableModel>(status.getModel());
		status.setRowSorter(sorter);
		// status.getColumnModel().getColumn(0).setMaxWidth(200);
		// status.getColumnModel().getColumn(1).setPreferredWidth(20);
		// status.getColumnModel().getColumn(1).setMaxWidth(20);
		JScrollPane scrollPane = new JScrollPane(status);
		status.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.EAST);

		// BufferedImage myPicture = null;
		// try
		// {
		// myPicture =
		// ImageIO.read(ClientGUI.class.getResource("/images/logo.gif"));
		// }
		// catch (IOException e)
		// {
		// System.out.println("Default image not found.");
		// e.printStackTrace();
		// }
		img = new JLabel(new ImageIcon(ClientGUI.class.getResource("/images/logo.gif")));
		add(img, BorderLayout.WEST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void showQuestion(String que)
	{
		try
		{
			doc.remove(0, doc.getLength());
		}
		catch (BadLocationException e1)
		{
			logger.warn("Cannot clear question pane.");
			e1.printStackTrace();
		}
		try
		{
			doc.insertString(0, que, null);
		}
		catch (BadLocationException e)
		{
			logger.warn("Cannot load question to GUI"); //to sie w ogole moze zdarzyc?
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
