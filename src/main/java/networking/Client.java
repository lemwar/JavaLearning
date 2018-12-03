package networking;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{

    Thread thread;

    Client() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 7077);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String line = reader.readLine();
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
