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
        b = new Board(players,new Joueur("test"),g);
    }

    @After
    public void tearDown() {
        b = null;
    }

   // @Test
    //public void getGame() {                                             //test impossible car il ne trouve pas les fichier de configuration
      //  assertEquals("Expect object g", g, b.getGame());
    //}
}