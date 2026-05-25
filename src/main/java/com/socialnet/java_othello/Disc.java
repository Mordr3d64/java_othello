package com.socialnet.java_othello;
//discs
public class Disc {
    private char color; // 'B' or 'W'

    public Disc(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void flip() {
        color = (color == 'B') ? 'W' : 'B';
    }
}