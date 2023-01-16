package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveReturner {

    public static int findMove(Board board, RulesBased3 rulesBased3) {
        if (rulesBased3.arena.getCounter(4, 0) == null) {
            return 4;
        }

        int four = winFinder(rulesBased3.arena, rulesBased3.getCounter(), 4);
        int opFour = winFinder(rulesBased3.arena, rulesBased3.getOpponentCounter(), 4);
        int three = winFinder(rulesBased3.arena, rulesBased3.getCounter(), 3);
        if (four != 11) {
            System.out.println("GET 4");
            return four;
        } else if (opFour != 11) {
            System.out.println("BLOCK 4");
            return opFour;
        } else if (three != 11) {
            System.out.println("GET 3");
            return three;
        } else {
            MiniMax miniMax = new MiniMax(rulesBased3.getCounter());
            int finalvalue = miniMax.miniMaxWithAlphaBetaPruning(board, 0, true, -1000, 1000);
            System.out.println(finalvalue);
            return finalvalue;
        }
    }

    public static int[] getNextPlayableHeight(Arena arena) {
        int[] next = new int[10];
        for (int i = 0; i < arena.getConfig().getWidth(); i++) {
            next[i] = arena.getPlayableHeight()[i] + 1;
        }
        return next;
    }

    public static List<Integer> runWinFinders(Arena arena, Counter counter, int numCounters, int[] moveHeight) {
        List<Integer> columns = new ArrayList<>();
        for (int column = 0; column < 10; column++) {
            if (moveHeight[column] < 8) {
                arena.setCounter(column, moveHeight[column], counter);
                if (moveHeight[column] < 7) {
                    if (WinFinders.horizontalWin(arena, counter, column, moveHeight, numCounters) || WinFinders.verticalWin(arena, counter, column, moveHeight, numCounters) || WinFinders.diagonalDownWin(arena, counter, column, moveHeight) || WinFinders.diagonalUpWin(arena, counter, column, moveHeight)) {
                        arena.setCounter(column, moveHeight[column], null);
                        columns.add(column);
                    }
                }
            }
            arena.setCounter(column, moveHeight[column], null);
        }
        return columns;
    }


    private static int winFinder(Arena arena, Counter counter, int numCounters) {
        int[] moveHeight = arena.getPlayableHeight();
        int[] nextMoveHeight = getNextPlayableHeight(arena);

        List<Integer> validMoves = runWinFinders(arena, counter, numCounters, moveHeight);
        List<Integer> helpsOpponent = runWinFinders(arena, counter, numCounters, nextMoveHeight);
        System.out.println(validMoves + " validMoves");
        System.out.println(helpsOpponent + " helpsOpponent");
        validMoves.removeAll(helpsOpponent);
        if (!validMoves.isEmpty()) {
            return validMoves.get(0);
        }
        return 11;
    }

//    public static boolean helpOpponentWin(Arena arena, int column, Counter opponent){
//        int[] moveHeight = arena.getPlayableHeight();
//        arena.setCounter(column, moveHeight[column], opponent);
//        if (WinFinders.verticalWin(arena, opponent, column, moveHeight) || WinFinders.diagonalDownWin(arena, opponent, column, moveHeight) || WinFinders.diagonalUpWin(arena, opponent, column, moveHeight)){
//            arena.setCounter(column, moveHeight[column], null);
//            moveHeight[column] = moveHeight[column] -1;
//            System.out.println(column);
//            return true;
//        }
//        arena.setCounter(column, moveHeight[column], null);
//        moveHeight[column] = moveHeight[column] -1;
//        return false;
//    }

//    private int randomMove(){
//        List<Integer> emptyColumns = fullColumnChecker();
//        Random rand = new Random();
//        System.out.println(emptyColumns);
//        System.out.println("making random move");
//        return emptyColumns.get(rand.nextInt(emptyColumns.size()));
//    }

    public List<Integer> fullColumnChecker(RulesBased3 rulesBased3) {
        List<Integer> emptyColumns = new ArrayList<>();
        for (int column = 0; column < rulesBased3.arena.getConfig().getWidth(); column++) {
            if (rulesBased3.arena.getCounter(column, rulesBased3.arena.getConfig().getHeight() - 1) == null) {
                emptyColumns.add(column);
            }
        }
        return emptyColumns;
    }

}
