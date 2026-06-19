package com.socialnet.java_othello;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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

    public Circle createGraphic() {
        Circle c = new Circle(20);
        if (color == 'B') {
            c.setFill(Color.BLACK);
        } else {
            c.setFill(Color.WHITE);
            c.setStroke(Color.BLACK);
        }
        return c;
    }
}