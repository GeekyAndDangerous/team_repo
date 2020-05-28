package assignment2;

/**
 *
 * @author Gareth Jones, Chris Owen, Connor Wesley-Harvey
 * @version 1.0
 * CSE2OOP
 * Tutor: Akhtar Ali Jalbani
 * Assignment 2
 * 
 */
public class Dog extends Pet {

    private String mDogColour;
    private String mDogBreed;

    /**
     * Constructor for the Dog class.
     *
     * This initializes all data members and allows appropriate data members to
     * be set. No default values exist. Super class(pet) is used to create
     * object
     *
     * @param petNum an int uniquely identifying this pet
     * @param petName a String for the name of the pet
     * @param petSex an enum (MALE or FEMALE) for the sex of pet
     * @param petVaccinated a boolean, 'true' if pet is vaccinated
     * @param petOwner a String for the name of the owner of pet
     * @param dogColour a String for colour of dog
     * @param dogBreed a String for breed of dog
     * @throws PetResortException petNum must be whole number petName and
     * petOwner cannot be empty String
     *
     */
    public Dog(int petNum, String petName, Sex petSex, boolean petVaccinated, String petOwner, String dogColour, String dogBreed) {
        super(petNum, petName, petSex, petVaccinated, petOwner);
        if (!dogColour.isEmpty()) {
            mDogColour = dogColour;
        } else {
            throw new PetResortException("Dog must have a colour");
        }
        if (!dogBreed.isEmpty()) {
            mDogBreed = dogBreed;
        } else {
            throw new PetResortException("Dog must have a breed");
        }
    }

    /**
     * Method to retrieve a dog's colour
     *
     *
     * @return aString. The colour of the dog
     */
    public String getDogColour() {
        return mDogColour;
    }

    /**
     * Method to correct incorrect input of dog's colour
     *
     * @param dogColour a String representing updated colour of dog
     * @return a boolean. If change has occurred, return 'true'.
     */
    public boolean setDogColour(String dogColour) {
        boolean completed = true;
        if (dogColour.isEmpty()) {
            completed = false;
        } else {
            this.mDogColour = dogColour;
        }
        return completed;
    }

    /**
     * Method to retrieve a dog's breed
     *
     *
     * @return aString. The breed of the dog
     */
    public String getDogBreed() {
        return mDogBreed;
    }

    /**
     * Method to correct incorrect input of dog's breed
     *
     * @param dogBreed a String representing updated breed of dog
     * @return a boolean. If change has occurred, return 'true'.
     */
    public boolean setDogBreed(String dogBreed) {
        boolean completed = true;
        if (dogBreed.isEmpty()) {
            completed = false;
        } else {
            this.mDogBreed = dogBreed;
        }
        return completed;
    }

    /**
     * CompareTo method. Compares one dog object against another dog object and
     *                   measures magnitude of their difference.
     *
     * @param obj2 The object to be compared against. Cast to the Dog data
     * type
     * @return int magnitude of the difference between two Dog objects after
     * compareTo method of Superclass is run on object.
     */
    public int compareTo(Object obj2) {
        int difference = 0;
        Dog dog2 = (Dog) obj2;
        difference = super.compareTo(dog2);
        if (difference == 0) {
            difference = this.getDogColour().compareTo(dog2.getDogColour());
            if (difference == 0) {
                difference = this.getDogBreed().compareTo(dog2.getDogBreed());
            }

        }
        return difference;
    }

    /**
     * Equals method.  Compares one dog object against another dog object for
     *                 equality. 
     * @param obj2     The object to be compared against. Cast to the Dog data
     *                 type
     * @return boolean If the first object is the same as the second object, 
     *                 return 'true'. If there are any differences, return 'false'.
     */
    public boolean equals(Object obj2) {
        boolean equals = false;
        Dog dog2 = (Dog) obj2;
        if (super.equals(dog2)
                && this.getDogBreed().equals(dog2.getDogBreed())
                && this.getDogColour().equals(dog2.getDogColour())) {
            equals = true;
        }
        return equals;
    }

    /**
     * toString method. 
     *
    
     * @return String each attribute of the object parsed to a string and 
     *                returned as a concatenated string.
     */
    @Override
    public String toString() {
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
