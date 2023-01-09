package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Position;

import java.util.ArrayList;
import java.util.List;

public class CheckFullColumns {
    private final Board board;
    public CheckFullColumns(Board board){
        this.board = board;
    }

    public List<Integer> fullColumnChecker(){
        List<Integer> emptyColumns = new ArrayList<Integer>();
        for (int column = 0; column < 10; column++){
            if(!board.hasCounterAtPosition(new Position(column,board.getConfig().getHeight() - 1))){
                emptyColumns.add(column);
            }
        }
        return emptyColumns;
    }

}
