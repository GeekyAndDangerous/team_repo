
package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 * @version 1.0
 * CSE2OOP
 * Tutor: Akhtar Ali Jalbani
 * Assignment 2
 * 
 */
public class Resort {

    private final ArrayList<Booking> mBookings;//ArrayList to hold all Bookings
    private final ArrayList<Pet> mPets;//ArrayList to hold all Pets

    /**
    * 
    * Comparator setup for sorting bookings by petNum
    * 
    */
    static Comparator<Booking> mBookingSort;

    static {
        mBookingSort = (Booking b1, Booking b2) -> 
        Integer.compare(b1.getPetNum(), (b2.getPetNum()));
    }

    /**
    * Constructor for the Resort class. 
    *
    * This initializes all data members and allows appropriate data members 
    * to be set. When resort is set up, it creates a collection for Pet objects
    * and a collection for Booking objects. 
    *                               
    */
    public Resort() {
        mBookings = new ArrayList<>();
        mPets = new ArrayList<>();
    }

    /**
    * Method for adding a booking to the arrayList of bookings held by a resort
    * object
    *  
    * @param newBooking a Booking object to be added to the arraylist
    * @return boolean   if the booking is successfully added to the arraylist,
    *                   return 'true'
    */
    public boolean addBooking(Booking newBooking) {
        boolean bookingAdded = false;
        boolean petExists = false;
        ArrayList<Booking> petBookings = new ArrayList<>();
        int petBookingsTotal = 0;
        
        //Firstly, the method checks if the pet number in the new booking is the
        //same as any pet numbers in the pets array.
        if (isPet(newBooking.getPetNum())) {
            //If there are no bookings in the bookings array, the booking is added
            if (mBookings.isEmpty()) {
                this.mBookings.add(newBooking);
                bookingAdded = true;
            }
            /**Method iterates through all current bookings in arraylist. For each
            *booking that exists for a pet with the same number as that on the
            *new booking, the method adds that pet to a new arraylist and sets a
            * boolean value to 'true' (the pet was found in the bookings.)            * 
            */
            for (Booking b : mBookings) {
                if (newBooking.getPetNum() == b.getPetNum()) {
                    petExists = true;
                    petBookings.add(b);
                } else {
                    petExists = false;
                }
            }
            /**
             * The local arraylist now holds all bookings with the same pet number
             * as that of the new booking. The method iterates through all of
             * these and checks to make sure that there is no overlap in dates.
             * For each instance where there is no overlap, the method adds 1
             * to a count.
             */
            if (petExists) {
                for (Booking pb : petBookings) {
                    if (newBooking.getStartDate().isAfter(pb.getEndDate()) || newBooking.getEndDate().isBefore(pb.getStartDate())) {
                        petBookingsTotal++;
                    }
                }
                /**
                 * If the total of the count is equal to the total number of
                 * bookings in the internal arraylist, it means that there was no
                 * overlap of any dates. As such, the new booking can be safely 
                 * added
                 */
                if (petBookingsTotal == petBookings.size()) {
                    this.mBookings.add(newBooking);
                    bookingAdded = true;
                }
                /**
                 * If the pet was not found in any bookings, (but as determined
                 * above, it does exist in the pet ArrayList), the booking
                 * can be safely added.
                 */
            } else {
                this.mBookings.add(newBooking);
                bookingAdded = true;
            }
        }
        return bookingAdded;
    }

    /**
    * Method for checking if a pet is already in the pet arraylist
    *  
    * @param petNum     an int. Unique identifier for a pet object
    * @return boolean   if the pet number is already in the pet arraylist, the
    *                   method returns 'true'
    */
    public boolean isPet(int petNum) {
        boolean isPet = false;
        for (Pet p : this.mPets) {
            if (p.getPetNum() == petNum) {
                isPet = true;
            }
        }
        return isPet;
    }

    /**
    * Method for adding a pet to the arrayList of pets held by a resort
    * object
    *  
    * @param newPet a Pet object to be added to the arraylist
    * @return boolean   if the Pet is successfully added to the arraylist,
    *                   return 'true'
    */
    public boolean addPet(Pet newPet) {
        boolean petAdded = false;

//        if (newPet instanceof Dog) {
//            Dog newDog = (Dog) newPet;
//            if (!isPet(newDog.getPetNum()) && newDog.getPetVaccinated()) {
//                this.mPets.add(newPet);
//                petAdded = true;
//            }
//        }

         if (!isPet(newPet.getPetNum()) && newPet.getPetVaccinated()) {
            this.mPets.add(newPet);
            petAdded = true;
        }

        return petAdded;
    }
    
//    public boolean addPet(Dog newDog) {
//        boolean petAdded = false;
//
//        if (!isPet(newDog.getPetNum()) && newDog.getPetVaccinated()) {
//            this.mPets.add(newDog);
//            petAdded = true;
//        }
//        return petAdded;
//    }
    
    /**
    * Method for retrieving a pet object's information from the Pet arraylist
    *  
    * @param petNum an int. Identifier for the pet object being searched for
    * @return Pet   If a pet object exists in the pet arraylist with the same 
    *               petnumber as entered as a parameter, the Pet object is
    *               returned
    */
    public Pet getPet(int petNum) {
        Pet pet = null;

        for (Pet p : this.mPets) {
            if (p.getPetNum() == petNum) {
                pet = p;
            }
        }
        return pet;
    }

    /**
    * Method for retrieving an array of Pet objects as a copy of the pet
    * arraylist
    *  
    * @return Pet[]   an array of pet objects is created, sorted and returned
    */
    public Pet[] getPets() {
        Pet[] petArray = mPets.toArray(new Pet[mPets.size()]);
        Arrays.sort(petArray);
        return petArray;
    }
    
    /**
    * Method for retrieving an array of Pet objects with a String parameter
    * indicating name of pet.
    *  
    * @param name     a String. Name of pet to search for in pet arraylist
    * @return Pet[]   an array of pet objects is created, each pet object in 
    *                 the pet arraylist held by the resort with the same name as
    *                 the String name parameter is added to the new array and 
    *                 then the array is returned.
    */
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
    
    /**
    * Method for retrieving an array of Booking objects as a copy of the Booking
    * arraylist
    *  
    * @return Booking[]   an array of Booking objects is created, sorted and returned
    */
    public Booking[] getBookings() {
        Booking[] bookingsArray = mBookings.toArray(new Booking[mBookings.size()]);
        Arrays.sort(bookingsArray, mBookingSort);
        return bookingsArray;
    }

    /**
    * Method for retrieving an array of Booking objects as a copy of the Booking
    * arraylist, using date in as a search
    * 
    * @param dateIn       LocalDate the date that any given booking starts
    *  
    * @return Booking[]   an array of Booking objects is created. Any booking in
    *                     the booking arraylist held by the resort object that 
    *                     has the same date in as entered as parameter is added
    *                     to the booking array and returned as an array.
    */
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

    /**
     * toString method. 
     *
    
     * @return String each arraylist is iterated through and is converted to a
     *                string before being concatenated as part of a whole string
     */
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
