
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

public class PetResortException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>PetResortException</code> without detail
     * message.
     */
    public PetResortException() {
        super("Pet Resort Exception");
    }

    /**
     * Constructs an instance of <code>PetResortException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PetResortException(String msg) {
        super(msg);
    }
}
