package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thg.accelerator23.connectn.ai.halninethousand.MiniMax.MiniMax;

public class main {
    public static void main(String[] args) {
        MiniMax miniMax = new MiniMax();

        int finalValue = miniMax.miniMaxWithAlphaBetaPruning(0,0,true,-1000,1000);
        System.out.println(finalValue);
    }
}
