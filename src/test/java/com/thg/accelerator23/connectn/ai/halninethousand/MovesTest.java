package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        MoveReturner moveReturner = new MoveReturner(arena, Counter.X, Counter.O);
        arena.arenaUpdater(board);
        arena.setCounter(3,0,Counter.X);
        arena.setCounter(4,0,Counter.X);
        arena.setCounter(6,0,Counter.X);
        int moveMade = moveReturner.findMove(board);
        assertEquals(5, moveMade);
    }
    @Test
    void winFinderVertical() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 2))).thenReturn(true);
        MoveReturner moveReturner = new MoveReturner(arena, Counter.X, Counter.O);
        arena.arenaUpdater(board);
        arena.setCounter(3,0,Counter.X);
        arena.setCounter(3,1,Counter.X);
        arena.setCounter(3,2,Counter.X);
        arena.setCounter(4,0,Counter.O);
        int moveMade = moveReturner.findMove(board);
        assertEquals(3, moveMade);
    }

    @Test
    void winFinderDiagonalUp() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 2))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 2))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(1, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(1, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(0, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(4, 0))).thenReturn(true);
        MoveReturner moveReturner = new MoveReturner(arena, Counter.X, Counter.O);
        arena.arenaUpdater(board);
        arena.setCounter(4,0,Counter.O);
        arena.setCounter(3,0,Counter.O);
        arena.setCounter(3,1,Counter.X);
        arena.setCounter(3,2,Counter.X);
        arena.setCounter(2,0,Counter.O);
        arena.setCounter(2,1,Counter.O);
        arena.setCounter(2,2,Counter.X);
        arena.setCounter(1,0,Counter.O);
        arena.setCounter(1,1,Counter.X);
        arena.setCounter(0,0,Counter.X);
        int moveMade = moveReturner.findMove(board);
        assertEquals(3, moveMade);
    }

    @Test
    void winFinderDiagonalDown() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 2))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(2, 3))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 1))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 2))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(4, 0))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(4, 1))).thenReturn(true);
        MoveReturner moveReturner = new MoveReturner(arena, Counter.X, Counter.O);
        arena.arenaUpdater(board);
        arena.setCounter(2,0,Counter.O);
        arena.setCounter(2,1,Counter.O);
        arena.setCounter(2,2,Counter.O);
        arena.setCounter(2,3,Counter.X);
        arena.setCounter(3,0,Counter.O);
        arena.setCounter(3,1,Counter.O);
        arena.setCounter(3,2,Counter.X);
        arena.setCounter(4,0,Counter.X);
        arena.setCounter(4,1,Counter.X);
        int moveMade = moveReturner.findMove(board);
        assertEquals(5, moveMade);
}}