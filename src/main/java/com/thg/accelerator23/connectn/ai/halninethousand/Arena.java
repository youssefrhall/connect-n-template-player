package com.thg.accelerator23.connectn.ai.halninethousand;


import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;

import java.util.List;

public class Arena {
    private Counter[][] counterPositions;
    private GameConfig config;
    private int[] heighestCounter;

    Arena(Board board){
        this.config = board.getConfig();
        this.counterPositions = new Counter[board.getConfig().getWidth()][board.getConfig().getHeight()];
        this.heighestCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public void arenaUpdater(Board board){
        int width = board.getConfig().getWidth();
        int height = board.getConfig().getHeight();
        for (int column = 0; column < width; column++){
            if (board.hasCounterAtPosition(new Position(column, heighestCounter[column]))&& this.counterPositions[column][heighestCounter[column]] == null ) {
                this.counterPositions[column][heighestCounter[column]] = board.getCounterAtPosition(new Position(column, height));
                this.heighestCounter[column] += 1;
            }
        }
    }

    public int[] getHeighestCounter() {
        return heighestCounter;
    }

    public Counter getCounter(int x, int y) {
        return counterPositions[x][y];
    }

    public void setCounter(int x, int y, Counter counter) {
       counterPositions[x][y] = counter;
    }
}

