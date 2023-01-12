package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Position;

import java.util.ArrayList;
import java.util.List;

public class CheckFullColumns {
    private final Arena arena;

    private final Counter opponentsCounter;
    public CheckFullColumns(Arena arena, Counter opponentsCounter){
        this.arena = arena;
        this.opponentsCounter = opponentsCounter;
    }

    public List<Integer> fullColumnChecker(){
        List<Integer> emptyColumns = new ArrayList<>();
        for (int column = 0; column < arena.getConfig().getWidth(); column++){
            if(arena.getCounter(column, arena.getConfig().getHeight()) == null){
                emptyColumns.add(column);
            }
        }
        return emptyColumns;
    }

}
