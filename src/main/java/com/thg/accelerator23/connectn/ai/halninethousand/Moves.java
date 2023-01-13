package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Counter;

public class Moves {

    public static int winFinder(Arena arena, Counter counter, int winLength) {
        int[] moveHeight = arena.getPlayableHeight();
        for (int column = 0; column < 10; column++) {
            if (moveHeight[column] < 8) {
                arena.setCounter(column, moveHeight[column], counter);
                if (horizontalWin(arena, counter, column, moveHeight, winLength) || verticalWin(arena, counter, column, moveHeight, winLength) || diagonalDownWin(arena, counter, column, moveHeight) || diagonalUpWin(arena, counter, column, moveHeight)) {
                    arena.setCounter(column, moveHeight[column], null);
                    return column;
                }
            }
            arena.setCounter(column, moveHeight[column], null);
        }
        return 11;
    }

    public static boolean horizontalWin(Arena arena, Counter counter, int column, int[] moveHeight, int count) {
        for(int offset = 0; offset < 4; offset++) {
            if (column - offset >= 0 && column - offset + 3 < 10) {
//                System.out.println();
//                System.out.println("count " + count);
                int counterCount = 0;
                int opponentCounterCount = 0;
                for (int i = 0; i < 4; i++) {
//                    System.out.println("X:" + (column + i - offset) + " Y:" + moveHeight[column] + " Counter: " + arena.getCounter(column + i - offset, moveHeight[column]));
                    if ((arena.getCounter(column + i - offset, moveHeight[column]) == counter)) {
                        counterCount += 1;
                    }
                    if ((arena.getCounter(column + i - offset, moveHeight[column]) == RulesBased3.findOpponentCounter(counter))) {
                        opponentCounterCount += 1;
                    }
                }
//                System.out.println("counterCount " + counterCount);
//                System.out.println("opponentCounterCount " + opponentCounterCount);
                if (counterCount >= count && opponentCounterCount == 0) {
                    System.out.println("horizonal move");
                    return true;
                }
            }
        }
//        System.out.println("not horizontal move");
        return false;
    }

    public static boolean verticalWin(Arena arena, Counter counter, int column, int[] moveHeight, int count) {
//        System.out.println("position high enough for count");
//        System.out.println(arena.getPlayableHeight()[column] + " arena.getPlayableHeight()[column]");
//        System.out.println(count + " count");
        if (arena.getPlayableHeight()[column] + 1 >= count) {
//            System.out.println(arena.getPlayableHeight()[column] >= count - 1);
            int counterCount = 0;
            for (int i = 0; i > -count; i--) {
//                System.out.println("x:" + column + " y:" + (moveHeight[column] + i) + " Counter:" +arena.getCounter(column, moveHeight[column] + i));
                if (arena.getCounter(column, moveHeight[column] + i) == counter) {
                    counterCount += 1;
//                    System.out.println(counterCount);
                    if (counterCount >= count) {
                        System.out.println("vertical move");
                        return true;
                    }

                }
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

    public static boolean diagonalUpWin(Arena arena, Counter counter, int column, int[] moveHeight) {
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
