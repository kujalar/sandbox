package org.ari.dice;

import java.util.List;

public class DiceResult {
    List<Dice> dices;

    public DiceResult(List<Dice> dices) {
        this.dices = dices;
    }

    public int getTotal() {
        int total = 0;
        for(Dice dice: dices) {
            total += dice.getValue();
        }
        return total;
    }
}
