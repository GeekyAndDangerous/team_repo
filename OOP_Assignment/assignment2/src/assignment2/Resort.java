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
import java.util.Comparator;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class Resort {

    private final ArrayList<Booking> mBookings;
    private final ArrayList<Pet> mPets;
    DateTimeFormatter dateTimeFormatter;
    
    static Comparator<Booking> mBookingSort;
    static {
        mBookingSort = (Booking b1, Booking b2) -> Integer.compare(b1.getPetNum(), (b2.getPetNum()));
    }
 
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
            if (mBookings.isEmpty()) {
                this.mBookings.add(newBooking);
                bookingAdded = true;
            }
            for (Booking b : mBookings) {
                if (newBooking.getPetNum() == b.getPetNum()) {
                    petExists = true;
                    petBookings.add(b);
                } else {
                    petExists = false;
                }
            }
            if (petExists) {
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

        if (!isPet(newPet.getPetNum()) && newPet.getPetVaccinated()) {
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
        Arrays.sort(bookingsArray, mBookingSort);
        return bookingsArray;
    }

    public Booking[] getBookings(LocalDate dateIn) {
        ArrayList<Booking> bookingsByDateIn;
        bookingsByDateIn = new ArrayList<>();

        for (Booking b : mBookings) {
            if (b.getStartDate().compareTo(dateIn) == 0) {
                bookingsByDateIn.add(b);
            }
        }

        Booking[] bookingsArray = bookingsByDateIn.toArray(new Booking[bookingsByDateIn.size()]);
        Arrays.sort(bookingsArray, mBookingSort);
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
