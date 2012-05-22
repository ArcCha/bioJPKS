package pl.vlo.biojpks.server;

public interface QuestionReposiotry
{
    /**
     * Zwrca losowo jedno pytanie z bazy pytań.
     * @return Pytanie.
     */
    Question drawOneQuestion();
}
