
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
public class DogTest {

    Dog d1;
    Dog d2;

    @Before
    public void setUp(){
        d1 = new Dog(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein", "Brown", "Schnauzer");
        d2 = new Dog(111, "Harley", Sex.MALE, true, "Barbara Herbert", "White", "Silky Terrier");
    }
    /**
     * Test of getDogColour method, of class Dog.
     */
    @Test
    public void testGetDogColour() {
        String expected = "Brown";
        String actual = d1.getDogColour();
        assertEquals(expected, actual);
    }

    /**
     * Test of setDogColour method, of class Dog. Valid data
     */
    @Test
    public void testSetDogColour() {
        assertTrue(d1.setDogColour("Tan"));
        String expected = "Tan";
        String actual = d1.getDogColour();
        assertEquals(expected, actual);        
    }
    
    /**
     * Test of setDogColour method, of class Dog. Empty String
     */
    @Test
    public void testSetDogColour2() {
        assertFalse(d1.setDogColour(""));
    }

    /**
     * Test of getDogBreed method, of class Dog.
     */
    @Test
    public void testGetDogBreed() {
        String expected = "Schnauzer";
        String actual = d1.getDogBreed();
        assertEquals(expected, actual);
    }

    /**
     * Test of setDogBreed method, of class Dog.
     */
    @Test
    public void testSetDogBreed() {
        assertTrue(d1.setDogBreed("Whippet"));
        String expected = "Whippet";
        String actual = d1.getDogBreed();
        assertEquals(expected, actual);
    }

    /**
     * Test of setDogBreed method, of class Dog.
     */
    @Test
    public void testSetDogBreed2() {
        assertFalse(d1.setDogBreed(""));
    }
    
    /**
     * Test of compareTo method, of class Dog.
     */
    @Test
    public void testCompareTo() {
        Dog d3 = new Dog(242, "Kylie", Sex.FEMALE, true, "Jennifer Holstein", "Brown", "Schnauzer");
        int expected = 1;
        int actual = d1.compareTo(d3);
        assertEquals(expected,actual);
    }

    /**
     * Test of equals method, of class Dog.
     */
    @Test
    public void testEquals() {
        Dog d3 = new Dog(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein", "Brown", "Schnauzer");
        boolean expected = true;
        boolean actual = d1.equals(d3);
        assertEquals(expected,actual);
    }
    
    
    /**
     * Test of toString method, of class Dog.
     */
    @Test
    public void testToString() {
        String expected = "dogNum=243dogName=KyliedogSex=FEMALEvaccinated=truedogOwner=Jennifer HolsteindogColour=BrowndogBreed=Schnauzer";
        String actual = d1.toString().trim();
        assertEquals(expected, actual);
    }
}
