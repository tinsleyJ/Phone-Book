package main;

import java.io.*;

public class WriteToFile {

    public static void write(String textFile, Person p) {

        try (FileWriter fw = new FileWriter(textFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}