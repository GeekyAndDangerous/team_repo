/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gazby
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
     * Test of setDogColour method, of class Dog.
     */
    @Test
    public void testSetDogColour() {
        d1.setDogColour("Tan");
        String expected = "Tan";
        String actual = d1.getDogColour();
        assertEquals(expected, actual);        
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
        d1.setDogBreed("Whippet");
        String expected = "Whippet";
        String actual = d1.getDogBreed();
        assertEquals(expected, actual);
    }

    /**
     * Test of compareTo method, of class Dog.
     */
    @Test
    public void testCompareTo() {
    }

    /**
     * Test of equals method, of class Dog.
     */
    @Test
    public void testEquals() {
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
