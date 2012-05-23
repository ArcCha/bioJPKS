package pl.vlo.biojpks.server;

import java.util.Collection;

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
    
    public Question drawQuestion()
    {
        synchronized(currentQuestion)
        {
            currentQuestion = reposiotry.drawOneQuestion();
        }
        return currentQuestion;
    }
    
}