package test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner("people.txt");
        String[] arr = new String[4];
        arr[0] = sc.nextLine();
        if (sc.hasNextLine()) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLine();
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}








