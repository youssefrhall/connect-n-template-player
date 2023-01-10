package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.GameConfig;
import com.thehutgroup.accelerator.connectn.player.Position;
import com.thg.accelerator23.connectn.ai.halninethousand.CheckFullColumns;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckFullColumnsTest {
    @Test
    public void checkFullColumns(){
        Board board = Mockito.mock(Board.class);
        GameConfig gameConfig = new GameConfig(10,8,4);
        Mockito.when(board.getConfig()).thenReturn(gameConfig);
        Mockito.when(board.hasCounterAtPosition(new Position(0,7))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(5,7))).thenReturn(true);
        Mockito.when(board.hasCounterAtPosition(new Position(6,6))).thenReturn(true);
        CheckFullColumns checkFullColumns = new CheckFullColumns(board);
        List<Integer> TestArrayList = List.of(1,2,3,4,6,7,8,9);
        assertEquals(TestArrayList, checkFullColumns.fullColumnChecker());
    }
}
