/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Connor
 */
public class Dog extends Pet {
    
    String mDogColour;
    String mDogBreed;
    
    public Dog(int petNum, String petName, Sex petSex, boolean petVaccinated, String petOwner, String dogColour, String dogBreed) 
    {
        super(petNum, petName, petSex, petVaccinated, petOwner);
        mDogColour = dogColour;
        mDogBreed = dogBreed;
    }
    
    public String getDogColour()
    {
        return mDogColour;
    }
    
    public boolean setDogColour(String dogColour)
    {
        boolean completed = true;
        if (dogColour.isEmpty())
            completed = false;
        return completed;
    }
    
    public String getDogBreed()
    {
        return mDogBreed;
    }
    
    public boolean setDogBreed(String dogBreed)
    {
        boolean completed = true;
        if  (dogBreed.isEmpty())
            completed = false;
        return completed;
    }
    
    public int compareTo()
    {
        return 0;
    }
    
    public boolean equals()
    {
        return false;
    }
    
}
