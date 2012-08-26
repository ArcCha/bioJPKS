package pl.vlo.biojpks.server;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

public class PlayerThreadTest
{
    @Test
    public void testConstructor() throws IOException
    {
        
    }
    
    public void testName() throws Exception
    {
        
    }
    
    public Socket genSocketMock(String input) throws IOException
    {
        Socket mock = mock(Socket.class);
        ByteArrayInputStream inputStream = new  ByteArrayInputStream(input.getBytes("utf-8"));
        when(mock.getInputStream()).thenReturn(inputStream);
        return mock;
    }

}
