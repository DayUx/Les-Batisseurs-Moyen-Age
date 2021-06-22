package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoueurTest {



    Joueur j;
    Board b;



    @Before
    public void setUp(){
        j = new Joueur("Timothey");
        b = new Board(null,null,null);
    }

    @After
    public void tearDown() {
        j = null;
    }

    @Test
    public void getBoard() {
        j.setBoard(b);
        assertEquals("Expect object b",b,j.getBoard());
    }

    @Test
    public void setBoard() {
        j.setBoard(b);
        assertEquals("Expect object b",b,j.getBoard());
    }

    @Test
    public void getEcus() {
        j.setEcus(5);
        assertEquals("Expect 5",5,j.getEcus());
    }

    @Test
    public void setEcus() {
        j.setEcus(1);
        assertEquals("Expect 1",1,j.getEcus());
    }

    @Test
    public void setPointsV() {
        j.setPointsV(1);
        assertEquals("Expect 1",1,j.getPointsV());
    }

    @Test
    public void getPointsV() {
        j.setPointsV(4);
        assertEquals("Expect 4",4,j.getPointsV());
    }
}