/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class ResortTest {
    
    public static void main(String[] args) {
    
    Resort resort1 = new Resort();
    Pet[] petsArray = new Pet[4];
    Pet[] petsArray2 = new Pet[4];
    
    try{
    System.out.println(resort1.addPet(new Pet(455, "Allan", Sex.MALE, true, "Maggie Smith")));
    resort1.addPet(new Pet(291, "Jessica", Sex.FEMALE, true, "Jeff Trotston"));
    resort1.addPet(new Pet(325, "Heather", Sex.FEMALE, true, "Arthur Fort"));
    resort1.addPet(new Pet(28, "Phil", Sex.MALE, true, "Also Phil"));
    }catch (PetResortException e){
        System.out.println(e);
    }
    
    try{
        System.out.println(resort1.addBooking(new Booking(LocalDate.of(2021, 10, 02), LocalDate.of(2021, 12, 06), 291)));
    }catch (PetResortException e){
        System.out.println(e);
    }
    
      System.out.println(resort1.isPet(291));
//    System.out.println(resort1.getPet(325));
//    
//    petsArray = resort1.getPets();
////    
////    petsArray2 = resort1.getPets("Allan");
////        System.out.println("\n" + Arrays.toString(petsArray2));
////    
////    for (Pet p : petsArray){
////        System.out.println("\n" + p);
////    }
////    
//    System.out.println("\n" + Arrays.toString(petsArray));
//    
    Booking[] bookingsArray = new Booking[4];
    bookingsArray = resort1.getBookings();
    System.out.println("\n" + Arrays.toString(bookingsArray));
    
       
//    resort1.addBooking(new Booking(LocalDate dateIn,LocalDate dateOut,455));
    
}
}
