package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    @Test
    void arenaUpdater() {
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Position position = new Position(0, 0);
        Mockito.when(board.hasCounterAtPosition(position)).thenReturn(true);
        Mockito.when(board.getCounterAtPosition(position)).thenReturn(Counter.X);
        Arena arena = new Arena(board);
        arena.arenaUpdater(board);
        assertEquals(Arrays.toString(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), Arrays.toString(arena.getPlayableHeight()));
        assertEquals(Counter.X, arena.getCounter(0 ,0));
    }
}