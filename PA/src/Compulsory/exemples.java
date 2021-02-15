package Compulsory;

import java.util.Arrays;

public class exemples {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display on the screen the message "Hello World!"

        // Define an array of strings languages
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(Arrays.toString(languages)); // Display on the screen the array of strings languages

        int n = (int) (Math.random() * 1_000_000); // Generate a random integer n
        int binVal =0b10101; // Binary number 10101
        int hexVal = 0xFF; // Hexadecimal number FF
        int result; // A variable where we'll store our result

        result = ((n*3) + binVal + hexVal)*6;
        int helper = 0; // A variable where we'll obtain the checksum
        while (result > 0){ // Obtaining the checksum
            helper += result % 10;
            result = result / 10;

            if (result == 0 && helper > 9){
                result = helper;
                helper = 0 ;
            }
        }
        result=helper;
        System.out.println(result); // Displays on the screen the checksum

        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);
    }
}
