package com.socialnet.java_othello;

import java.util.List;
import java.util.Random;

public class EasyAI implements AIPlayer{

    @Override
    public Move chooseMove(ReversiGame game, char player) {
        List<Move> moves = game.getValidMoves(player);
        Random rng = new Random();
        Move randomMove = moves.get(rng.nextInt(moves.size()));
        return randomMove;
    }
}
