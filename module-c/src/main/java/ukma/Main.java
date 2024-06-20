package ukma;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("time.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println("Time: " + reader.readLine());
    }
}