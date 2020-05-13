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
public class Resort{
    private ArrayList<Booking> mBookings;
    public ArrayList<Pet> mPets;
//    private String mResortName;
    
    public Resort(){
//        mResortName = resortName;
        mBookings = new ArrayList<Booking>(1);
        mPets = new ArrayList<Pet>(1);
    }

    public boolean addBooking(Booking newBooking){
        boolean bookingAdded = false;
//        for (Pet p : mPets){
//            if (p.getPetNum() == newBooking.getPetNum()){
                    for (Booking b : mBookings){
                        if (b.getPetNum() == newBooking.getPetNum()){
                            if (newBooking.getStartDate().isAfter(b.getEndDate()) || newBooking.getEndDate().isBefore(b.getStartDate())){
                            mBookings.add(newBooking);
                            bookingAdded = true;
                        }
                    }
            }
//        }
        return bookingAdded;
    }
    
    
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
            this.mPets.add(newPet);
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
        Pet[] petArray = mPets.toArray(new Pet[mPets.size()]);
        Arrays.sort(petArray);
        return petArray;
    }
    
    public Pet[] getPets(String name){
        ArrayList <Pet> petsByName;
        petsByName = new ArrayList <Pet>();
        
        for (Pet p: mPets){
            if (p.getPetName().equals(name)){
                petsByName.add(p);
            }
        }
        Pet[] petArray;
        petArray = petsByName.toArray(new Pet[petsByName.size()]);
        return petArray;
    }
    
    public Booking[] getBookings(){
        Booking[] bookings = this.mBookings.toArray(new Booking[mBookings.size()]);
        Arrays.sort(bookings);
        return bookings;
    }
    
    public Booking[] getBookings(LocalDate dateIn){
        ArrayList <Booking> bookingsByDateIn;
        bookingsByDateIn = new ArrayList <Booking>();
        
        for (Booking b: mBookings){
            if (b.getStartDate() == dateIn){
                bookingsByDateIn.add(b);
            }
        }
        
        Booking[] bookingsArray = bookingsByDateIn.toArray(new Booking[bookingsByDateIn.size()]);
        Arrays.sort(bookingsArray);
        return bookingsArray;
    }
    

}