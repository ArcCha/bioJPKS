package pl.vlo.biojpks.server;

import static org.fest.assertions.Assertions.assertThat;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProtocolTest
{
    Protocol protocol;
    
    @Before
    public void setup() throws Exception
    {
        protocol = new Protocol();
    }
    
    @Test
    public void testName() throws Exception
    {
        URL url = new URL("http://users.v-lo.krakow.pl/~biojpks/image.jpg");
        String output = protocol.sendImage(url);
        assertThat(output).isEqualTo("IMAGE\n"+url.toString());
    }
    
    @Test
    public void testQuestion() throws Exception
    {
        String textOfQuestion = "Ulubiony Kolor";
        Question question = new Question(textOfQuestion, null);
        assertThat(protocol.sendQuestion(question)).isEqualTo("QUESTION\n" + textOfQuestion);
    }
    
    @Test
    public void testStatusWithoutPlayers() throws Exception
    {
        List<Player> players = new ArrayList<Player>();
        String answare = protocol.sendStatus(players);
        assertThat(answare).isEqualTo("STATUS\n0\n");
    }
    
    @Test
    public void testStatusWithPlayers() throws Exception
    {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Dupa",10));
        players.add(new Player("mama",15));
        String answare = protocol.sendStatus(players);
        assertThat(answare).isEqualTo("STATUS\n" + Integer.valueOf(players.size()) + "\n" + "10 Dupa\n15 mama\n");
    }
    
    @Test
    public void testDefaultImage() throws Exception
    {
        String expected = "IMAGE\nDEFAULT\n";
        assertThat(protocol.sendDefaultImage()).isEqualTo(expected);
    }
    
    @Test
    public void testSendAnswar() throws Exception
    {
        String expected = "ANSWAR\n";
        assertThat(protocol.sendAnswer()).isEqualTo(expected);
    }
    
    @Test
    public void testSendOK() throws Exception
    {
        String expected = "OK\n";
        assertThat(protocol.sendOK()).isEqualTo(expected);
    }
    
    @Test
    public void testSendBad() throws Exception
    {
        String expected = "BAD\n";
        assertThat(protocol.sendBad()).isEqualTo(expected);
    }
}
