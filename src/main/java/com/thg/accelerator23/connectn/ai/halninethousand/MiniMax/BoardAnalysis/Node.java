//package com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.BoardAnalysis;
//
//import com.thehutgroup.accelerator.connectn.player.*;
//
//
//public class Node {
//    private int move;
//    private Board board;
//    private final boolean player;
//    private Counter counter;
//
//    public Node(Board board, boolean player){
//        this.board = board;
//        this.player = player;
//    }
//    public GameState returnGameState () {
//        counter = player ? Counter.X : Counter.O;
//        BoardAnalyser boardAnalyser = new BoardAnalyser(new GameConfig(10, 8, 4));
//        try{
//            for(int x = 0; x < 10; x++){
//                if(!board.hasCounterAtPosition(new Position(x,7))){
//                    move = x;
//                    board = new Board(board, x, counter);
//                }
//            }
//        }catch (InvalidMoveException e){
//            System.out.println(e.getMessage());
//        }
//        return boardAnalyser.calculateGameState(board);
//    }
//
//    public Node returnChildNode(){
//        returnGameState();
//        return new Node(board, !player);
//    }
//    public int getMove() {
//        return move;
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//}
