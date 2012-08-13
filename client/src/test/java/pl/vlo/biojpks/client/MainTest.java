package pl.vlo.biojpks.client;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class MainTest
{

    @Test
    public void testGet()
    {
        Client main = new Client();
        assertThat(true).isEqualTo(true);
    }

}
