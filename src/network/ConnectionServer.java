package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionServer {


    public static void main(String[] args) {

        new Thread(new SimpleServer()).start();


    }
    static class SimpleServer implements Runnable {

        @Override
        public void run() {

            ServerSocket serverSocket = null;
            while (true) {

                try {
                    serverSocket = new ServerSocket(3333);

                    Socket clientSocket = serverSocket.accept();
                    serverSocket.setSoTimeout(3000);
//                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter outWriter = new PrintWriter(clientSocket.getOutputStream(),true);

                    Thread.sleep(20000);
                    //clientSocket.close(); if you close the client socket you will receive connection reset error.

                    outWriter.println("waiting and sleeping from server");


                    //System.out.println("Client said :"+inputReader.readLine());

                } catch ( IOException | InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    try {
                        serverSocket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
