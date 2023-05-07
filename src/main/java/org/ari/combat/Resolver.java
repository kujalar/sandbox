package org.ari.combat;

import org.ari.dice.DiceResult;
import org.ari.dice.DiceRoller;

public class Resolver {

    DiceRoller diceRoller = new DiceRoller();
    public void meleeCombat(String nameOne, String nameTwo) {
        DiceResult diceResult = diceRoller.roll2D6();
        System.out.println(nameOne+" vs "+nameTwo+" result = "+diceResult.getTotal());
    }
}
