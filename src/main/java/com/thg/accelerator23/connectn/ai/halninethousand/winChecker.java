package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.;
import com.thehutgroup.accelerator.connectn.player.Counter;

public class winChecker {

    public void winCheck(Arena arena, Counter counter){
        int[] heighestCounter = arena.getHeighestCounter();
        for (int column = 0; column < 10; column++){
            arena.setCounter(column, heighestCounter[column], counter);
            GameState doesWin = calculateGameState(arena);

        }
    }
}
