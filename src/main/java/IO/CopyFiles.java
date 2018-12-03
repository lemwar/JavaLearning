package IO;

import java.io.*;

public class CopyFiles {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\kkostin\\IdeaProjects\\JavaLearning\\src\\main\\resources\\old_file";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        System.out.println(reader.readLine());

//        char c;
//        try {
//            DataInputStream dis = new DataInputStream(new FileInputStream(path));
//            do {
//                c = (char)dis.read();
//                System.out.println(c);
//            } while (c != -1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
