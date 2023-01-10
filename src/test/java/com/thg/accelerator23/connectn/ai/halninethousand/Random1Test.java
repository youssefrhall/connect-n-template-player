package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Random1Test {
    @Test
    public void random1Test(){
        Random1 random1 = new Random1(Counter.X);
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        int randomMove = random1.makeMove(board);
        assertTrue(randomMove <= 9 && randomMove >= 0);
    }
}
