package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request;
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String response;
            while(!socket.isClosed()){
                request = in.readLine();
                if(request.equals("stop") || request.equals("exit")){
                    try {
                        response = "Server stopped.";
                        out.println(response);
                        out.flush();
                        socket.close();
                    } catch (IOException e) { System.err.println (e); }
                }
                else{
                    response = "Server received the request " + request + ".";
                    out.println(response);
                    out.flush();
                }
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
    }

}
