package com.server;

import opt.commands.Application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public Server() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                socket.setSoTimeout(20*1000); // time out for socket
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        Server server = new Server ();
    }

}
