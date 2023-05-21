package org.ari.combat;

import org.ari.math.MathMethod;

public class ArmyImpl implements Unit {
    int size;

    public ArmyImpl(int size)  {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
    public int getSizeMod() {
        int sizeMod = (int)(2.0*MathMethod.howManyTimesOneIsMultipliedWithBase(1.95,getSize()));
        return sizeMod;
    }

}
