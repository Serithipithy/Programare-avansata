package com.server;

import opt.commands.Application;
import opt.commands.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private String username = "";

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request;
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String response = "";
            while (!socket.isClosed()) {
                request = in.readLine();
                String[] requestList;
                if(request != null) {
                    requestList = request.split(" ");

                    switch (requestList[0]) {
                        case "register":
                            if (!username.equals(""))
                                response = "You are already logged in";
                            else if (Application.registerCommand.execute(requestList[1], "") && username.equals(""))
                                response = "Registered successfully";
                            else response = "Fail, try again!";
                            break;
                        case "login":
                            if (!username.equals(""))
                                response = "You are already logged in";
                            else if (Application.loginCommand.execute(requestList[1], "") && username.equals("")) {
                                response = "Logged in successfully";
                                username = requestList[1];
                            } else response = "Fail, try again!";
                            break;
                        case "friend":
                            request = request.replace("friend ", "");
                            if (Application.friendCommand.execute(username, request) && !username.equals(""))
                                response = "Friend(s) added";
                            else response = "Fail, try again!";
                            break;
                        case "send":
                            request = request.replace("send ", " ");
                            if (Application.sendCommand.execute(username, request) && !username.equals(""))
                                response = "Message send";
                            else response = "Fail, try again!";
                            break;
                        case "read":
                            response = Messages.myToString();
                            break;
                        case "exit":
                            Application.removeConnection();
                            response = "Connection stopped.";
                            break;
                        case "stop":
                            Application.removeConnection();
                            response = "Connection stopped.";
                            Application.stopInitiated = true;
                            break;
                        default:
                            response = "Wrong command, try again!";
                            break;
                    }
                }
                try {
                        response = response+"~";
                        out.println(response);
                        out.flush();
                        System.out.println(Application.getConnectedUsers());
                        if (response.equals("Connection stopped.~")) {
                            if(Application.stopInitiated && Application.getConnectedUsers() == 0){
                                System.exit(0);
                            }
                            socket.close();
                        }

                } catch (IOException e) {
                    System.err.println("Communication error... " + e);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

