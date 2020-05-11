/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gazby
 */
public class Resort {
    private ArrayList <Booking> mBookings;
    private ArrayList <Pet> mPets;
    
//    public boolean addBooking(LocalDate dateIn, LocalDate dateOut, int petNum){
//        boolean bookingAdded = false;
//        for (Pet p : mPets){
//            if (p.getPetNum() == petNum){
//                    for (Booking b : mBookings){
//                        if (b.getPetNum() == petNum){
//                            if (dateIn.compareTo(b.getStartDate()) >= 0 && dateOut.compareTo(b.getEndDate()) )
//                        }
//                    Booking booking = new Booking(dateIn, dateOut, petNum);
//                    mBookings.add(booking);
//                    }
//            }
//        }
//        return bookingAdded;
//    }
    public boolean isPet(int petNum){
        boolean isPet = false;
        for (Pet p : this.mPets) {
            if (p.getPetNum() == petNum) {
                isPet = true;
            }
        }
        return isPet;
    }
    
    public boolean addPet(Pet newPet) {
        boolean petAdded = false;
        
        if (! isPet(newPet.getPetNum())) {
            mPets.add(newPet);
            petAdded = true;
        }
        return petAdded;
    }
    
    public Pet getPet(int petNum) {
        Pet pet = null;

        for (Pet p : this.mPets) {
            if (p.getPetNum() == petNum) {
                pet = p;
            }
        }
        return pet;
    }
    
    
    public Pet[] getPets(){        
        Pet[] petArray = this.mPets.toArray(new Pet[mPets.size()]);
        Arrays.sort(petArray);
        return petArray;
    }
//    
//    public Pet[] getPets(String name){
//        ArrayList <Pet> petsByName;
//        
//        for (Pet p: mPets){
//            if (p.getPetName().equals(name)){
//                petsByName.add(p);
//            }
//        }
////        Pet[] petArray;
////        petArray = 
//        return petsByName.getPets();
//    }
    
    public Booking[] getBookings(){
        Booking[] bookings = this.mBookings.toArray(new Booking[mBookings.size()]);
        Arrays.sort(bookings);
        return bookings;
    }
    
    public Booking[] getBookings(String name){
        Booking[] bookings;
        bookings = new Booking[1];
        return bookings;
    }
}