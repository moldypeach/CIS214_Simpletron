/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Keyboard.java
 * 
 * This class simulates the keyboard of the Simpletron computer. Its constructor
 * initializes a Scanner object on object creation. Methods getInteger() and
 * getResponse() are called to return input validated to the expected type. i.e.
 * getInteger uses exception handling to ensure only a valid integer is input 
 * and getResponse accepts and returns only a Y or N value (the user is prompted
 * until such a value is received).
 */
package simpletron;

import java.util.InputMismatchException;
import java.util.Scanner; // Utilitze Scanner to get user input

public class Keyboard
{
    private Scanner input; // Gets data from CLI
    
    // Keyboard Constructor to initialize Scanner
    public Keyboard()
    {
        input = new Scanner( System.in );
    } // End constructor Keyboard
    
    // Method to get an integer from user
    public int getInteger()
    {
        boolean valid = false; // Flag tests whether a valid number was received
        int number = 0; // User-entered number
        
        while( !valid )
        {
            try
            {
                number = input.nextInt(); // Get a number from user
                valid = true;
            }
            catch (InputMismatchException e)
            {
               input.next(); // Discard invalid entry in Scanner
               System.out.println("\n\t*** A valid integer was not entered ***\n");
               System.out.print("Please enter an integer: ");
            }      
        }
        
        return number;
        
    } // End method getInteger
    
    // Method to get a Y or N response
    public char getResponse()
    {
        boolean valid = false; // Flag tests whether a valid response was received
        Character response;
        
        do
        {
            response = new Character( input.next().charAt(0) );
            // Ensure user entered only a Yy or Nn response
            if( Character.toLowerCase(response) == 'y'  || Character.toLowerCase(response) == 'n')
            {
                valid = true;
            }
            // User entered valid input
            else
                valid = false;
            
        } while ( !valid );
        
        return Character.toLowerCase(response);
        
    } // End method getResponse()

} // End class Keyboard
