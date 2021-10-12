package com.company;

import java.util.ArrayList;

public class Player {

    ArrayList <Card> hand = new ArrayList<>();

    public void printHand(){
        for(Card c: hand){
            System.out.println(c);
        }
    }

    public Card discard(){

        return hand.remove(hand.size() - 1);
    }
}
