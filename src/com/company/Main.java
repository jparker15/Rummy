package com.company;

import com.company.Game.rummy.Table;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Table table = new Table();

        table.playGame();

//        ArrayList<Card> discard = new ArrayList<>();
//        System.out.println("Welcome to Rummy");
//        System.out.println("---");
//        System.out.println("---\n");
//
//        while(true){
//
//            System.out.println("Would you like to draw a card?");
//            System.out.println("Yes (1) or No (2)");
//            int i = scanner.nextInt();
//            if(i != 2){
//                p.hand.add(d.draw());
//                p.printHand();
//            }else {
//                System.out.println("Would you like to discard a card?");
//                System.out.println("Yes (1) or No (2)");
//                int j = scanner.nextInt();
//                if (j != 2) {
//                    discard.add(p.discard());
//                    p.printHand();
//                }
//            }
//
//            if(discard.size() > 0){
//                System.out.println("Pick a card from the discard?");
//
//                for(int k = 0; k < discard.size(); k++){
//                    System.out.println(discard.get(k) + "(" + k + ")");
//                }
//            }
//
////                }else{
////                    System.out.println("---");
////                    System.out.println("---");
////                    System.out.println("---");
////                    for(Card c: discard){
////                        System.out.println(c.display());
////                    }
////                    System.out.println("---");
////                    break;
////                }
////            }
//        }


    }

}
