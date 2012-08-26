package pl.vlo.biojpks.server;

import java.util.Collection;

/**
 * Klasa sędzieko oceniająca odpowiedzi gracza 
 * 
 * @author bambucha
 *
 */
public class Judge extends Thread
{
    private QuestionReposiotry reposiotry;
    private Game game;
    private Question currentQuestion;
    
    public Judge(QuestionReposiotry reposiotry, Game game)
    {
        super();
        this.reposiotry = reposiotry;
    }
    
    public synchronized boolean judge(String playerAnsware)
    {
        throw new UnsupportedOperationException("Not yet");
    }
    
    public boolean checkAnsware(String answare)
    {
        throw new RuntimeException("Not yet implemented");
    }
    
    public Question drawQuestion()
    {
        synchronized(currentQuestion)
        {
            currentQuestion = reposiotry.drawOneQuestion();
        }
        return currentQuestion;
    }
    
}