package org.ari.dice;

public enum DiceType {
    D4(1,5),
    D6(1,7),
    D8(1,9),
    D10(1,11),
    D12(1,13),
    D20(1,21);

    final private int origin,bound;

    DiceType(int origin, int bound) {
        this.origin = origin;
        this.bound = bound;
    }

    public int getOrigin() {
        return origin;
    }
    public int getBound() {
        return bound;
    }
}
