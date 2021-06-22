package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteTest {

    Carte carte1;

    @Before
    public void setUp(){
        carte1 = new Carte("c1",2,3,4,1);
    }

    @After
    public void tearDown() {
        carte1 = null;
    }

    @Test
    public void getNom() {
        assertEquals("Expect c1","c1",carte1.getNom());
    }

    @Test
    public void getPierre() {
        assertEquals("Expect 3",3,carte1.getPierre());
        carte1.setPierre(0);
        assertEquals("Expect 0",0,carte1.getPierre());
    }

    @Test
    public void getBois() {
        assertEquals("Expect 2",2,carte1.getBois());
        carte1.setBois(0);
        assertEquals("Expect 0",0,carte1.getBois());
    }

    @Test
    public void getSavoir() {
        assertEquals("Expect 1",1,carte1.getSavoir());
        carte1.setSavoir(0);
        assertEquals("Expect 0",0,carte1.getSavoir());
    }

    @Test
    public void getTuile() {
        assertEquals("Expect 4",4,carte1.getTuile());
        carte1.setTuile(0);
        assertEquals("Expect 0",0,carte1.getTuile());
    }

    @Test
    public void setBois() {
        carte1.setBois(5);

        assertEquals("Expect 5",5,carte1.getBois());
        carte1.setBois(0);
        assertEquals("Expect 0",0,carte1.getBois());
    }

    @Test
    public void setPierre() {
        carte1.setPierre(4);

        assertEquals("Expect 4",4,carte1.getPierre());
        carte1.setPierre(0);
        assertEquals("Expect 0",0,carte1.getPierre());
    }

    @Test
    public void setSavoir() {
        carte1.setSavoir(2);
        assertEquals("Expect 2",2,carte1.getSavoir());
        carte1.setSavoir(0);
        assertEquals("Expect 0",0,carte1.getSavoir());
    }

    @Test
    public void setTuile() {
        carte1.setTuile(11);

        assertEquals("Expect 11",11,carte1.getTuile());
        carte1.setTuile(0);
        assertEquals("Expect 0",0,carte1.getTuile());
    }
}