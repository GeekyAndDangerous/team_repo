/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class PetTest {
    
    Pet p1;
    Pet p2;

    @Before
    public void setUp(){
        p1 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        p2 = new Pet(111, "Harley", Sex.MALE, true, "Barbara Herbert");
    }
    
    /**
     * Test of getPetNum method, of class Pet.
     */
    @Test
    public void testGetPetNum() {
        Pet instance = p1;
        int expected = 243;
        int actual = instance.getPetNum();
        assertEquals(expected, actual);
    }

    /**
     * Test of getPetName method, of class Pet.
     */
    @Test
    public void testGetPetName() {
        Pet instance = p1;
        String expected = "Kylie";
        String actual = instance.getPetName();
        assertEquals(expected, actual);
    }

    /**
     * Test of setPetName method, of class Pet.
     */
    @Test
    public void testSetPetName() {
        p1.setPetName("Karly");
        String expected = "Karly";
        String actual = p1.getPetName();
        assertEquals(actual, expected);
    }

    /**
     * Test of getPetSex method, of class Pet.
     */
    @Test
    public void testGetPetSex() {
        Enum expected = Sex.FEMALE;
        Enum actual = p1.getPetSex();
        assertEquals(expected, actual);
    }

    /**
     * Test of setPetSex method, of class Pet.
     */
    @Test
    public void testSetPetSex() {
        p1.setPetSex(Sex.MALE);
        Enum expected = Sex.MALE;
        Enum actual = p1.getPetSex();
        assertEquals(expected, actual);
        
    }

    /**
     * Test of getPetVaccinated method, of class Pet.
     */
    @Test
    public void testGetPetVaccinated() {
        boolean expected = true;
        boolean actual = p1.getPetVaccinated();
        assertEquals(expected, actual);
    }

    /**
     * Test of setPetVaccinated method, of class Pet.
     */
    @Test
    public void testSetPetVaccinated() {
        p1.setPetVaccinated(false);
        boolean expected = false;
        boolean actual = p1.getPetVaccinated();
        assertEquals(expected, actual);
        
    }

    /**
     * Test of compareTo method, of class Pet.
     */
    @Test
    public void testCompareTo() {
        Pet p3 = new Pet(242, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        int expected = 1;
        int actual = p1.compareTo(p3);
        assertEquals(expected,actual);
    }

    /**
     * Test of equals method, of class Pet.
     */
    @Test
    public void testEquals() {
        Pet p3 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        boolean expected = true;
        boolean actual = p1.equals(p3);
        assertEquals(expected,actual);
    }
    
    /**
     * Test of toString method, of class Pet.
     */
    
    @Test
    public void testToString() {
        String expected = "petNum=243petName=KyliepetSex=FEMALEvaccinated=truepetOwner=Jennifer Holstein";
        String actual = p1.toString().trim();
        assertEquals(expected, actual);
    }
}
