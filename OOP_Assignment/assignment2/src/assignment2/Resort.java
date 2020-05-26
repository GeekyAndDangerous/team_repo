/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gazby
 */
public class Resort {

    public ArrayList<Booking> mBookings;
    private ArrayList<Pet> mPets;
    DateTimeFormatter dateTimeFormatter;
//    private String mResortName;

    public Resort() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
        mBookings = new ArrayList<>();
        mPets = new ArrayList<>();
    }
    
    public boolean addBooking(Booking newBooking) {
        boolean bookingAdded = false;
        boolean petExists = false;
        ArrayList<Booking> petBookings = new ArrayList<>();
        int petBookingsTotal = 0;

        if (isPet(newBooking.getPetNum())) {
            //System.out.println("is pet");
            if (mBookings.isEmpty()) {
                this.mBookings.add(newBooking);
                bookingAdded = true;
            }
            //Go through the array
            for (Booking b : mBookings) {
                //System.out.println("petNum" + b.getPetNum());
                if (newBooking.getPetNum() == b.getPetNum()) {
                    //System.out.println("same pet");
                    petExists = true;
                    petBookings.add(b);
                } else {
                    //System.out.println("not same pet");
                    petExists = false;
                }
            }
            //Where the actual modification happens.
            if (petExists) {
                //Do some validation
                for (Booking pb : petBookings) {
                    if (newBooking.getStartDate().isAfter(pb.getEndDate()) || newBooking.getEndDate().isBefore(pb.getStartDate())) {
                        petBookingsTotal++;
                    }
                }
                if (petBookingsTotal == petBookings.size()) {
                    this.mBookings.add(newBooking);
                    bookingAdded = true;
                }
            } else {
                this.mBookings.add(newBooking);
                bookingAdded = true;
            }
        }

        return bookingAdded;
    }
    

    public boolean isPet(int petNum) {
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

        if (!isPet(newPet.getPetNum())) {
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

    public Pet[] getPets() {
        Pet[] petArray = mPets.toArray(new Pet[mPets.size()]);
        Arrays.sort(petArray);
        return petArray;
    }

    public Pet[] getPets(String name) {
        ArrayList<Pet> petsByName;
        petsByName = new ArrayList<>();

        for (Pet p : mPets) {
            if (p.getPetName().equals(name)) {
                petsByName.add(p);
            }
        }
        Pet[] petArray;
        petArray = petsByName.toArray(new Pet[petsByName.size()]);
        return petArray;
    }

    public Booking[] getBookings() {
        Booking[] bookingsArray = mBookings.toArray(new Booking[mBookings.size()]);
        Arrays.sort(bookingsArray);
        return bookingsArray;
    }

    public Booking[] getBookings(LocalDate dateIn) {
        ArrayList<Booking> bookingsByDateIn;
        bookingsByDateIn = new ArrayList<>();

        for (Booking b : mBookings) {
            if (b.getStartDate() == dateIn) {
                bookingsByDateIn.add(b);
            }
        }

        Booking[] bookingsArray = bookingsByDateIn.toArray(new Booking[bookingsByDateIn.size()]);
        Arrays.sort(bookingsArray);
        return bookingsArray;
    }

    @Override
    public String toString() {
        String result;

        result = "Pets array: [";
        for (Pet p : this.mPets) {
            result += "\n" + p.toString();
        }
        result += "]";
        result += "\nBookings: [";
        for (Booking b : this.mBookings) {
            result += "\n" + b.toString();
        }
        result += "]";

        return result;
    }

}
