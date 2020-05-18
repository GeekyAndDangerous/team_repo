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
