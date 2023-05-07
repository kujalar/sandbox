package org.ari.combat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class MeleeCombatTest {
    @InjectMocks
    Resolver resolver;

    @BeforeEach
    public void before(){
        resolver = new Resolver();
    }

    @Test
    @DisplayName("Test melee combat")
    public void meleeCombatTest() {
        //TODO mockita nopanheitto rajapintaan, nyt en jaksa enempää
        resolver.meleeCombat("orc","man");
    }
}
