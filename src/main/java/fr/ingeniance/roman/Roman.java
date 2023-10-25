package fr.ingeniance.roman;

import fr.ingeniance.Main;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Scanner;

public class Roman {

    private static final int[] NUMERICAL_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static final String[] ROMAN_VALUES = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
            "I"};

    /**
     * Convert number to roman letter
     *
     * @return romanValue
     */
    public static @NotNull String convertToRoman(int number) throws Exception {
        if (number < 0)
            throw new Exception("The number input could not be negative.");

        StringBuilder romanValue = new StringBuilder();
        for (int i = 0; i < NUMERICAL_VALUES.length; i++) {
            int nValue = number / NUMERICAL_VALUES[i];
            romanValue.append(String.join("", Collections.nCopies(nValue, ROMAN_VALUES[i])));
            number = number % NUMERICAL_VALUES[i];
        }
        return romanValue.toString();
    }

    public static void mainRoman() {
        System.out.print("KATA-Roman : \nWrite a positive number : ");
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        try {
            System.out.println(convertToRoman(input));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.print("Press Keyboard to back Menu...");
        new Scanner(System.in).nextLine();
        Main.main(null);
    }
}
