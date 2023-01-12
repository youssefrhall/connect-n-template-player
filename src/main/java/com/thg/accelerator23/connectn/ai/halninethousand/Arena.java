package com.thg.accelerator23.connectn.ai.halninethousand;


import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;

public class Arena {
    private Counter[][] counterPositions;
    private GameConfig config;
    private int[] playableHeight;

    private int turn;

    Arena(Board board) {
        this.config = board.getConfig();
        this.counterPositions = new Counter[board.getConfig().getWidth()][board.getConfig().getHeight()];
        this.playableHeight = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public void arenaUpdater(Board board) {
        int width = board.getConfig().getWidth();
        int height = board.getConfig().getHeight();
        for (int column = 0; column < width; column++) {
            if (board.hasCounterAtPosition(new Position(column, playableHeight[column])) && this.counterPositions[column][playableHeight[column]] == null) {
                this.counterPositions[column][playableHeight[column]] = board.getCounterAtPosition(new Position(column, playableHeight[column]));
                if (this.playableHeight[column] < height - 1) {
                    this.playableHeight[column] += 1;
                }
            }
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

    public Counter[][] getCounterPositions() {
        return counterPositions;
    }

    public GameConfig getConfig() {
        return config;
    }
}

