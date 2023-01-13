package com.thg.accelerator23.connectn.ai.halninethousand;

import com.thehutgroup.accelerator.connectn.player.Counter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesBased3Test {

    @Test
    void findOpponentCounterTest(){
        RulesBased3 rulesBased3 = new RulesBased3(Counter.X);
        Counter solution = rulesBased3.findOpponentCounter();
        assertEquals(Counter.O, solution);

    }

}