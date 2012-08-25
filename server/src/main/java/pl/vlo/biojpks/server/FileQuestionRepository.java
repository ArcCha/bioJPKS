package pl.vlo.biojpks.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa impementująca bazę pytań jako plik
 * @author bambucha
 *
 */
public class FileQuestionRepository implements QuestionReposiotry
{
    private Logger                 log = Logger.getLogger(FileQuestionRepository.class.getName());
    private Map<Integer, Question> repo;
    private Random                 random;

    public FileQuestionRepository()
    {
        repo = new HashMap<Integer, Question>();
        random = new Random();
    }

    public FileQuestionRepository(File base)
    {
        repo = new HashMap<Integer, Question>();
        random = new Random();
        log.log(Level.INFO, "Loading database form file {0}", base.getAbsolutePath());
        try
        {
            load(new FileReader(base));
        }
        catch(FileNotFoundException e)
        {
            log.log(Level.SEVERE, "Plik bazy nie został odnaleziony", e);
        }
        log.info("Loading has been completed");
    }

    public void load(Reader stream)
    {
        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext())
        {
            String question = scanner.nextLine();
            String answare = scanner.nextLine();
            log.info("\nQ: " + question + "\nA: " + answare);
            repo.put(repo.size(), new Question(question, answare));
        }
        scanner.close();
    }

    public Question drawOneQuestion()
    {
        return repo.get(random.nextInt(repo.size()));
    }

}
