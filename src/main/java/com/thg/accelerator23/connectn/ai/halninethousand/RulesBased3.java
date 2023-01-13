package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;


public class RulesBased3 extends Player {

    Arena arena;

    Counter counter;

    Counter opponentCounter;

    MoveReturner moveReturner;

    Boolean isStart = true;

    public RulesBased3(Counter counter) {
        //TODO: fill in your name here
        super(counter, RulesBased3.class.getName());
    }

//    //TODO: fill in your name here

    @Override
    public int makeMove(Board board) {
        //TODO: some crazy analysis
        //TODO: make sure said analysis uses less than 2G of heap and returns within 10 seconds on whichever machine is running it
        if (isStart) {
            gameStarter(board);
        }
        arena.arenaUpdater(board);
        return moveReturner.findMove(board);

    }
    private void gameStarter(Board board){
        System.out.println("new arena");
        arena = new Arena(board);
        counter = getCounter();
        opponentCounter = findOpponentCounter();
        moveReturner = new MoveReturner(arena, counter, opponentCounter);
        isStart = false;
    }

    public Counter findOpponentCounter() {
        if (getCounter().equals(Counter.X)) {
            return Counter.O;
        } else {
            return Counter.X;
        }
    }
}
