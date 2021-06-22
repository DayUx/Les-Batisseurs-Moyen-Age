package model;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class JoueurTest {

    @Test
    public void getNom() {
        Joueur tester = new Joueur("test");
        assertEquals("Expect test", "test",tester.getNom());
    }
}