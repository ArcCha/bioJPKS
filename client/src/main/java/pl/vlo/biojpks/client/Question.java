/**
 * 
 */
package pl.vlo.biojpks.client;

/**
 * @author arccha Klasa, która ma za zadanie przechowywać pytanie i powiązane
 *         informacje. Służy za swoisty most między Client a ClientGUI.
 */
public class Question
{
	String	question;
	String	answer;

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
	 * @return the answer
	 */
	public String getAnswer()
	{
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	/**
	 * @param question
	 * @param answer
	 */
	public Question(String question, String answer)
	{
		super();
		this.question = question;
		this.answer = answer;
	}

}
