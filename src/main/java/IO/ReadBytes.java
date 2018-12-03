package IO;

import java.io.IOException;

public class ReadBytes {


    public static void main(String[] args) throws IOException {
        byte[] data = new byte[10];
        System.in.read(data);

        System.out.print("Bы ввели: ");
        for (int i = 0; i < data.length; i++)
            System.out.print((char) data[i]);

    }
}
