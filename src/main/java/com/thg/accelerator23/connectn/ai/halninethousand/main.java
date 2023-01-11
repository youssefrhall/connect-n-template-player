package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;

public class main {
    public static void main(String[] args) {
        MiniMax miniMax = new MiniMax();
        Board board = new Board(new GameConfig(10,8,4));
        int finalValue = miniMax.miniMaxWithAlphaBetaPruning(board,0,true,-1000,1000);
        System.out.println(finalValue);
    }
}
