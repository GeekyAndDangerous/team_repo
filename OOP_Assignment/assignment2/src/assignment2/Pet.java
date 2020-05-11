/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Gazby
 */
public class Pet {
    
    private int mPetNum;
    private String mPetName;
    private Sex mPetSex;
    private boolean mPetVaccinated;
    private String mPetOwner;
    
    public Pet(int petNum, String petName, Sex petSex, boolean petVaccinated, String petOwner)
    {
        if (mPetNum <= 0)
        {
            throw new IllegalArgumentException("Illegal Argument: petNum isn't a positive whole number");
        }
        else if (mPetName.isEmpty())
        {
           throw new IllegalArgumentException("Illegal Argument: petName is empty"); 
        }
        else if (mPetOwner.isEmpty())
        {
           throw new IllegalArgumentException("Illegal Argument: petOwner is empty"); 
        }
        else
        {
            mPetNum = petNum;
            mPetName = petName;
            mPetSex = petSex;
            mPetVaccinated = petVaccinated;
            mPetOwner = petOwner;
        }
    }
    
    public int getPetNum()
    {
        return mPetNum;
    }
    
    public String getPetName()
    {
        return mPetName;
    }
    
    public boolean setPetName(String petName)
    {
        boolean completed = true;
        if (petName.isEmpty())
            completed = false;
        else
            mPetName = petName;
        return completed;        
    }
    
    public Sex getPetSex()
    {
        return mPetSex;
    }
    
    public boolean setPetSex(Sex petSex)
    {
        boolean completed = true;
        if (petSex != Sex.FEMALE && petSex != Sex.MALE)
            completed = false;
        else
            mPetSex = petSex;
        return completed;
    }
    
    public boolean getPetVaccinated()
    {
        return mPetVaccinated;
    }
    
    public boolean setPetVaccinated(boolean petVaccinated)
    {
        boolean completed = true;
        if (petVaccinated != false && petVaccinated != true)
            completed = false;
        else
            mPetVaccinated = petVaccinated;
        return completed;
    }
    
    public int compareTo(Object obj2)
    {
        Pet pet2 = (Pet) obj2;
        
    }
    
    public boolean equals(Object obj2)
    {
        boolean equal = false;
        Pet pet2 = (Pet) obj2;
        if ()
    }
}
