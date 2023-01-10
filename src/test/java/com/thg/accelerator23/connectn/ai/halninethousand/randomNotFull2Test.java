package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class randomNotFull2Test {

    @Test
    void makeMove() {
        randomNotFull2 randomNotFull2 = new randomNotFull2(Counter.X);
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(2,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Mockito.when(board.hasCounterAtPosition(new Position(0,7))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(1,6))).thenReturn(true);
        assertEquals(1, randomNotFull2.makeMove(board));
    }
}