package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BatimentTest {

    private Batiment bat;
    private Batiment bat2;

    @Before
    public void setUp() {
        bat = new Batiment("maison",5,6,2,1,7,8);
        bat2 = new Batiment("maison",0,0,0,0,0,0);

    }

    @After
    public void tearDown() {
        bat =null;
        bat2 = null;
    }

    @Test
    public void getPointVictoire() {
        assertEquals("Expect 7",7,bat.getPointVictoire());
        assertEquals("Expect 0",0,bat2.getPointVictoire());
    }

    @Test
    public void getEcus() {
        assertEquals("Expect 7",8,bat.getEcus());
        assertEquals("Expect 0",0,bat2.getEcus());
    }
}