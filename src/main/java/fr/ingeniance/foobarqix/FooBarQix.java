package fr.ingeniance.foobarqix;

import fr.ingeniance.Main;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class FooBarQix {
    private static final String[] values = {"Foo", "Bar", "Qix"};

    public static @NotNull String printFooBarQix(int number) throws Exception {
        if (number < 0) throw new Exception("The number input could not be negative.");

        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) result.append(values[0]);
        if (number % 5 == 0) result.append(values[1]);
        if (number % 7 == 0) result.append(values[2]);

        String numberStr = String.valueOf(number);

        for (int i = 0; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) == '3') result.append(values[0]);
            else if (numberStr.charAt(i) == '5') result.append(values[1]);
            else if (numberStr.charAt(i) == '7') result.append(values[2]);
        }

        return result.toString();
    }

    public static void mainFooBarQix() {
        System.out.print("KATA-Foo-Bar-Qix : \nWrite a positive number : ");
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        try {
            System.out.println(printFooBarQix(input));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.print("Press Keyboard to back Menu...");
        new Scanner(System.in).nextLine();
        Main.main(null);
    }
}
