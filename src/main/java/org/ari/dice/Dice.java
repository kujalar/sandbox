package org.ari.dice;

public class Dice {
    final private int value;
    final private DiceType diceType;
    public Dice(DiceType diceType, int value) {
        this.diceType = diceType;
        this.value = value;
        System.out.println("result = "+value);
    }

    public int getValue() {
        return value;
    }
}
