package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Four0Test {
    @Test
    public void four0Test(){
        Four0 Four0 = new Four0(Counter.X);
        Board board = Mockito.mock(Board.class);
        assertEquals(4,Four0.makeMove(board));
    }
}
