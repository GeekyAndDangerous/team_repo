
package assignment2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 * @version 1.0
 * CSE2OOP
 * Tutor: Akhtar Ali Jalbani
 * Assignment 2
 * 
 */
public class PetTest {

    Pet p1;
    Pet p2;
    Pet constructorPet;

    @Before
    public void setUp() {
        p1 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        p2 = new Pet(111, "Harley", Sex.MALE, true, "Barbara Herbert");
    }

    
    /**
     * Test of Pet constructor
     */
    @Test
    public void testPetConstructor() {
        constructorPet = new Pet(989, "Spot", Sex.MALE, true, "Graeme Blatt");
        Pet expected = new Pet(989, "Spot", Sex.MALE, true, "Graeme Blatt");
        Pet actual = constructorPet;
        assertEquals(expected, actual);
    }
    
    /**
     * Test of pet constructor exception: petNum <0
     */
    @Test(expected = PetResortException.class)
    public void testPetConstructor2() {
        constructorPet = new Pet(-1, "Spot", Sex.MALE, true, "Graeme Blatt");
    }
    
    /**
     * Test of pet constructor exception: Blank pet name
     */
    @Test(expected = PetResortException.class)
    public void testPetConstructor3() {
        constructorPet = new Pet(989, "", Sex.MALE, true, "Graeme Blatt");
    }
    
    /**
     * Test of pet constructor exception: Blank owner name
     */
    @Test(expected = PetResortException.class)
    public void testPetConstructor4() {
        constructorPet = new Pet(989, "Spot", Sex.MALE, true, "");
    }
    
    /**
     * Test of getPetNum method, of class Pet. Valid data
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
     * Test of setPetName method, of class Pet. Valid Data
     */
    @Test
    public void testSetPetName() {
        assertTrue(p1.setPetName("Karly"));
        String expected = "Karly";
        String actual = p1.getPetName();
        assertEquals(actual, expected);
    }
    
    /**
     * Test of setPetName method, of class Pet: Pet name left blank
     */
    @Test
    public void testSetPetName2() {
        assertFalse(p1.setPetName(""));
        String expected = "Kylie";
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
        assertTrue(p1.setPetSex(Sex.MALE));
        Enum expected = Sex.MALE;
        Enum actual = p1.getPetSex();
        assertEquals(expected, actual);

    }

    /**
     * Test of getPetVaccinated method, of class Pet.
     */
    @Test
    public void testGetPetVaccinated() {
        assertTrue(p1.getPetVaccinated());
    }

    /**
     * Test of setPetVaccinated method, of class Pet.
     */
    @Test
    public void testSetPetVaccinated() {
        assertTrue(p1.setPetVaccinated(false));
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
        assertEquals(expected, actual);
    }

    /**
     * Test of equals method, of class Pet.
     */
    @Test
    public void testEquals() {
        Pet p3 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        boolean expected = true;
        boolean actual = p1.equals(p3);
        assertEquals(expected, actual);
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
