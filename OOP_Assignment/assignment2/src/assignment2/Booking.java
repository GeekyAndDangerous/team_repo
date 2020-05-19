/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;

/**
 * @version 1.0 
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class Booking {
    
    //Data Members
    LocalDate mDateIn;
    LocalDate mDateOut;
    int mPetNum;
    
    public Booking(LocalDate dateIn,LocalDate dateOut,int petNum) {
        if (dateIn.isAfter(LocalDate.now()) 
                && dateOut.isAfter(dateIn)
                && petNum > 0) {
            mPetNum = petNum;
            mDateIn = dateIn;
            mDateOut = dateOut;
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
    
    public int getPetNum() {
        return mPetNum;
    }
    
    /**
     * CompareTo method. 
     * @return int containing the difference between two booking objects
     */
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
    
    @Override 
    public String toString(){
        String result;
        
        result = "dateIn = " + this.getStartDate();
        result += "dateOut = " + this.getEndDate();
        result += "petNum = " + this.getPetNum();
        
        return result;
    }
}

