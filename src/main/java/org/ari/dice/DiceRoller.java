package org.ari.dice;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class DiceRoller {
    SecureRandom random = new SecureRandom();
    public DiceResult roll2D6() {
        List<Dice> dices = new ArrayList<>();
        for(int i=0;i<2;i++){
            dices.add(roll(DiceType.D6));
        }
        return new DiceResult(dices);
    }

    public Dice roll(DiceType diceType) {
        int result = random.nextInt(diceType.getOrigin(),diceType.getBound());
        return new Dice(diceType, result);
    }
}
