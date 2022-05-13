package genspark.projects.dragoncave;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class DragonCavernTest {
    DragonCavern dc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testOneGoodOneBad()
    {
        dc = new DragonCavern(2,1);
        assertEquals(dc.stream().count(),2);
        assertEquals(dc.stream().filter(DragonCave::isGood).count(),1);
        assertEquals(dc.stream().filter(Predicate.not(DragonCave::isGood)).count(),1);
    }
    @Test
    void testTwoGoodNoBad()
    {
        dc = new DragonCavern(2,2);
        assertEquals(dc.stream().count(),2);
        assertEquals(dc.stream().filter(DragonCave::isGood).count(),2);
        assertEquals(dc.stream().filter(Predicate.not(DragonCave::isGood)).count(),0);
    }
    @Test
    void testNoGoodTwoBad()
    {
        dc = new DragonCavern(2,0);
        assertEquals(dc.stream().count(),2);
        assertEquals(dc.stream().filter(DragonCave::isGood).count(),0);
        assertEquals(dc.stream().filter(Predicate.not(DragonCave::isGood)).count(),2);
    }

    @Test
    void testFiftyGoodTwentyBad()
    {
        dc = new DragonCavern(70,50);
        assertEquals(dc.stream().count(),70);
        assertEquals(dc.stream().filter(DragonCave::isGood).count(),50);
        assertEquals(dc.stream().filter(Predicate.not(DragonCave::isGood)).count(),20);
    }
}