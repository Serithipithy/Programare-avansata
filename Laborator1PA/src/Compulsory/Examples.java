package Compulsory;

import java.util.Arrays;

public class Examples {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display on the screen the message "Hello World!"

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(Arrays.toString(languages)); // Display on the screen the array of strings languages

        int n = (int) (Math.random() * 1_000_000); // Generate a random integer n
        int result= checksum(n);

        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);
    }

    public static int calcul(int n){
        return (((n*3) + 0b10101 + 0xFF)*6);
    }

    public static int checksum(int number){
        int helper = 0; // A variable where we'll obtain the checksum
        number= calcul(number);
        while (number > 0){ // Obtaining the checksum
            helper += number % 10;
            number = number / 10;

            if (number == 0 && helper > 9){
                number = helper;
                helper = 0 ;
            }
        }
        return helper;
    }
}
