package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class JoueurTest {

    @Test
    public void getNom() {
        Joueur tester = new Joueur("test");
        assertEquals("Expect test", "test",tester.getNom());
    }
}