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

//    Counter opponentCounter;
//
//    public Counter getOpponentCounter() {
//        return opponentCounter;
//    }

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
            arena.opponentCounter = findOpponentCounter(getCounter());
        }
        System.out.println(Arrays.toString(arena.getPlayableHeight()));
        arena.arenaUpdater(board);
        arena.arenaUpdater(board);
        System.out.println(Arrays.toString(arena.getPlayableHeight()));
        int move = Moves.winFinder(arena, getCounter(), 4);
        int opMove = Moves.winFinder(arena, arena.getOpponentCounter(), 4);
        int move3 = Moves.winFinder(arena, getCounter(), 3);
        int opMove3 = Moves.winFinder(arena, arena.getOpponentCounter(), 3);
        int move2 = Moves.winFinder(arena, getCounter(), 2);
        int opMove2 = Moves.winFinder(arena, arena.getOpponentCounter(), 2);


        if (move != 11) {
            System.out.println("WINNNNNN");
            return move;
        } else if (opMove != 11) {
            System.out.println("BLOCKKKK");
            return opMove;
        } else if (move3 != 11) {
            System.out.println("GET THREE");
            return move3;
        } else if (move2 != 11) {
            System.out.println("GET TWO");
            return move2;
        } else if (opMove3 != 11) {
            System.out.println("BLOCK THREE");
            return opMove3;
        }  else if (opMove2 != 11) {
            System.out.println("BLOCK TWO");
            return opMove2;
        } else {
            CheckFullColumns checkFullColumns = new CheckFullColumns(board);
            List<Integer> emptyColumns = checkFullColumns.fullColumnChecker();
            Random rand = new Random();
            System.out.println(emptyColumns);
            System.out.println("RANDOMMMM");
            return emptyColumns.get(rand.nextInt(emptyColumns.size()));
        }
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
