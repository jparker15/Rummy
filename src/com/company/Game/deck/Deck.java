package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    public final String[] SUITS ={
            "CLUBS", "HEARTS", "DIAMONDS", "SPADES"
    };

    public final int[] VALUES = {
            1,2,3,4,5,6,7,8,9,10,11,12,13
    };

    public Deck(){
        for (String s:SUITS) {
            for(int v: VALUES){
                cards.add(new Card(s,v));
            }
        }
    }

    public void printDeck(){
        for(Card c: cards){
            System.out.println(c);
        }
    }

    public Card deal(){
        //deals bottom card
        return cards.remove(cards.size() - 1);
    }


    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    public void add(Card card){ cards.add(0, card);}
}
