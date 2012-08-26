package pl.vlo.biojpks.server;

import java.io.Serializable;

/**
 * Klasa encja dla pytań
 * @author bambucha
 *
 */
public class Question implements Serializable
{
    /**
     * Pierwsza wersja
     */
    private static final long serialVersionUID = 1L;
    
    private String question;
    private String answare;
    
    public Question(String question, String answare)
    {
        super();
        this.question = question;
        this.answare = answare;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnsware()
    {
        return answare;
    }

    public void setAnsware(String answare)
    {
        this.answare = answare;
    }
}
