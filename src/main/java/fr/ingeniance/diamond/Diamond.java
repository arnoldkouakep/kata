package fr.ingeniance.diamond;

import fr.ingeniance.Main;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Diamond {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxy";

    /**
     * This function print diamond from a letter
     *
     * @return strDiamond
     */
    public static @NotNull String printDiamond(@NotNull CharSequence character) throws Exception {

        int letterPosition = ALPHABET.indexOf(character.toString().toLowerCase());

        if (Objects.requireNonNull(character).toString().isEmpty()) throw new Exception("The Letter Cannot be null.");
        else if (character.length() > 1) throw new Exception("You must write one letter.");
        else if (!ALPHABET.contains(character.toString().toLowerCase()))
            throw new Exception("The letter input is not in a list of alphabet.");

        StringBuilder strDiamond = new StringBuilder();

        for (int i = 0; i < letterPosition + 1; i++) {
            strDiamond.append(repeat(letterPosition - i)).append(ALPHABET.charAt(i)).append(repeat(i * 2))
                    .append(i > 0 ? ALPHABET.charAt(i) : "").append("\n");
        }

        for (int i = letterPosition - 1; i >= 0; i--) {
            strDiamond.append(repeat(letterPosition - i)).append(ALPHABET.charAt(i)).append(repeat(i * 2))
                    .append(i > 0 ? ALPHABET.charAt(i) : "").append("\n");
        }

        return strDiamond.toString();
    }

    private static @NotNull String repeat(int nCopied) {
        return String.join("", Collections.nCopies(nCopied, "\t"));
    }

    public static void mainDiamond() {
        System.out.print("KATA-DIAMOND : \nWrite a character : ");
        Scanner sc = new Scanner(System.in);

        CharSequence input = sc.nextLine();
        try {
            System.out.println(printDiamond(input));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.print("Press Keyboard to back Menu...");
        sc.nextLine();
        Main.main(null);
    }
}