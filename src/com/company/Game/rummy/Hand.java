package com.company.Game.rummy;


import com.company.Game.deck.Card;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    private List<Card> cards = new ArrayList<>();
    private Actor holder;

    public Hand(Actor holder){
        this.holder = holder;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public String displayHand(){
        StringBuilder output = new StringBuilder();
//        for(Card card: cards){
//            output.append(card.display()).append(" ");
//        }

        for(int i = 0; i < cards.size(); i++){
            output.append(i + 1).append(".|").append(cards.get(i).display()).append(" ");
        }

        return output.toString().trim();
    }

    public int size(){
        return cards.size();
    }

    public String getName(){
        return holder.getName();
    }

    public int getValue(){
        int score = 0;

        for(Card card: cards){
            int value = card.getRank();
            switch (value){
                case 1 -> {
                    value = 1;
                    score += value;
                }
                case 11,12,13 -> score += 10;
                default -> score += value;
            }
        }
        return score;
    }

    public Card removeCard(int index){
        // take card at index out of hand and return to table.
        return cards.remove(index);
    }

    public byte getAction(Hand activeHand) { return holder.getAction(this);
    }
}
