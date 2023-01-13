package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Counter;

public class WinFinders {

    private int turn;


    public static boolean horizontalWin(Arena arena, Counter counter, int column, int[] moveHeight) {
        for (int offset = 0; offset <= 3; offset++) {
            if (column - offset >= 0 && column - offset + 3 < 10) {
                if (arena.getCounter(column - offset, moveHeight[column]) == counter && arena.getCounter(column + 1 - offset, moveHeight[column]) == counter && arena.getCounter(column + 2 - offset, moveHeight[column]) == counter && arena.getCounter(column + 3 - offset, moveHeight[column]) == counter) {
                    System.out.println("horizonal move");
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean verticalWin(Arena arena, Counter counter, int column, int[] moveHeight) {
        if (arena.getPlayableHeight()[column] > 2) {
            if (arena.getCounter(column, moveHeight[column]) == counter && arena.getCounter(column, moveHeight[column] - 1) == counter && arena.getCounter(column, moveHeight[column] - 2) == counter && arena.getCounter(column, moveHeight[column] - 3) == counter) {
                System.out.println("vertical move");
                return true;
            }
        }

        return false;
    }

    public static boolean diagonalDownWin(Arena arena, Counter counter, int column, int[] moveHeight) {
        for (int offset = 0; offset <= 3; offset++) {
            if (arena.getPlayableHeight()[column] > 2-offset && column - offset >= 0 && column - offset + 3 < 10 && moveHeight[column] + offset - 3 >= 0 && moveHeight[column] + offset < 7) {
                if (arena.getCounter(column - offset, moveHeight[column] + offset) == counter && arena.getCounter(column + 1 - offset, moveHeight[column] - 1 + offset) == counter && arena.getCounter(column + 2 - offset, moveHeight[column] - 2 + offset) == counter && arena.getCounter(column + 3 - offset, moveHeight[column] - 3 + offset) == counter) {
                    System.out.println("diagonal down win");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean diagonalUpWin(Arena arena, Counter counter, int column, int[] moveHeight) {
        for (int offset = 0; offset <= 3; offset++) {
            if (arena.getPlayableHeight()[column] < 7+offset && column - offset >= 0 && column - offset + 3 < 10 && moveHeight[column] - offset >= 0 && moveHeight[column] - offset < 10) {
                if (arena.getCounter(column - offset, moveHeight[column] - offset) == counter && arena.getCounter(column + 1 - offset, moveHeight[column] + 1 - offset) == counter && arena.getCounter(column + 2 - offset, moveHeight[column] + 2 - offset) == counter && arena.getCounter(column + 3 - offset, moveHeight[column] + 3 - offset) == counter) {
                    System.out.println("diagonal up win");
                    return true;
                }
            }
        }
        return false;
    }

}
