package pl.vlo.biojpks.server;

import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class PlayerThread extends Thread
{
    private Socket socket;
    private Scanner scanner;
    private Writer writer;
    

    public PlayerThread(Socket socket)
    {
        this.socket = socket;
    }
    
}
