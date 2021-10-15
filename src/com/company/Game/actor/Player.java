package com.company.actor;

import com.company.Card;

import java.util.ArrayList;

public class Player {
    private
    ArrayList<Card> hand = new ArrayList<>();

    public void printHand(){
        for(Card c: hand){
            System.out.println(c);
        }
    }

    public Card discard(){

        return hand.remove(hand.size() - 1);
    }
}
