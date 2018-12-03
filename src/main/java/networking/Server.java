package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    Thread thread;

    Server() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(7077);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while(true) {
                System.out.println(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
