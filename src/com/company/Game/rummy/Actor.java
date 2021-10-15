package com.company.Game.rummy;

public interface Actor {
    byte DRAW = 1;
    byte DISCARD = 2;
    byte QUIT = 3;

    String getName();
    byte getAction(Hand hand);
}
