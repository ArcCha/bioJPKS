package pl.vlo.biojpks.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * Wątek gracza.
 * 
 * Zbiera od niego odpowiedzi, oraz wysyła do niego informacje.
 * 
 * @author bambucha
 *
 */
public class PlayerThread extends Thread
{
    private Socket  socket;
    private Scanner scanner;
    private Writer  writer;
    private Player  player;
    private Judge   judge;
    private boolean isConnect;

    public PlayerThread(Socket socket, Judge judge)
    {
        this.socket = socket;
        this.judge = judge;
        try
        {
            scanner = new Scanner(socket.getInputStream());
            writer = new OutputStreamWriter(socket.getOutputStream());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (isConnect)
        {
            String answare = scanner.nextLine();
        }

    }

}
