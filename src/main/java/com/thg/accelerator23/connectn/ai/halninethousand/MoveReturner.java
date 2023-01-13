package com.thg.accelerator23.connectn.ai.halninethousand;
import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;

import java.util.Arrays;


public class MoveReturner {
    Arena arena;
    Counter counter;
    Counter opponentsCounter;

    MoveReturner(Arena arena, Counter counter, Counter opponentsCounter){
        this.arena = arena;
        this.counter = counter;
        this.opponentsCounter = opponentsCounter;
    }

    public int findMove(Board board){
        int middleColumn = board.getConfig().getWidth()/2;
        if(arena.getCounter(middleColumn,0) == null){
            return middleColumn;
        }
        int move = winFinder(arena, counter);
        if (move != 11){
            return move;
        }
        else{
            move = winFinder(arena, opponentsCounter);
        }
        if (move != 11){
            return move;
        }
        else{
            MiniMax miniMax = new MiniMax(counter);
            return miniMax.miniMaxWithAlphaBetaPruning(board,0,true,-1000,1000);
        }
    }

    private int winFinder(Arena arena, Counter counter) {
        int[] moveHeight = arena.getPlayableHeight();
        for (int column = 0; column < 10; column++) {
            if(moveHeight[column] < 8) {
                arena.setCounter(column, moveHeight[column], counter);
                if (moveHeight[column] < 7){
                    if (WinFinders.horizontalWin(arena, counter, column, moveHeight) || WinFinders.verticalWin(arena, counter, column, moveHeight) || WinFinders.diagonalDownWin(arena, counter, column, moveHeight) || WinFinders.diagonalUpWin(arena, counter, column, moveHeight)) {
                        arena.setCounter(column, moveHeight[column], null);
                        return column;
                    }
                }
                arena.setCounter(column, moveHeight[column], null);
            }
        }
        return 11;
    }
}
