package com.company.Game.rummy;

import com.company.Game.actor.Player;
import com.company.Game.deck.Deck;
import com.company.Game.deck.DiscardDeck;
import com.company.Game.deck.StandardDeck;
import com.company.Utils.Console;


import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Hand> hands = new ArrayList<>();
    private Deck deck;
    private DiscardDeck discardDeck;

    private int playerCount = 0;

    public Table (){
        System.out.println("\n-----\n");
        System.out.println("""
                █░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██░░░░░░░░█░░░░░░░░██░░░░░░░░████
                █░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░████
                █░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░░░█░░░░▄▀░░██░░▄▀░░░░████
                █░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀▄▀░░▄▀▄▀░░██████
                █░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░█████░░░░▄▀▄▀▄▀░░░░██████
                █░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███████░░░░▄▀░░░░████████
                █░░░░░░░░░░▄▀░░█░░▄▀░░░░░░░░░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░█████████░░▄▀░░██████████
                █████████░░▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████████░░▄▀░░██████████
                █░░░░░░░░░░▄▀░░█░░▄▀░░█████████░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░░░███████░░▄▀░░██████████
                █░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀▄▀░░███████░░▄▀░░██████████
                █░░░░░░░░░░░░░░█░░░░░░█████████░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██░░░░░░░░███████░░░░░░██████████
                ████████████████████████████████████████████████████████████████████████████████████████████████████
                ████████████████████████████████████████████████████████████████████████████████████████████████████
                █░░░░░░░░░░░░░░░░███░░░░░░██░░░░░░█░░░░░░██████████░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░██░░░░░░░░█
                █░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░░░░░▄▀░░█░░▄▀░░░░░░░░░░░░░░▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░█
                █░░▄▀░░░░░░░░▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀░░█░░░░▄▀░░██░░▄▀░░░░█
                █░░▄▀░░████░░▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░░░░░▄▀░░███░░▄▀▄▀░░▄▀▄▀░░███
                █░░▄▀░░░░░░░░▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░███░░░░▄▀▄▀▄▀░░░░███
                █░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█████░░░░▄▀░░░░█████
                █░░▄▀░░░░░░▄▀░░░░███░░▄▀░░██░░▄▀░░█░░▄▀░░██░░░░░░██░░▄▀░░█░░▄▀░░██░░░░░░██░░▄▀░░███████░░▄▀░░███████
                █░░▄▀░░██░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░██████████░░▄▀░░███████░░▄▀░░███████
                █░░▄▀░░██░░▄▀░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░██████████░░▄▀░░███████░░▄▀░░███████
                █░░▄▀░░██░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░██████████░░▄▀░░███████░░▄▀░░███████
                █░░░░░░██░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░██████████░░░░░░███████░░░░░░███████
                ████████████████████████████████████████████████████████████████████████████████████████████████████""");
        System.out.println("---");
        Console.pause();
        System.out.println("""
                ────────────────████
                ───────────────█░░███
                ───────────────█░░████
                ────────────────███▒██─────████████
                ──────████████─────█▒█──████▒▒▒▒▒▒████
                ────███▒▒▒▒▒▒████████████░░████▒▒▒▒▒███
                ──██▒▒▒▒░▒▒████░░██░░░░██░░░░░█▒▒▒▒▒▒▒███
                ─██▒▒░░░░▒██░░░░░█▒░░░░░██▒░░░░░░░▒▒▒▒▒▒█
                ██▒░░░░░▒░░░░░░░░░▒░░░░░░░▒▒░░░░░░░▒▒▒▒▒██
                █░░░░░░▒░░░██░░░░░░░░░░░░░██░░░░░░░░▒▒▒▒▒█
                █░░░░░░░░█▒▒███░░░░░░░░░█▒▒███░░░░░░░▒▒▒▒█
                █░░░░░░░████████░░░░░░░████████░░░░░░▒▒▒▒█
                █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒█
                ██░░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█░▒▒▒▒█
                ─█░░░░██░█░░░░░░░░░░░░░░░░░░░░░░░███▒▒▒▒▒█
                ─█▒▒░░░░█████░░░█░░░░██░░░██░░████░▒▒▒▒▒▒█
                ─██▒▒░░░░░█████████████████████░░░▒▒▒▒▒▒██
                ──██▒▒▒▒░░░░░██░░░███░░░██░░░█░░░▒▒▒▒▒▒██
                ───███▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒█████
                ─────███▒▒▒▒▒▒░░░░░░░░░░░░░▒▒▒▒▒▒████
                ────────██████████████████████████
                """);
        Console.pause();
        System.out.println("---\n");
//        playerCount = Console.getInt("How many players?",2,6,"invalid player selection");
        playerCount = 2;

        for(int count = 0; count < playerCount; count++){
            Player newPlayer = new Player("Player " + (count + 1));
            hands.add(new Hand(newPlayer));
        }
    }

    public void playGame(){


        while (true){

            playRound();

        }
    }

    public void playRound(){
        deck = new StandardDeck();
        discardDeck = new DiscardDeck();
        deck.shuffle();
        deal();
        displayTable();
        while(true){
            playersTurns();
        }


    }

    private void playersTurns(){
        for(int count = 0; count < hands.size(); count++){
            Hand player = hands.get(count);
            while (true){
                if(!turn(player)) break;
            }
            System.out.println(player.getName());
            System.out.println(player.displayHand());
            Console.getString("Enter to start next turn",false);
        }
    }

    private void displayTable(){
        StringBuilder output = new StringBuilder();

        for(Hand player: hands){
            output.append(player.getName()).append("\n ").append(player.displayHand()).append(" | \n");
        }
//        output.append(discardDeck.displayDeck());
        output.append("\n -DISCARD- \n").append(discardDeck.displayDeck()).append("\n");
        System.out.println(output);
    }

    private void deal(){

        int handSize = 0;
        if(hands.size() < 3){
            handSize = 10;
        }if(hands.size() >= 3 && hands.size() < 5){
            handSize = 7;
        }if(hands.size() >= 5){
            handSize = 6;
        }

            //how many cards are add to players hands
        for(int count = 0; count < handSize; count++){
            for(Hand player: hands){
                player.addCard(deck.draw());
            }
        }
        discardDeck.addCard(deck.draw());

    }

    private boolean turn(Hand activeHand){

        byte action = activeHand.getAction(activeHand);
        return switch (action){
            case Actor.DRAW -> draw(activeHand);
            case Actor.ALTDRAW -> drawDiscard(activeHand);
            case Actor.KNOCK -> knock(activeHand);
            case Actor.QUIT -> quit();
            default -> false;
        };
    }

    private boolean quit(){
        System.exit(0);
        return false;
    }

    private boolean knock(Hand activeHand){


        return false;
    }

    private boolean pass(){
        return false;
    }

    private void discard(Hand activeHand){
        activeHand.displayHand();
        int choice = Console.getInt("choose a card number 1 - " + activeHand.size() + " to discard" ,0,activeHand.size(),"invalid entry");
        discardDeck.addCard(activeHand.removeCard(choice - 1));
    }

    private boolean draw(Hand activeHand){

        activeHand.addCard(deck.draw());
        System.out.println( activeHand.displayHand()+"\n");
        discard(activeHand);
        return false;
    }

    private boolean drawDiscard(Hand activeHand){

        System.out.println(discardDeck.displayDeck());
        int choice = Console.getInt("choose a card number 1 - " + discardDeck.getSize(),1,discardDeck.getSize(),"invalid entry");
        activeHand.addCard(discardDeck.draw(choice - 1));
        System.out.println(activeHand.displayHand());
        discard(activeHand);
        return false;
    }



}
