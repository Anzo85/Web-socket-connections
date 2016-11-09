package anzo.org.ua;

import sun.misc.Cache;

import java.net.*;
import java.io.*;

public class Server implements Runnable {

    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws Exception {
        int ServerPort = 9899;
        ServerSocket serverSocket = new ServerSocket(ServerPort);
        System.out.println("Waiting... ");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            new Thread(new Server(socket)).start();
        }
    }


    public synchronized void run() {

        try {

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF();
                System.out.println("Server sent");
                out.writeUTF(line);
                out.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

