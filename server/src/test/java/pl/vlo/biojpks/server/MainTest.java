package pl.vlo.biojpks.server;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class MainTest
{

    @Test
    public void testGet()
    {
        Main main = new Main();
        assertThat(main.get()).isEqualTo(0);
    }

}
