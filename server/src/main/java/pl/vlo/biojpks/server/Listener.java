package pl.vlo.biojpks.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Listener extends Thread
{
    Logger log = Logger.getLogger(Listener.class.getName());
    
    final private ServerSocket server;
    
    public Listener(int port) throws IOException
    {
        server = new ServerSocket(port);
        setDaemon(true);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    log.info("Stoping server");
                    server.close();
                    log.info("Server has been stopped");
                }
                catch(IOException e)
                {
                    log.log(java.util.logging.Level.SEVERE,"Wyjątek",e);
                }                
            }
        }));
    }

    @Override
    public void run()
    {
        Socket socket;
        while(true)
        {
            try
            {
                socket = server.accept();
            }
            catch(IOException e)
            {
                log.log(java.util.logging.Level.SEVERE,"Wyjątek",e);
            }
        }
    }
    
    

}
