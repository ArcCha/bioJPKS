package pl.vlo.biojpks.server;

/**
 * Interfejs dla bazy pytań. Pozwala na równoległą implenentację różnych typów.
 * @author bambucha
 *
 */
public interface QuestionReposiotry
{
    /**
     * Zwrca losowo jedno pytanie z bazy pytań.
     * @return Pytanie.
     */
    Question drawOneQuestion();
}
