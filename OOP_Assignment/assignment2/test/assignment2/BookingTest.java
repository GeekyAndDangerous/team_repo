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
    Booking constructorBooking;
    
    @Before
    public void setUp(){
        b1 = new Booking(LocalDate.of(2021, 7, 12), LocalDate.of(2021, 7, 15), 542);
    }

    /**
     * Test of booking constructor
     */
    @Test
    public void testBookingConstructor() {
        constructorBooking = new Booking(LocalDate.of(2021, 10, 16), LocalDate.of(2021, 10, 20), 691);
        Booking expected = new Booking(LocalDate.of(2021, 10, 16), LocalDate.of(2021, 10, 20), 691);
        Booking actual = constructorBooking;
        assertEquals(expected, actual);
    }
    
    /**
     * Test of booking constructor exception: petNum <0
     */
    @Test(expected = PetResortException.class)
    public void testBookingConstructor2() {
        constructorBooking = new Booking(LocalDate.of(2021, 10, 16), LocalDate.of(2021, 10, 20), -1);;
    }
    
    /**
     * Test of booking constructor exception: Date in in the past
     */
    @Test(expected = PetResortException.class)
    public void testBookingConstructor3() {
        constructorBooking = new Booking(LocalDate.of(2019, 10, 16), LocalDate.of(2021, 10, 20), 691);;
    }
    
    /**
     * Test of booking constructor exception: Date out before date in
     */
    @Test(expected = PetResortException.class)
    public void testBookingConstructor4() {
        constructorBooking = new Booking(LocalDate.of(2021, 10, 16), LocalDate.of(2021, 5, 20), 691);;
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
        String expected = "dateIn = 12-Jul-2021, dateOut = 15-Jul-2021, petNum = 542";
        String actual = b1.toString().trim();
        assertEquals(expected, actual);
    }
}
