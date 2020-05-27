/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0 
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class Booking implements Comparable{
    
    //Data Members
    LocalDate mDateIn;
    LocalDate mDateOut;
    int mPetNum;
    DateTimeFormatter dateTimeFormatter1;

    /**
     * Constructor for the Booking class.
     * @param dateIn The start date of the booking In LocalDate Format
     * @param dateOut The end date of the booking in LocalDate Format
     * @param petNum The pet number of the pet.
     */
    public Booking(LocalDate dateIn,LocalDate dateOut,int petNum) {
        if (dateIn.isAfter(LocalDate.now()) 
                && dateOut.isAfter(dateIn)
                && petNum > 0) {
            mPetNum = petNum;
            mDateIn = dateIn;
            mDateOut = dateOut;
            dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd-MMM-uuuu");

        }
        else {
            throw new PetResortException("Date must be in the future. Date out must be after date in. Petnum must be more than 0");
        }
    }
    
    /**
     * Method returns the start date of the booking.
     * @return LocalDate object containing the start date of the booking.
     */
    public LocalDate getStartDate() {
        return mDateIn;
    }
    
    /**
     * Method returns the end date of the booking.
     * @return LocalDate object containing the end date of the booking.
     */
    public LocalDate getEndDate() {
        return mDateOut;
    }
    
    /**
     * Method returns the PetNumber assigned to the pet.
     * @return int containing the petNumber
     */
    public int getPetNum() {
        return mPetNum;
    }
    
    /**
     * CompareTo method. 
     * @param obj The object to be compared against. Parsed to the Booking data type
     * @return int containing the difference between two booking objects
     */
    @Override
    public int compareTo(Object obj) {
        Booking booking = (Booking) obj;
        int difference = 0;
        if (difference == 0) {
            difference = mDateIn.compareTo(booking.getStartDate());
            if (difference == 0) {
                difference = mDateOut.compareTo(booking.getEndDate());
                if (difference == 0) {
                    difference = mPetNum - booking.getPetNum();
                }
            }
        }
        return difference;
    }
    
    /**
     * Equals class, compares this object against another and determining equality.
     * @param obj2
     * @return Boolean representing the equality of the two objects
     */
    @Override
    public boolean equals(Object obj2) {
        Booking booking = (Booking) obj2;
        Boolean result = false;
        if (mDateIn.equals(booking.getStartDate())
                && mDateOut.equals(booking.getEndDate()) 
                && mPetNum == booking.getPetNum()) {
            result = true;
            
        }
        return result;
    }
    
    /**
     * 
     * @return 
     */
    @Override 
    public String toString(){
        String result;
        
        result = "dateIn = " + this.getStartDate().format(dateTimeFormatter1);
        result += ", dateOut = " + this.getEndDate().format(dateTimeFormatter1);
        result += ", petNum = " + this.getPetNum();
        
        return result;
    }
}

