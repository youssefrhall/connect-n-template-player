package com.thg.accelerator23.connectn.ai.halninethousand;

public class MiniMax {
    public int miniMaxWithAlphaBetaPruning(int node,int depth, boolean maximizingPlayer, int alpha, int beta){
        if(depth == 40){
            //System.out.println(values[node]);
            System.out.println(node);
            return node;
        }
        if(maximizingPlayer){
            int maxValue = -1000;
            for(int i = 0; i < 2; i++){
                int score = miniMaxWithAlphaBetaPruning(node * 2 + i,depth + 1, false, alpha, beta);
                maxValue = Math.max(maxValue, score);
                alpha = Math.max(alpha, maxValue);
                if(beta <= alpha){
                    break;
                }
            }
            return maxValue;
        }else{
            int minvalue = 1000;
            for(int i = 0; i < 2; i++){
                int score = miniMaxWithAlphaBetaPruning(node * 2 + i,depth + 1, true, alpha, beta);
                minvalue = Math.min(minvalue, score);
                beta = Math.min(beta, minvalue);
                if(beta <= alpha){
                    break;
                }
            }
            return minvalue;
        }
    }
}
