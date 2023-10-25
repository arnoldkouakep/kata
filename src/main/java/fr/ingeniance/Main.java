package fr.ingeniance;

import fr.ingeniance.diamond.Diamond;
import fr.ingeniance.foobarqix.FooBarQix;
import fr.ingeniance.roman.Roman;
import fr.ingeniance.supermarket.SuperMarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello, \nMy name is Arnold KOUAKEP.\n" +
                "I am  IT consultant at Ingeniance, and I present to you my KATA (*_°)\n\n" +
                "Enjoy yourself!");

        System.out.print("Then, at MENU : \n" +
                "1 : Diamond\n" +
                "2 : Foo-Bar-Qix\n" +
                "3 : Roman\n" +
                "4 : Supermarket Pricing\n" +
                "q : Quit\n" +
                "\t==> Make a choice : ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();

            switch (choice.toLowerCase()) {
                case "1":
                    Diamond.mainDiamond();
                    break;
                case "2":
                    FooBarQix.mainFooBarQix();
                    break;
                case "3":
                    Roman.mainRoman();
                    break;
                case "4":
                    new SuperMarket().startShopping();
                    break;
                case "q":
                    System.out.println("Thank you and see you soon !");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.print("Incorrect Choice. Press a button to quit, or make a chose : ");
            }
        }
    }
}