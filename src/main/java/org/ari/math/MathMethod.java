package org.ari.math;

import java.math.BigDecimal;

public class MathMethod {
    private MathMethod() {
        //empty constructor
    }

    /**
     *
     * @param value
     * @return BigDecimal telling how many times 1 has to be multiplied with the base to get the value.
     */
    public static double howManyTimesOneIsMultipliedWithBase(double base,int value) {
       return Math.log(value)/Math.log(base);
    }
}
