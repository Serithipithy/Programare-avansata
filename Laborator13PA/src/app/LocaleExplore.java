package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Info info = new Info();
        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();

        Scanner scanner = new Scanner(System.in);
        String input;

        while(true){
            System.out.print("Command: ");
            input = scanner.nextLine();
            if(input.compareTo("info") == 0) info.about(Locale.getDefault());
            else if(input.compareTo("display locales") == 0) displayLocales.start();
            else if(input.compareTo("exit") == 0) {
                System.out.println("Session ended");
                break;
            }
            else {
                String[] split = input.split(" ");

                if(split.length == 3 && split[0].compareTo("setlocale") == 0)
                    setLocale.start(new Locale(split[1], split[2]));
            }
        }

    }
}
