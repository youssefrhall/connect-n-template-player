package com.thg.accelerator23.connectn.ai.halninethousand.MiniMax;
import com.thehutgroup.accelerator.connectn.player.*;
import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.BoardAnalysis.BoardAnalyser;

public class MiniMax {
    private final Counter counter;
    public MiniMax(Counter counter){
        this.counter = counter;
    }
    public int miniMaxWithAlphaBetaPruning(Board board, int depth, boolean maximizingPlayer, int alpha, int beta) {
        BoardAnalyser boardAnalyser = new BoardAnalyser(new GameConfig(10,8,4));
        if(depth == 10 || boardAnalyser.calculateGameState(board).isEnd()){
            return evaluateBoard(boardAnalyser,board);
        }
        int bestMove = -1;
        if(maximizingPlayer){
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < 10; i++){
                if(board.hasCounterAtPosition(new Position(i,7))){
                    continue;
                }
                try{
                    board = new Board(board, i, counter);
                }catch (InvalidMoveException e){
                    //System.out.println(e.getMessage());
                }
                int score = miniMaxWithAlphaBetaPruning(board,depth + 1, false, alpha, beta);
                if (score > maxValue) {
                    maxValue = score;
                    bestMove = i;
                }
                alpha = Math.max(alpha, maxValue);
                if(beta <= alpha){
                    break;
                }
            }
            if(bestMove == -1){
                return maxValue;
            }
            return bestMove;
        }else{
            int minValue = Integer.MAX_VALUE;
            for(int i = 0; i < 10; i++){
                if(board.hasCounterAtPosition(new Position(i,7))){
                    continue;
                }
                try{
                    board = new Board(board, i, counter.getOther());
                }catch (InvalidMoveException e){
                    //System.out.println(e.getMessage());
                }
                int score = miniMaxWithAlphaBetaPruning(board,depth + 1, true, alpha, beta);
                if (score < minValue) {
                    minValue = score;
                    bestMove = i;
                }

                beta = Math.min(beta, minValue);
                if(beta <= alpha){
                    break;
                }
            }
            if(bestMove == -1){
                return minValue;
            }
            return bestMove;
        }
    }
    private int evaluateBoard(BoardAnalyser boardAnalyser,Board board){
        if(boardAnalyser.calculateGameState(board).getWinner() == counter){
            return 1000;
        } else if(boardAnalyser.calculateGameState(board).getWinner() == counter.getOther()) {
            return -1000;
        }
        if(!board.hasCounterAtPosition(new Position(4,0))){
            return 10000;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter) == 4){
            return 1000;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter.getOther()) == 4){
            return -1000;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter.getOther()) == 3){
            return -100;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter) == 3){
            return 100;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter) == 2) {
            return 5;
        }else if(boardAnalyser.calculateGameState(board).getMaxInARowByCounter().get(counter.getOther()) == 2){
            return -5;
        }
        else{
            return 0;
        }
    }
}
