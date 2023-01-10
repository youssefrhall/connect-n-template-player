package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;

import java.util.List;
import java.util.Random;


public class RulesBased3 extends Player {
  public RulesBased3(Counter counter) {
    //TODO: fill in your name here
    super(counter, RulesBased3.class.getName());
  }

  @Override
  public int makeMove(Board board) {
    //TODO: some crazy analysis
    //TODO: make sure said analysis uses less than 2G of heap and returns within 10 seconds on whichever machine is running it
    CheckFullColumns checkFullColumns = new CheckFullColumns(board);
    List<Integer> emptyColumns = checkFullColumns.fullColumnChecker();
    Random rand = new Random();
    System.out.println(emptyColumns);
    return emptyColumns.get(rand.nextInt(emptyColumns.size()));
  }
}
