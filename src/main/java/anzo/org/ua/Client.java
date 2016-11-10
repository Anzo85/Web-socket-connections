package anzo.org.ua;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] arg) throws Exception {
        int serverPort = 9899;
        String address = arg[0];


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
            line = arg[1];

            out.writeUTF(line);
            out.flush();
            line = in.readUTF();
            System.out.println(" Message: " + line);
            System.out.println();
        }
    }

}

