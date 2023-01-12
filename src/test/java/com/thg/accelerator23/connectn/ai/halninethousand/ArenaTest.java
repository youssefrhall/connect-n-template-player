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
    void getCounterPosition() {
        RulesBased3 rulesBased3 = new RulesBased3(Counter.X);
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Arena arena = new Arena(board);
        Mockito.when(board.hasCounterAtPosition(new Position(3, 0))).thenReturn(true);
        System.out.println("mock :" + board.hasCounterAtPosition(new Position(3, 0)));
        arena.arenaUpdater(board);
        assertEquals(Arrays.toString(new int[]{0,0,0,1,0,0,0,0,0,0}), Arrays.toString(arena.getPlayableHeight()));
    }
}