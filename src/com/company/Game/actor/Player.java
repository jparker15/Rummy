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
        actionsCounts = 2;
        return "0. Quit\n1. Draw\n2. Discard\n3. Draw from Discards";
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
