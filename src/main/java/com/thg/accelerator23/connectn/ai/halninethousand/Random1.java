package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;
import com.thehutgroup.accelerator.connectn.player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Random1 extends Player {
  public Random1(Counter counter) {
    //TODO: fill in your name here
    super(counter, Random1.class.getName());
  }
  int getMinVacantY(int x, Board board){
    for (int i = board.getConfig().getHeight() - 1; i >= 0; --i) {
      if (i == 0 || board.getCounterAtPosition(new Position(x, i - 1)) != null) {
        return i;
      }
    }
    return -1;
  }
  @Override
  public int makeMove(Board board) {
    //TODO: some crazy analysis
    //TODO: make sure said analysis uses less than 2G of heap and returns within 10 seconds on whichever machine is running it

    List<Integer> notFull = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      if (getMinVacantY(i, board) != -1){
        notFull.add(i);
      }
    }
    //System.out.println("notFull :" + notFull);

    Random rand = new Random();
    return notFull.get(rand.nextInt(notFull.size()));


  }
}
