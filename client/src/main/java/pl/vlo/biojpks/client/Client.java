package pl.vlo.biojpks.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
    	Socket socket;
    	PrintWriter writer;
    	Scanner scan;
    	
    	try
    	{
    		socket = new Socket(host, port); //ogarnąć jaki ma być host, a port i tak nie ustalony
    		writer = new PrintWriter(socket.getOutputStream());
    		scan = new Scanner(socket.getInputStream());
    	}
    	catch (UnknownHostException e)
    	{
    		System.err.println("Nie znany host");
    	}
    	catch (IOException e)
    	{
    		System.err.println("Nie da sie dostac I/O z serwera");
    	}
    	
    	
    	writer.close();
    	scan.close();
    	socket.close();
    }
}
