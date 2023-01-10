package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.InvalidMoveException;
import com.thehutgroup.accelerator.connectn.player.Position;

//public class BoardFunctions {
//    public void placeCounterAtPosition(Counter counter, int x, Board board) throws InvalidMoveException {
//        if (!board.isWithinBoard(new Position(x, 0))) {
//            throw new InvalidMoveException("Outside the bounds of the board");
//        } else {
//            Position position = new Position(x, getMinVacantY(x));
//            if (board.hasCounterAtPosition(position)) {
//                throw new InvalidMoveException("Column is full");
//            } else {
//                board.counterPlacements[position.getX()][getMinVacantY(position.getX())] = counter;
//            }
//        }
//    }
//    private int getMinVacantY(int x) {
//        for(int i = this.config.getHeight() - 1; i >= 0; --i) {
//            if (i == 0 || this.counterPlacements[x][i - 1] != null) {
//                return i;
//            }
//        }
//
//        throw new RuntimeException("no y is vacant");
//    }
//}
