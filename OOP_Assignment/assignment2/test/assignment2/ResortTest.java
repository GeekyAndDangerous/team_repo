/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 * @version 1.0 CSE2OOP Tutor: Akhtar Ali Jalbani Assignment 2
 *
 */
public class ResortTest {

    Resort r1;
    Pet p1;
    Pet p2;
    Pet p3;
    Pet p4;
    Booking b1;
    Booking b2;

    @Before
    public void setUp() {
        r1 = new Resort();
        p1 = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        p2 = new Pet(111, "Harley", Sex.MALE, true, "Barbara Herbert");
        p3 = new Pet(464, "Jimminy", Sex.MALE, false, "Hal Oberton");
        p4 = new Dog(464, "Jimminy", Sex.MALE, false, "Hal Oberton", "Brown", "Schnauzer");
        b1 = new Booking(LocalDate.of(2020, 9, 1), LocalDate.of(2020, 9, 5), 243);
        b2 = new Booking(LocalDate.of(2020, 8, 2), LocalDate.of(2020, 8, 6), 111);
    }

    /**
     * Test of getPet method, of class Resort valid data.
     */
    @Test
    public void testGetPet() {
        assertTrue(r1.addPet(p1));
        Pet expected = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        Pet actual = r1.getPet(243);
        assertEquals(expected, actual);
    }

    /**
     * Test of getPet method, of class Resort no such petNum on file.
     */
    @Test
    public void testGetPet2() {
        assertNull(r1.getPet(243));
    }

    /**
     * Test of addPet method, of class Resort, all valid data.
     */
    @Test
    public void testAddPet() {
        assertTrue(r1.addPet(p1));
        Pet expected = new Pet(243, "Kylie", Sex.FEMALE, true, "Jennifer Holstein");
        Pet actual = r1.getPet(243);
        assertEquals(expected, actual);
    }

    /**
     * Test of addPet method, of class Resort, pet already on file/petNum taken.
     */
    @Test
    public void testAddPet2() {
        assertTrue(r1.addPet(p1));
        assertFalse(r1.addPet(p1));

    }

    /**
     * Test of addPet method, of class Resort, pet not vaccinated.
     */
    @Test
    public void testAddPet3() {
        assertFalse(r1.addPet(p3));
    }

    /**
     * Test of isPet method, of class Resort valid data.
     */
    @Test
    public void testIsPet() {
        assertTrue(r1.addPet(p1));
        boolean expected = true;
        boolean actual = r1.isPet(243);
        assertEquals(expected, actual);
    }

    /**
     * Test of isPet method, of class Resort, no such pet on file.
     */
    @Test
    public void testIsPet2() {
        assertFalse(r1.isPet(666));
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
        assertTrue(r1.addBooking(b1));

    }

    /**
     * Test of addBooking method, of class Resort no such pet on file.
     */
    @Test
    public void testAddBooking2() {
        assertFalse(r1.addBooking(b1));
    }

    /**
     * Test of addBooking method, of class Resort date overlap; start date
     * inside existing booking.
     */
    @Test
    public void testAddBooking3() {
        r1.addPet(p1);
        assertTrue(r1.addBooking(b1));

       assertFalse(r1.addBooking(new Booking(LocalDate.of(2020, 9, 2), LocalDate.of(2020, 9, 7), 243)));

    }

    /**
     * Test of addBooking method, of class Resort date overlap; end date inside
     * existing booking.
     */
    @Test
    public void testAddBooking4() {
        r1.addPet(p1);
        assertTrue(r1.addBooking(b1));

        assertFalse(r1.addBooking(new Booking(LocalDate.of(2020, 8, 28), LocalDate.of(2020, 9, 3), 243)));
    }

    /**
     * Test of addBooking method, of class Resort date overlap; both dates
     * inside existing booking.
     */
    @Test
    public void testAddBooking5() {
        r1.addPet(p1);
        assertTrue(r1.addBooking(b1));

       assertFalse(r1.addBooking(new Booking(LocalDate.of(2020, 9, 2), LocalDate.of(2020, 9, 4), 243)));
    }

    /**
     * Test of addBooking method, of class Resort date overlap; start date
     * before and end date after existing booking.
     */
    @Test
    public void testAddBooking6() {
        r1.addPet(p1);
        assertTrue(r1.addBooking(b1));

        assertFalse(r1.addBooking(new Booking(LocalDate.of(2020, 8, 30), LocalDate.of(2020, 9, 10), 243)));
    }

    /**
     * Test of getBookings method, of class Resort.
     */
    @Test
    public void testGetBookings_0args() {
        Booking[] bookingsArray = new Booking[2];
        bookingsArray[0] = new Booking(LocalDate.of(2020, 8, 2), LocalDate.of(2020, 8, 6), 111);
        bookingsArray[1] = new Booking(LocalDate.of(2020, 9, 1), LocalDate.of(2020, 9, 5), 243);

        assertTrue(r1.addPet(p1));
        assertTrue(r1.addPet(p2));
        assertTrue(r1.addBooking(b1));
        assertTrue(r1.addBooking(b2));

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
        bookingsArray[0] = new Booking(LocalDate.of(2020, 9, 1), LocalDate.of(2020, 9, 5), 243);

        assertTrue(r1.addPet(p1));
        assertTrue(r1.addPet(p2));
        assertTrue(r1.addBooking(b1));
        assertTrue(r1.addBooking(b2));

        Booking[] expected = bookingsArray;
        Booking[] actual = r1.getBookings(LocalDate.of(2020, 9, 1));

        assertArrayEquals(expected, actual);
    }

    /**
     * Test of getBookings method, of class Resort, no Bookings found for date.
     */
    @Test
    public void testGetBookings_LocalDate2() {
        Booking[] bookingsArray = new Booking[0];

        assertTrue(r1.addPet(p1));
        assertTrue(r1.addPet(p2));
        assertTrue(r1.addBooking(b1));
        assertTrue(r1.addBooking(b2));

        Booking[] expected = bookingsArray;
        Booking[] actual = r1.getBookings(LocalDate.of(2020, 10, 1));

        assertArrayEquals(expected, actual);
    }

    /**
     * Test of toString method, of class Resort.
     */
    @Test
    public void testToString() {

        assertTrue(r1.addPet(p1));
        assertTrue(r1.addPet(p2));
        assertTrue(r1.addBooking(b1));
        assertTrue(r1.addBooking(b2));

        String expected = "Pets array: [\n"
                + "petNum=243petName=KyliepetSex=FEMALEvaccinated=true"
                + "petOwner=Jennifer Holstein\n"
                + "petNum=111petName=HarleypetSex=MALEvaccinated=true"
                + "petOwner=Barbara Herbert]\n"
                + "Bookings: [\n"
                + "dateIn = 01-Sep-2020, dateOut = 05-Sep-2020, "
                + "petNum = 243\n"
                + "dateIn = 02-Aug-2020, dateOut = 06-Aug-2020, "
                + "petNum = 111]";
        String actual = r1.toString();

        assertEquals(expected, actual);
    }

}
