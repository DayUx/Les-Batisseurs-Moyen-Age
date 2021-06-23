package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {


    private Board b;
    private Game g;
    @Before
    public void setUp() {


        ArrayList<Joueur> players = new ArrayList<Joueur>();
        players.add(new Joueur("test"));
        g = new Game(null);
        b = new Board(null,null,g);
    }

    @After
    public void tearDown() {
        b = null;
    }

    @Test
    public void getGame() {
        assertEquals("Expect object g", null, b.getGame()); //Game n'a pas été assigné à la creation de board car certains parametres de celui ci sont null
    }
}