package main;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {

    public static void searchFile(String textFile, String searchString) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(textFile));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.toLowerCase().contains(searchString.toLowerCase())) {
                System.out.println(line);
            }
        }
    }

    public static void fullFileRead(String textFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
