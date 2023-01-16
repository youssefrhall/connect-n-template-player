package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MovesTest {

    @Test
    void horizontalWinTest() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Mockito.when(arena.getOpponentCounter()).thenReturn(Counter.O);

        Mockito.when(arena.getCounter(3,0)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(4,0)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(5,0)).thenReturn(Counter.X);
        assertTrue(WinFinders.horizontalWin(arena, Counter.X, 3, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(6,0)).thenReturn(Counter.X);
        assertTrue(WinFinders.horizontalWin(arena, Counter.X, 3, arena.getPlayableHeight(), 4));
        Mockito.when(arena.getCounter(3,0)).thenReturn(Counter.O);
//        assertFalse(WinFinders.horizontalWin(arena, Counter.X, 3, arena.getPlayableHeight(), 3));
    }


    @Test
    void verticalWinTest() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getCounter(0,0)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertFalse(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        Mockito.when(arena.getCounter(0,1)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertFalse(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(0,2)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(0,3)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
        Mockito.when(arena.getCounter(0,4)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(0,5)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(0,6)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
        assertTrue(WinFinders.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 7));

    }

    @Test
    void diagonalDownWin() {
    }

    @Test
    void diagonalUpWin() {
    }
}