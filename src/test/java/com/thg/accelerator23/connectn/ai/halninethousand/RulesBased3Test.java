package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Counter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesBased3Test {

    @Test
    void findOpponentCounterTest(){
        TheConnectFourConundrumABotSoBadItsAlmostGood rulesBased3 = new TheConnectFourConundrumABotSoBadItsAlmostGood(Counter.X);
        Counter solution = rulesBased3.findOpponentCounter();
        assertEquals(Counter.O, solution);

    }

}