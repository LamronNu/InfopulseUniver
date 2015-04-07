package lessons.servlets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Univer_29 on 04.04.2015.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 7777);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //send data to server
        String message = "Hello, world!";
        out.write(message.getBytes());
        //get answer
        byte[] answer = new byte[1024];
        int count = in.read(answer);
        String answerStr = new String(answer,0,count);
        System.out.println(answerStr);

        //close socket
        socket.close();
        
    }
}
