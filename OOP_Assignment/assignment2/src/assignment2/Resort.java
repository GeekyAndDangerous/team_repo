/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Gazby
 */
public class Resort {
    private ArrayList <Booking> mBookings;
    private ArrayList <Pet> mPets;
    
    public boolean addBooking(LocalDate dateIn, LocalDate dateOut, int petNum){
        boolean bookingAdded = false;
        for (Pet p : mPets){
            if (p.getPetNum == petNum){
                    for (Booking b : mBookings){
                        if (b.getPetNum == petNum){
                            if (dateIn.compareTo(b.getDateIn()) >= 0 && dateOut.compareTo(b.getDateOut()) )
                        }
                    Booking booking = new Booking(dateIn, dateOut, petNum);
                    mBookings.add(booking);
                    }
            }
        }
        return bookingAdded;
    }
}