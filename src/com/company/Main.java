package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player p = new Player();

        Deck d = new Deck();
        ArrayList<Card> discard = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        d.shuffle();
        System.out.println("Welcome to Rummy");
        System.out.println("---");
        System.out.println("---");

        while(true){

            if(discard.size() > 0){
                System.out.println("Pick a card from the discard?");
            }

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
                    discard.add(p.discard());
                    p.printHand();
                }else{
                    System.out.println("---");
                    System.out.println("---");
                    System.out.println("---");
                    for(Card c: discard){
                        System.out.println(c.display());
                    }
                    System.out.println("---");
                    break;
                }
            }
        }


    }

}
