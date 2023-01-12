package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MovesTest {

    @Test
    void horizontalWinTest() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Mockito.when(arena.getCounter(0,0)).thenReturn(Counter.X);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 2, arena.getPlayableHeight(), 1));
        assertEquals(false, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        Mockito.when(arena.getCounter(1,0)).thenReturn(Counter.X);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertEquals(false, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(2,0)).thenReturn(Counter.X);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        assertEquals(false, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
        Mockito.when(arena.getCounter(3,0)).thenReturn(Counter.X);
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        assertEquals(true, Moves.horizontalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
    }


    @Test
    void verticalWinTest() {
        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getCounter(0,0)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertEquals(false, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        Mockito.when(arena.getCounter(0,1)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 1));
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertEquals(false, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(0,2)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 2));
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 3));
        Mockito.when(arena.getCounter(0,3)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
        Mockito.when(arena.getCounter(0,4)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(0,5)).thenReturn(Counter.X);
        Mockito.when(arena.getCounter(0,6)).thenReturn(Counter.X);
        Mockito.when(arena.getPlayableHeight()).thenReturn(new int[]{6, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 4));
        assertEquals(true, Moves.verticalWin(arena, Counter.X, 0, arena.getPlayableHeight(), 7));

    }

    @Test
    void diagonalDownWin() {
    }

    @Test
    void diagonalUpWin() {
    }
}