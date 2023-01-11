package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovesTest {


//    @Test
//    void winFinderHorizontal() {
//        Board board = Mockito.mock(Board.class);
//        GameConfig gameConfig = new GameConfig(10,8,4);
//        Mockito.when(board.getConfig()).thenReturn(gameConfig);
//        Arena arena = new Arena(board);
//        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
//        Mockito.when(board.hasCounterAtPosition(new Position(4, 0))).thenReturn(true);
//        Mockito.when(board.hasCounterAtPosition(new Position(6, 0))).thenReturn(true);
//        arena.arenaUpdater(board);
//        arena.setCounter(3,0,Counter.X);
//        arena.setCounter(4,0,Counter.X);
//        arena.setCounter(6,0,Counter.X);
//        int moveMade = Moves.winFinder(arena, Counter.X, 4);
//        assertEquals(5, moveMade);
//    }


    @Test
    void horizontalWinTest() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        arena.setCounter(0,0,Counter.X);
        arena.setCounter(1,0,Counter.X);
        arena.setCounter(2,0,Counter.X);
        arena.setCounter(3,0,Counter.X);
        int[] moveHeight = new int[]{0};
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, moveHeight, 4));

        arena.setCounter(3,0, null);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, moveHeight, 3));

        arena.setCounter(2,0, null);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, moveHeight, 2));
    }


    @Test
    void verticalWin() {
    }

    @Test
    void diagonalDownWin() {
    }

    @Test
    void diagonalUpWin() {
    }
}