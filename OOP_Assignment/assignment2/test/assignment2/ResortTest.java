/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class ResortTest {
    
    Resort r1;
    Pet p1;
    Pet p2;
    Booking b1;
    Booking b2;

    @Before
    public void setUp(){
        r1 = new Resort();
        p1 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        p2 = new Pet(111, "Harley", Sex.MALE, true, "Barbara Herbert");
        b1 = new Booking(LocalDate.of(2020,9,1), LocalDate.of(2020,9,5), 243);
        b2 = new Booking(LocalDate.of(2020,8,2), LocalDate.of(2020,8,6), 111);
    }
    

    /**
     * Test of addPet method, of class Resort.
     */
    @Test
    public void testAddPet() {
        boolean expected = true;
        boolean actual = r1.addPet(p1);
        assertEquals(expected, actual);
    }
    
    /**
     * Test of addPet method, of class Resort.
     */
    @Test
    public void testAddPet2() {
        boolean expected = false;
        r1.addPet(p1);
        boolean actual = r1.addPet(p1);
        assertEquals(expected, actual);
    }
    
    /**
     * Test of isPet method, of class Resort.
     */
    @Test
    public void testIsPet() {
        r1.addPet(p1);
        boolean expected = true;
        boolean actual = r1.isPet(243);
        assertEquals(expected, actual);
    }


    /**
     * Test of getPet method, of class Resort.
     */
    @Test
    public void testGetPet() {
        Pet expected = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        Pet actual = p1;
        assertEquals(expected, actual);
    }

    /**
     * Test of getPets method, of class Resort.
     */
    @Test
    public void testGetPets_0args() {
        Pet[] petArray = new Pet[2];
        petArray[0] = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        petArray[1] = new Pet(111, "Harley", Sex.MALE, true, "Barbara Herbert");
        Arrays.sort(petArray);
        
        r1.addPet(p1);
        r1.addPet(p2);
        
        Pet[] expected = petArray;
        Pet[] actual = r1.getPets();
        
        assertArrayEquals(expected, actual);
    }

    /**
     * Test of getPets method, of class Resort.
     */
    @Test
    public void testGetPets_String() {
        Pet[] petArray = new Pet[1];
        petArray[0] = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        
        r1.addPet(p1);
        r1.addPet(p2);
        
        Pet[] expected = petArray;
        Pet[] actual = r1.getPets("Kylie");
        
        assertArrayEquals(expected, actual);
    }
    
     /**
     * Test of addBooking method, of class Resort.
     */
    @Test
    public void testAddBooking() {
        r1.addPet(p1);
        
        boolean expected = true;
        boolean actual = r1.addBooking(b1);
        assertEquals(expected, actual);
        
    }

    /**
     * Test of getBookings method, of class Resort.
     */
    @Test
    public void testGetBookings_0args() {
        Booking[] bookingsArray = new Booking[2];
        bookingsArray[0] = new Booking(LocalDate.of(2020,9,1), LocalDate.of(2020,9,5), 243);
        bookingsArray[1] = new Booking(LocalDate.of(2020,8,2), LocalDate.of(2020,8,6), 111);
        
        r1.addPet(p1);
        r1.addPet(p2);
        r1.addBooking(b1);
        r1.addBooking(b2);

        
        Booking[] expected = bookingsArray;
        Booking[] actual = r1.getBookings();
        
        assertArrayEquals(expected, actual);
        
    }

    /**
     * Test of getBookings method, of class Resort.
     */
    @Test
    public void testGetBookings_LocalDate() {
        Booking[] bookingsArray = new Booking[1];
        bookingsArray[0] = new Booking(LocalDate.of(2020,9,1), LocalDate.of(2020,9,5), 243);
        
        r1.addPet(p1);
        r1.addPet(p2);
        r1.addBooking(b1);
        r1.addBooking(b2);

        
        Booking[] expected = bookingsArray;
        Booking[] actual = r1.getBookings(LocalDate.of(2020,9,1));
        
        assertArrayEquals(expected, actual);
    }

    /**
     * Test of toString method, of class Resort.
     */
    @Test
    public void testToString() {
    }
    
}
