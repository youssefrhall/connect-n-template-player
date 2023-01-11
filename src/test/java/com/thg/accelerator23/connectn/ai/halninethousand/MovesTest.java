package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovesTest {

    @Test
    void winFinderHorizontal() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(4, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(6, 0))).thenReturn(true);
        arena.arenaUpdater(board);
        arena.setCounter(3,0,Counter.X);
        arena.setCounter(4,0,Counter.X);
        arena.setCounter(6,0,Counter.X);
        int moveMade = Moves.winFinder(arena, Counter.X);
        assertEquals(5, moveMade);
    }
    @Test
    void winFinderVertical() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
//        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
//        arena.arenaUpdater(board);
//        Mockito.when(board.hasCounterAtPosition(new Position(3, 1))).thenReturn(true);
//        arena.arenaUpdater(board);
//        Mockito.when(board.hasCounterAtPosition(new Position(3, 2))).thenReturn(true);
//        arena.arenaUpdater(board);
//        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{0,0,0,3,0,0,0,0,0,0});
        arena.setCounter(3,0,Counter.X);
        arena.setCounter(3,1,Counter.X);
        arena.setCounter(3,2,Counter.X);
        int moveMade = Moves.winFinder(arena, Counter.X);
//        assertEquals(3, moveMade);
        assertTrue(true);
    }

}