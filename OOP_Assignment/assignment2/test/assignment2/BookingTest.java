/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class BookingTest {
    
    Booking b1;
    
    @Before
    public void setUp(){
        b1 = new Booking(LocalDate.of(2021, 7, 12), LocalDate.of(2021, 7, 15), 542);
    }

    /**
     * Test of getStartDate method, of class Booking.
     */
    @Test
    public void testGetStartDate() {
        LocalDate expected = LocalDate.of(2021, 7, 12);
        LocalDate actual = b1.getStartDate();
        assertEquals(expected, actual);
    }

    /**
     * Test of getEndDate method, of class Booking.
     */
    @Test
    public void testGetEndDate() {
        LocalDate expected = LocalDate.of(2021, 7, 15);
        LocalDate actual = b1.getEndDate();
        assertEquals(expected, actual);
    }

    /**
     * Test of getPetNum method, of class Booking.
     */
    @Test
    public void testGetPetNum() {
        int expected = 542;
        int actual = b1.getPetNum();
        assertEquals(expected, actual);
    }

    /**
     * Test of compareTo method, of class Booking.
     */
    @Test
    public void testCompareTo() {
        Booking b2 = new Booking(LocalDate.of(2021, 7, 12), LocalDate.of(2021, 7, 15), 543);
        int expected = -1;
        int actual = b1.compareTo(b2);
        assertEquals(expected, actual);
    }

    /**
     * Test of equals method, of class Booking.
     */
    @Test
    public void testEquals() {
        Booking b2 = new Booking(LocalDate.of(2021, 7, 12), LocalDate.of(2021, 7, 15), 542);
        boolean expected = true;
        boolean actual = b1.equals(b2);
        assertEquals(expected, actual);
    }
    
    /**
     * Test of equals method, of class Booking.
     */
    @Test
    public void testToString() {
        String expected = "dateIn = 2021-07-12, dateOut = 2021-07-15, petNum = 542";
        String actual = b1.toString().trim();
        assertEquals(expected, actual);
    }
}
