package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;


public class Minimax extends Player {
    public Minimax(Counter counter) {
        //TODO: fill in your name here
        super(counter, Four0.class.getName());
    }

    @Override
    public int makeMove(Board board) {
        MiniMax miniMax = new MiniMax(getCounter());
        return miniMax.miniMaxWithAlphaBetaPruning(board,0,true,-1000,1000);
    }
}
