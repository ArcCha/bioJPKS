package pl.vlo.biojpks.server;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.net.Socket;

import org.junit.BeforeClass;
import org.junit.Test;

public class ListenerTest
{
    static int       port = 12000;
    static String    host = "localhost";

    private static Listener listener;

    @BeforeClass
    public static void before() throws IOException
    {
        listener = new Listener(port);
        listener.start();
    }

    @Test
    public void testRun()
    {
        assertThat(listener.isAlive());
    }

    @Test
    public void isDeamon()
    {
        assertThat(listener.isDaemon()).isTrue();
    }

    @Test
    public void testAccept() throws Exception
    {
        Socket socket = new Socket(host, port);
        assertThat(socket.isConnected()).isTrue();
    }

}
