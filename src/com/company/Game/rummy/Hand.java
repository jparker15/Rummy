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
        for(Card card: cards){
            output.append(card.display()).append(" ");
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
        boolean haveAce11 = false;
        for(Card card: cards){
            int value = card.getRank();
            switch (value){
                case 1 -> {
                    value = score + 11 > 21 ? 1 : 11;
                    if(value == 11){
                        haveAce11 = true;
                    }
                    score += value;
                }
                case 11,12,13 -> score += 10;
                default -> score += value;
            }
            if(score > 21 && haveAce11){
                score -= 10;
                haveAce11 =false;
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
