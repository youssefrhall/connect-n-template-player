package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;
import com.thehutgroup.accelerator.connectn.player.Position;

import java.awt.geom.Area;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RulesBased3 extends Player {

    Arena arena;

    Counter counter;

    Counter opponentCounter;

//    MoveReturner moveReturner;

    public Counter getOpponentCounter() {
        return opponentCounter;
    }

    public Arena getArena() {
        return arena;
    }

    public RulesBased3(Counter counter) {
        //TODO: fill in your name here
        super(counter, RulesBased3.class.getName());
    }

//    //TODO: fill in your name here

    @Override
    public int makeMove(Board board) {
        //TODO: some crazy analysis
        //TODO: make sure said analysis uses less than 2G of heap and returns within 10 seconds on whichever machine is running it
        if (isStart(board)) {
            System.out.println("new arena");
            arena = new Arena(board);
            counter = getCounter();
            opponentCounter = findOpponentCounter(counter);
//            moveReturner = new MoveReturner(arena, counter, opponentCounter);
        }
        System.out.println(Arrays.toString(arena.getPlayableHeight()));
        arena.arenaUpdater(board);
//        return moveReturner.findMove(board);
        return MoveReturner.findMove(board, this);

    }


    public boolean isStart(Board board) {
        int counters = 0;
        for (int i = 0; i < board.getConfig().getWidth(); i++) {
            Position position = new Position(i, 0);
            if (board.hasCounterAtPosition(position)) {
                counters++;
            }
        }
        return counters < 2;
    }

    public static Counter findOpponentCounter(Counter counter) {
        if (counter.equals(Counter.X)) {
            return Counter.O;
        } else {
            return Counter.X;
        }
    }
}
