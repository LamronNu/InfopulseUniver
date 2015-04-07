package lessons.servlets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Univer_29 on 04.04.2015.
 */

class ClientHandler extends Thread {
    Socket s;

    public ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            //get data from client
            byte[] message = new byte[1024];
            int count = in.read(message);
            String messageStr = new String(message, 0, count);
            messageStr += "aaa";
            out.write(messageStr.getBytes());
            s.close();


        } catch (IOException e) {

        }

    }
}

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777, 0); // 0 -- unlimited, number -- count in queue
        while (true) {
            Socket clientSocket = serverSocket.accept();//block cycle until client-connect
            new ClientHandler(clientSocket).start();

        }

    }
}
