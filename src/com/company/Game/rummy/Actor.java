package com.company.Game.rummy;

public interface Actor {
    byte DRAW = 1;
    byte ALTDRAW = 2;
    byte KNOCK = 3;
    byte VALUESORT = 4;
    byte SUITSORT = 5;
    byte QUIT = 0;

    String getName();
    byte getAction(Hand hand);
}
