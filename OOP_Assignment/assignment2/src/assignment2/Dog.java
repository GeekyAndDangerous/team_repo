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
public class Dog extends Pet {
    
    private String mDogColour;
    private String mDogBreed;
    
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
        if (dogColour.isEmpty()){
            completed = false;
        }else{
            this.mDogColour = dogColour;
        }
        return completed;
    }
    
    public String getDogBreed()
    {
        return mDogBreed;
    }
    
    public boolean setDogBreed(String dogBreed)
    {
        boolean completed = true;
        if  (dogBreed.isEmpty()){
            completed = false;
        }else{
            this.mDogBreed = dogBreed;
        }
        return completed;
    }
    
    public int compareTo(Object obj2)
    {
        int difference = 0;
        Dog dog2 = (Dog) obj2;
        difference = super.compareTo(dog2);
        if (difference == 0)
        {
            difference = this.getDogColour().compareTo(dog2.getDogColour());
            if (difference == 0)
            {
                difference = this.getDogBreed().compareTo(dog2.getDogBreed());
            }
                    
        }
        return difference;
    }
    
    public boolean equals(Object obj2)
    {
        boolean equals = false;
        Dog dog2 = (Dog) obj2;
        if (super.equals(dog2)
                && this.getDogBreed().equals(dog2.getDogBreed())
                && this.getDogColour().equals(dog2.getDogColour()))
        {
            equals = true;
        }
        return equals;
    }
    
    @Override
    public String toString(){
        String result;
        result = "dogNum=" + this.getPetNum();
        result += "dogName=" + this.getPetName();
        result += "dogSex=" + this.getPetSex();
        result += "vaccinated=" + this.getPetVaccinated();
        result += "dogOwner=" + this.getPetOwner();
        result += "dogColour=" + this.mDogColour;
        result += "dogBreed=" + this.mDogBreed;
        
        return result;
    }
    
}
