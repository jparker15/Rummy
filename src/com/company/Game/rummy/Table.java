package com.company.Game.rummy;

import com.company.Game.actor.Player;
import com.company.Game.deck.Deck;
import com.company.Game.deck.StandardDeck;
import com.company.Utils.Console;


import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Hand> hands = new ArrayList<>();
    private Deck deck;
    private int playerCount = 0;

    public Table (){
        playerCount = Console.getInt("How many players?",2,6,"invalid player selection");
        for(int count = 0; count < playerCount; count++){
            Player newPlayer = new Player("Player " + (count + 1));
            hands.add(new Hand(newPlayer));
        }
    }

    public void playGame(){
        while (true){
            playRound();
            break;
        }
    }

    public void playRound(){
        deck = new StandardDeck();
        deck.shuffle();
        deal();
        displayTable();
        playersTurns();

    }

    private void playersTurns(){
        for(int count = 0; count < hands.size(); count++){
            Hand player = hands.get(count);
            while (true){
                if(!turn(player)) break;
            }
            System.out.println(player.displayHand());
            Console.getString("Enter to start next turn",false);
        }
    }

    private void displayTable(){
        StringBuilder output = new StringBuilder();

        for(Hand player: hands){
            output.append(player.getName()).append(" ").append(player.displayHand()).append(" | \n");
        }
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

        for(int count = 0; count < handSize; count++){
            for(Hand player: hands){
                player.addCard(deck.draw());
            }
        }
    }

    private boolean turn(Hand activeHand){
        System.out.println(activeHand.getName());
        byte action = activeHand.getAction(activeHand);
        return switch (action){
            case Actor.QUIT -> quit();
            case Actor.DISCARD -> discard(activeHand);
            case Actor.DRAW -> draw(activeHand);
            default -> false;
        };
    }

    private boolean quit(){
        System.exit(0);
        return false;
    }

    private boolean discard(Hand activeHand){
        return false;
    }

    private boolean draw(Hand activeHand){
        return false;
    }

}
