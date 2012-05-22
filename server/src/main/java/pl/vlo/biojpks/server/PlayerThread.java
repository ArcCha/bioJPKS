package pl.vlo.biojpks.server;

import java.net.Socket;

public class PlayerThread extends Thread
{
    private Socket socket;
    

    public PlayerThread(Socket socket)
    {
        this.socket = socket;
    }
    
}
