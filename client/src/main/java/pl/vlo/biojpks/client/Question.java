/**
 * 
 */

package pl.vlo.biojpks.client;

/**
 * @author arccha Klasa, która ma za zadanie przechowywać pytanie i powiązane
 *         informacje. Służy za swoisty most między Client a ClientGUI.
 */
public class Question extends GameObject implements Showable
{
	String	question;

	/**
	 * @return the question
	 */
	public String getQuestion()
	{
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question)
	{
		this.question = question;
	}

	/**
	 * @param question
	 */
	public Question(String question)
	{
		this.question = question;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * pl.vlo.biojpks.client.Showable#showInGame(pl.vlo.biojpks.client.ClientGUI
	 * )
	 */
	@Override
	public void showInGame(ClientGUI gui)
	{
		gui.showQuestion(question);
	}

}
