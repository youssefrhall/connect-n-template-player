package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Counter;

public class Moves {

    private int turn;

    public static int winFinder(Arena arena, Counter counter) {
        int[] moveHeight = arena.getPlayableHeight();
        for (int column = 0; column < 10; column++) {
            if(moveHeight[column] < 8) {
                arena.setCounter(column, moveHeight[column], counter);
                if (horizontalWin(arena, counter, column, moveHeight) || verticalWin(arena, counter, column, moveHeight) || diagonalDownWin(arena, counter, column, moveHeight) || diagonalUpWin(arena, counter, column, moveHeight)) {
                    arena.setCounter(column, moveHeight[column], null);
                    return column;
                }
            }
            arena.setCounter(column, moveHeight[column], null);
        }
        ;
        return 11;
    }

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
        for (int offset = 0; offset < 3; offset++) {
            if (arena.getPlayableHeight()[column] > 2 && column - offset >= 0 && column - offset + 3 < 10 && moveHeight[column] + offset - 3 >= 0 && moveHeight[column] + offset < 7) {
                if (arena.getCounter(column - offset, moveHeight[column] + offset) == counter && arena.getCounter(column + 1 - offset, moveHeight[column] - 1 + offset) == counter && arena.getCounter(column + 2 - offset, moveHeight[column] - 2 + offset) == counter && arena.getCounter(column + 3 - offset, moveHeight[column] - 3 + offset) == counter) {
                    System.out.println("diagonal down win");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean diagonalUpWin(Arena arena, Counter counter, int column, int[] moveHeight) {

        for (int offset = 0; offset < 3; offset++) {
            if (arena.getPlayableHeight()[column] < 7 && column - offset >= 0 && column - offset + 3 < 10 && moveHeight[column] - offset >= 0 && moveHeight[column] - offset < 10) {
                if (arena.getCounter(column - offset, moveHeight[column] - offset) == counter && arena.getCounter(column + 1 - offset, moveHeight[column] + 1 - offset) == counter && arena.getCounter(column + 2 - offset, moveHeight[column] + 2 - offset) == counter && arena.getCounter(column + 3 - offset, moveHeight[column] + 3 - offset) == counter) {
                    System.out.println("diagonal up win");
                    return true;
                }
            }
        }
        return false;
    }

}
