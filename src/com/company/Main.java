package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player p = new Player();

        Deck d = new Deck();

        Scanner scanner = new Scanner(System.in);

        d.shuffle();
        System.out.println("Welcome to Rummy");
        System.out.println("---");
        System.out.println("---");

        while(true){
            System.out.println("Would you like to draw a card?");
            System.out.println("Yes (1) or No (2)");
            int i = scanner.nextInt();
            if(i != 2){
                p.hand.add(d.draw());
                p.printHand();
            }else{
                System.out.println("Would you like to discard a card?");
                System.out.println("Yes (1) or No (2)");
                int j = scanner.nextInt();
                if(j != 2){
                    d.add(p.discard());
                    p.printHand();
                }else{
                    System.out.println("---");
                    System.out.println("---");
                    System.out.println("---");

                    System.out.println("---");
                    break;
                }
            }
        }


    }

}
