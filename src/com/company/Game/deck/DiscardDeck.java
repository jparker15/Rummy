package com.company.Game.deck;

import java.util.ArrayList;
import java.util.List;

public class DiscardDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public int getSize(){return cards.size();}

    public String displayDeck(){
        StringBuilder output = new StringBuilder();
        for(Card card: cards){
            output.append(card.display()).append(" \n");
        }
        return output.toString().trim();
    }

    public Card draw(int index){
        return cards.remove(index);
    }

    @Override
    public void shuffle() {

    }

    @Override
    public Card draw() {

        return null;
    }
}
