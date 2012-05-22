package pl.vlo.biojpks.server;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;

import org.junit.Test;

public class FileQuestionRepositoryTest
{
    String question = "Jaki jest twój ulubiony kolor?";
    String answare = "Niebieski";
    
    @Test
    public void testDrawOne() throws Exception
    {
        FileQuestionRepository repo = new FileQuestionRepository();
        StringReader reader = new StringReader(question + "\n" + answare +"\n");
        repo.load(reader);
        Question result = repo.drawOneQuestion();
        assertThat(result.getQuestion()).isEqualTo(question);
        assertThat(result.getAnsware()).isEqualTo(answare);
    }
    
       
    @Test
    public void testLoadFromFile() throws IOException
    {
        File tmp = File.createTempFile("bioJPKS", null);
        tmp.deleteOnExit();
        Writer writer = new FileWriter(tmp);
        writer.append(question);
        writer.append('\n');
        writer.append(answare);
        writer.append('\n');
        writer.flush();
        FileQuestionRepository repo = new FileQuestionRepository(tmp);
        Question result = repo.drawOneQuestion();
        assertThat(result.getQuestion()).isEqualTo(question);
        assertThat(result.getAnsware()).isEqualTo(answare);
    }

}
