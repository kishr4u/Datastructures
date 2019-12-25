package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connections {


    public static void main(String[] args) {

     new SimpleClient().run();

    }




    static class SimpleClient implements Runnable {

        @Override
        public void run() {

            Socket socket = null;
            try {

                Thread.sleep(1000);

                socket = new Socket("localhost", 3333);

                //socket.setSoTimeout(30000);
                System.out.println("invoked ");
//                PrintWriter outWriter = new PrintWriter(socket.getOutputStream(),true);
//                System.out.println("finished ");
//                outWriter.println("Hello Mr. Server!");



                //socket.setSoTimeout(30000);

                //if you set a smaller time out below and snce the server sleep for 20 secs you will get sockettimedout exception
                socket.setSoTimeout(2000);

                System.out.println("invoked ");
                DataInputStream outWriter = new DataInputStream(socket.getInputStream());
                System.out.println("finished ");
                String s = outWriter.readLine();
                System.out.println("Received from server : "+ s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
