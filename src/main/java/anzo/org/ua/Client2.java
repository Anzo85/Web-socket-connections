package anzo.org.ua;

import java.net.*;
import java.io.*;

public class Client2 {
    public static void main(String[] args) throws Exception {
        int serverPort = 9899;
        String address = "127.0.0.1";


        InetAddress ipAddress = InetAddress.getByName(address);
        Socket socket = new Socket(ipAddress, serverPort);
        System.out.println("Connected");


        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();
        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);


        String line = null;

        while (true) {
            Thread.sleep(2000);

            line = args[0];

            out.writeUTF(line);
            out.flush();
            line = in.readUTF();
            System.out.println(" Message : " + line);
            System.out.println();
        }
    }

}