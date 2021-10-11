package com.company;

public class Card {
    private final String SUIT;
    private final int RANK;

    public Card(String SUIT, int RANK){
        this.SUIT = SUIT;
        this.RANK = RANK;

    }

    public int getRank(){return RANK;}

    public String display(){
        String output;
        switch (RANK) {
            case 1 -> output = "AC";
            case 11 -> output = "JA";
            case 12 -> output =  "QU";
            case 13 -> output =  "KI";
            default -> output =  RANK == 10 ? Integer.toString(RANK) : " " + RANK;
        };

        return output + " " + SUIT;
    }

    @Override
    public String toString(){
        return SUIT + " " + RANK;
    }
}
