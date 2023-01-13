package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        int middleColumn = board.getConfig().getWidth()/2 -1;
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
            System.out.println(board.hasCounterAtPosition(new Position(4,0)));
            int finalValue =  miniMax.miniMaxWithAlphaBetaPruning(board,0,true,-1000,1000);
            System.out.println(finalValue);
            return finalValue;
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
                    }}
            }
            arena.setCounter(column, moveHeight[column], null);
        }
        ;
        return 11;
    }

    public static boolean helpOpponentWin(Arena arena, int column, Counter opponent){
        int[] moveHeight = arena.getPlayableHeight();
        arena.setCounter(column, moveHeight[column], opponent);
        if (WinFinders.verticalWin(arena, opponent, column, moveHeight) || WinFinders.diagonalDownWin(arena, opponent, column, moveHeight) || WinFinders.diagonalUpWin(arena, opponent, column, moveHeight)){
            arena.setCounter(column, moveHeight[column], null);
            moveHeight[column] = moveHeight[column] -1;
            System.out.println(column);
            return true;
        }
        arena.setCounter(column, moveHeight[column], null);
        moveHeight[column] = moveHeight[column] -1;
        return false;
    }

    private int randomMove(){
        List<Integer> emptyColumns = fullColumnChecker();
        Random rand = new Random();
        System.out.println(emptyColumns);
        System.out.println("making random move");
        return emptyColumns.get(rand.nextInt(emptyColumns.size()));
    }

    public List<Integer> fullColumnChecker(){
        List<Integer> emptyColumns = new ArrayList<>();
        for (int column = 0; column < arena.getConfig().getWidth(); column++){
            if(arena.getCounter(column, arena.getConfig().getHeight()-1) == null){
                emptyColumns.add(column);
            }
        }
        return emptyColumns;
    }

}
