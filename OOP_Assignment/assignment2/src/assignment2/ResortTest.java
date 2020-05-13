/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Arrays;

/**
 *
 * @author Gazby
 */
public class ResortTest {
    
    public static void main(String[] args) {
    
    Resort resort1 = new Resort();
    Pet[] petsArray = new Pet[4];
    
    try{
    System.out.println(resort1.addPet(new Pet(455, "Allan", Sex.MALE, true, "Maggie Smith")));
    resort1.addPet(new Pet(291, "Jessica", Sex.FEMALE, true, "Jeff Trotston"));
    resort1.addPet(new Pet(325, "Heather", Sex.FEMALE, true, "Arthur Fort"));
    resort1.addPet(new Pet(28, "Phil", Sex.MALE, true, "Also Phil"));
    }catch (PetResortException e){
        System.out.println(e);
    }
    
        System.out.println(resort1);
    
    System.out.println(resort1.getPet(291));
    
    petsArray = resort1.getPets();
    
    for (Pet p : petsArray){
        System.out.println(p);
    }
    
    System.out.println(Arrays.toString(petsArray));
       
//    resort1.addBooking(new Booking(LocalDate dateIn,LocalDate dateOut,455));
    
}
}
