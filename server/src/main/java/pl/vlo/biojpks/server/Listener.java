package pl.vlo.biojpks.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Klasa oczekująca na podłączających się graczy
 * @author bambucha
 *
 */
public class Listener extends Thread
{
    Logger log = Logger.getLogger(Listener.class.getName());
    
    final private ServerSocket server;
    final private PlayerThreadPool pool;
    
    public Listener(int port,PlayerThreadPool pool) throws IOException
    {
        server = new ServerSocket(port);
        this.pool = pool;
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
        Socket socket = null;
        while(true)
        {
            try
            {
                socket = server.accept();
                pool.add(new PlayerThread(socket, null));
            }
            catch(IOException e)
            {
                log.log(java.util.logging.Level.SEVERE,"Close when listing",e);
            }
        }
    }
}
