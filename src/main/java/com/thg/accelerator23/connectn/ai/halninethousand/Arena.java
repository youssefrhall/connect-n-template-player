package com.thg.accelerator23.connectn.ai.halninethousand;


import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;

public class Arena {
    private Counter[][] counterPositions;
    private int[] playableHeight;


    Arena(Board board){
        this.counterPositions = new Counter[board.getConfig().getWidth()][board.getConfig().getHeight()];
        this.playableHeight = playableHeightMaker(board);
    }

    private int[] playableHeightMaker(Board board){
        int[] playableHeightList = new int[board.getConfig().getWidth()];
        for (int index = 0; index < playableHeightList.length; index++){
            playableHeightList[index] = 0;
        }
        return playableHeightList;
    }

    public void arenaUpdater(Board board){
        int width = board.getConfig().getWidth();
        for (int column = 0; column < width; column++){
            if (board.hasCounterAtPosition(new Position(column, playableHeight[column]))&& this.counterPositions[column][playableHeight[column]] == null ) {
                topCounterCheck(board,column,playableHeight[column]);
            }
        }
    }
    private void topCounterCheck(Board board, int column, int height){
        this.counterPositions[column][playableHeight[column]] = board.getCounterAtPosition(new Position(column, playableHeight[column]));
        this.playableHeight[column] += 1;
        if (board.hasCounterAtPosition(new Position(column, height +1))){
            topCounterCheck(board, column, height+1);
        }
    }

    public int[] getPlayableHeight() {
        return playableHeight;
    }

    public Counter getCounter(int x, int y) {
        return counterPositions[x][y];
    }

    public void setCounter(int x, int y, Counter counter) {
       counterPositions[x][y] = counter;
    }

}

