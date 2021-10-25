package com.company.Game.actor;

import com.company.Game.deck.Card;
import com.company.Game.rummy.Actor;
import com.company.Game.rummy.Hand;
import com.company.Utils.Console;

import java.util.ArrayList;

public class Player implements Actor {
    private final String name;
    private int actionsCounts;
    ArrayList<Card> hand = new ArrayList<>();

    public Player(String name) {this.name = name;
    }

    public void printHand(){
        for(Card c: hand){
            System.out.println(c);
        }
    }

    public Card discard(){

        return hand.remove(hand.size() - 1);
    }

    private String getAvailableActions(Hand hand){
        //number of players actions in the menu
        actionsCounts = 6;
        return "\n1. Draw\n2. Draw from Discards\n3. Knock\n4. Sort Cards\n0. Quit";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public byte getAction(Hand hand) {
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());

        return (byte) Console.getInt(getAvailableActions(hand),0,actionsCounts,"invalid action");
    }
}
