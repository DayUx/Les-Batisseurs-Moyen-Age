package model;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class CarteTest {

    @Test
    public void getNom() {
        Batiment tester = new Batiment("test",5,2,1,0,0,0);
        assertEquals("Expect 9",9,tester.getPointVictoire());

    }

    @Test
    public void getPierre() {
        Batiment tester = new Batiment("test",5,2,1,0,0,0);
        assertEquals("Expect 2",2,tester.getPierre());

    }

    @Test
    public void getBois() {
        Batiment tester = new Batiment("test",5,2,1,0,0,0);
        assertEquals("Expect 5",5,tester.getBois());

    }

    @Test
    public void getSavoir() {
        Batiment tester = new Batiment("test",5,2,1,0,0,0);
        assertEquals("Expect 0",0,tester.getSavoir());

    }

    @Test
    public void getTuile() {
        Batiment tester = new Batiment("test",5,2,1,0,0,0);
        assertEquals("Expect 1",1,tester.getTuile());

    }


}

