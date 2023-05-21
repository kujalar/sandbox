package org.ari.combat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmyImplTest {
    @Test
    public void testArmySizeMod() {
        Unit army1 = new ArmyImpl(1);
        Unit army2 = new ArmyImpl(2);
        Unit army3 = new ArmyImpl(3);
        Unit army4 = new ArmyImpl(4);
        Unit army10 = new ArmyImpl(10);
        Unit army20 = new ArmyImpl(20);
        Unit army25 = new ArmyImpl(25);
        Unit army50 = new ArmyImpl(50);
        Unit army100 = new ArmyImpl(100);
        Unit army200 = new ArmyImpl(200);
        Unit army250 = new ArmyImpl(250);
        Unit army400 = new ArmyImpl(400);
        Unit army500 = new ArmyImpl(500);
        Unit army1000 = new ArmyImpl(1000);
        assertEquals(0,army1.getSizeMod());
        assertEquals(2,army2.getSizeMod());
        assertEquals(3,army3.getSizeMod());
        assertEquals(4,army4.getSizeMod());
        assertEquals(6,army10.getSizeMod());
        assertEquals(8,army20.getSizeMod());
        assertEquals(9,army25.getSizeMod());
        assertEquals(11,army50.getSizeMod());
        assertEquals(13,army100.getSizeMod());
        assertEquals(15,army200.getSizeMod());
        assertEquals(16,army250.getSizeMod());
        assertEquals(17,army400.getSizeMod());
        assertEquals(18,army500.getSizeMod());
        assertEquals(20,army1000.getSizeMod());

    }
}
