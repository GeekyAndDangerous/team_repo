/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 */
public class Pet implements Comparable {
    
    private int mPetNum;
    private String mPetName;
    private Sex mPetSex;
    private boolean mPetVaccinated;
    private String mPetOwner;
    
    public Pet(int petNum, String petName, Sex petSex, boolean petVaccinated,
            String petOwner)
    {
        if (petNum <= 0)
        {
            throw new PetResortException("Illegal Argument: petNum isn't a positive whole number");
        }
        else if (petName.isEmpty())
        {
           throw new PetResortException("Illegal Argument: petName is empty"); 
        }
        else if (petOwner.isEmpty())
        {
           throw new PetResortException("Illegal Argument: petOwner is empty"); 
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
    
    public String getPetOwner(){
        return mPetOwner;
    }
    
    public int compareTo(Object obj2)
    {
        Pet pet2 = (Pet) obj2;
        int difference = 0;
        difference = this.getPetNum() - pet2.getPetNum();
        if (difference == 0)
        {
            difference = this.getPetName().compareTo(pet2.getPetName());
            if (difference == 0)
            {
                difference = this.getPetSex().compareTo(pet2.getPetSex());
                if (difference == 0)
                {
                    if(this.getPetVaccinated() == (pet2.getPetVaccinated()))
                    {
                        difference = this.getPetOwner().compareTo(pet2.getPetOwner());
                    }
                    else
                        difference = 1;
                }
            }
        }
        return difference;
    }
    
    public boolean equals(Object obj2)
    {
        boolean equals = false;
        Pet pet2 = (Pet) obj2;
        if (this.getPetNum() == pet2.getPetNum()
                && this.getPetName().equals(pet2.getPetName())
                && this.getPetSex() == pet2.getPetSex()
                && this.getPetVaccinated() == pet2.getPetVaccinated()
                && this.getPetOwner().equals(pet2.getPetOwner()))
        {
        return equals = true;
        }
        return equals;
    }
    
    public String toString(){
        String result;
        
        result = "petNum=" + this.getPetNum();
        result += "petName=" + this.getPetName();
        result += "petSex=" + this.getPetSex();
        result += "vaccinated=" + this.getPetVaccinated();
        result += "petOwner=" + this.getPetOwner();
        
        return result;
    }
}
