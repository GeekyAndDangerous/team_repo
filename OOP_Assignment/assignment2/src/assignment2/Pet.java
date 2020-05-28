
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
public class Pet implements Comparable {

    private int mPetNum;
    private String mPetName;
    private Sex mPetSex;
    private boolean mPetVaccinated;
    private String mPetOwner;
    
    /**
    * Constructor for the Pet class. 
    *
    * This initializes all data members and allows appropriate data members 
    * to be set. No default values exist.
    *
    * @param petNum                 an int uniquely identifying this pet
    * @param petName                a String for the name of the pet
    * @param petSex                 an enum (MALE or FEMALE) for the sex of pet
    * @param petVaccinated          a boolean, 'true' if pet is vaccinated
    * @param petOwner               a String for the name of the owner of pet
    * @throws PetResortException    petNum must be whole number
    *                               petName and petOwner cannot be empty String
    *                               
    */

    public Pet(int petNum, String petName, Sex petSex, boolean petVaccinated,
            String petOwner) {
        if (petNum <= 0) {
            throw new PetResortException("Illegal Argument: petNum isn't a positive whole number");
        } else if (petName.isEmpty()) {
            throw new PetResortException("Illegal Argument: petName is empty");
        } else if (petOwner.isEmpty()) {
            throw new PetResortException("Illegal Argument: petOwner is empty");
        } else {
            mPetNum = petNum;
            mPetName = petName;
            mPetSex = petSex;
            mPetVaccinated = petVaccinated;
            mPetOwner = petOwner;
        }
    }

    /**
    * Method to retrieve a pet's identifying number
    *
    * 
    * @return an int. The pet's unique identifying number
    */
    public int getPetNum() {
        return mPetNum;
    }

    /**
    * Retrieve a pet's name
    *
    * 
    * @return a String. The pet's name
    */
    public String getPetName() {
        return mPetName;
    }

    /**
    * Method to change the name of a pet.
    *
    * @param petName a String. The new name for the pet
    * @return a boolean. If the change was successful, return 'true'. If not,
    *                    return false
    */
    public boolean setPetName(String petName) {
        boolean completed = true;
        if (petName.isEmpty()) {
            completed = false;
        } else {
            mPetName = petName;
        }
        return completed;
    }

    
    /**
    * Method to retrieve a pet's sex
    *
    * 
    * @return an enum. Sex can be MALE or FEMALE
    */
    public Sex getPetSex() {
        return mPetSex;
    }

    /**
    * Method to correct incorrect input of pet's sex.
    *
    * @param petSex an enum, either MALE or FEMALE
    * @return a boolean. If change was successful, return 'true'.
    */
    public boolean setPetSex(Sex petSex) {
        boolean completed = true;
        if (petSex != Sex.FEMALE && petSex != Sex.MALE) {
            completed = false;
        } else {
            mPetSex = petSex;
        }
        return completed;
    }

    /**
    * Method to retrieve a pet's vaccination status
    *
    * 
    * @return a boolean. If pet is vaccinated return 'true'. 
    *                    If pet is unvaccinated, return 'false'.
    */
    public boolean getPetVaccinated() {
        return mPetVaccinated;
    }

    /**
    * Method to change a pet's vaccination status
    *
    * @param petVaccinated a boolean indicating the new status of vaccination
    * @return a boolean. If the change was successful, return 'true'
    *                    If not, return 'false'.
    */
    public boolean setPetVaccinated(boolean petVaccinated) {
        boolean completed = true;
        if (petVaccinated != false && petVaccinated != true) {
            completed = false;
        } else {
            mPetVaccinated = petVaccinated;
        }
        return completed;
    }

    /**
    * Retrieve a pet's owner's name
    *
    * 
    * @return a String. The pet's owner's name
    */
    public String getPetOwner() {
        return mPetOwner;
    }

    
    /**
     * CompareTo method. Compares one pet object against another pet object and
     *                   measures magnitude of their difference.
     *
     * @param obj2 The object to be compared against. Cast to the Pet data
     * type
     * @return int magnitude of the difference between two Pet objects
     */
    @Override
    public int compareTo(Object obj2) {
        Pet pet2 = (Pet) obj2;
        int difference = 0;
        difference = this.getPetNum() - pet2.getPetNum();
        if (difference == 0) {
            difference = this.getPetName().compareToIgnoreCase(pet2.getPetName());
            if (difference == 0) {
                difference = this.getPetSex().compareTo(pet2.getPetSex());
                if (difference == 0) {
                    if (this.getPetVaccinated() == (pet2.getPetVaccinated())) {
                        difference = this.getPetOwner().compareToIgnoreCase(pet2.getPetOwner());
                    } else {
                        difference = 1;
                    }
                }
            }
        }
        return difference;
    }

    /**
     * Equals method.  Compares one pet object against another pet object for
     *                 equality. 
     * @param obj2     The object to be compared against. Cast to the Pet data
     *                 type
     * @return boolean If the first object is the same as the second object, 
     *                 return 'true'. If there are any differences, return 'false'.
     */
    @Override
    public boolean equals(Object obj2) {
        boolean equals = false;
        Pet pet2 = (Pet) obj2;
        if (this.getPetNum() == pet2.getPetNum()
                && this.getPetName().equalsIgnoreCase(pet2.getPetName())
                && this.getPetSex() == pet2.getPetSex()
                && this.getPetVaccinated() == pet2.getPetVaccinated()
                && this.getPetOwner().equalsIgnoreCase(pet2.getPetOwner())) {
            return equals = true;
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

        result = "petNum=" + this.getPetNum();
        result += "petName=" + this.getPetName();
        result += "petSex=" + this.getPetSex();
        result += "vaccinated=" + this.getPetVaccinated();
        result += "petOwner=" + this.getPetOwner();

        return result;
    }
}
