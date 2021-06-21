package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BatimentTest {

    @Test
    public void getPointVictoire() {
        Batiment tester = new Batiment("test",5,2,1,0,9,100);

        assertEquals("Expect 9",9,tester.getPointVictoire());
    }

    @Test
    public void getEcus() {
        Batiment tester = new Batiment("test",5,2,1,0,9,100);
        assertEquals("Expect 100",100,tester.getEcus());

    }
}