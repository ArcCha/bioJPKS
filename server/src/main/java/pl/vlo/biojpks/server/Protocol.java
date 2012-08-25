package pl.vlo.biojpks.server;

import java.net.URL;
import java.util.List;

/**
 * Klasa będąca abstrakcją nad protokołem
 * 
 * @author bambucha
 *
 */
public class Protocol
{
    
    public String sendDefaultImage()
    {
        return "IMAGE\nDEFAULT\n";
    }

    public String sendImage(URL url)
    {
        return "IMAGE"+ "\n" + url.toString();
    }

    public String sendQuestion(Question question)
    {
        return "QUESTION" + "\n" + question.getQuestion();
    }

    public String sendStatus(List<Player> players)
    {
        String answare = "STATUS\n";
        answare += Integer.valueOf(players.size()) + "\n";
        for(Player player : players)
            answare += (Integer.valueOf(player.getScore()) + " " + player.getNick() + "\n");
        return answare;
    }

    public String sendAnswer()
    {
        return "ANSWAR\n";
    }

    public String sendOK()
    {
        return "OK\n";
    }

    public String sendBad()
    {
        return "BAD\n";
    }    
}
