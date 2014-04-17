/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Display.java
 * 
 * This class simulates the screen of the Simpletron computer. Its methods
 * receive arguments specifying a message, and simply print that to the screen
 * with or without a carriage return. the 'dump' method is used to debug the 
 * Simpletron simulator, and accepts/prints the simulator's registers and memory
 * 
 * A series of overloaded void functions [displayMessage|displayMessageLine[ are
 * established to print messages of their respective types (e.g. int, String,
 * double). Method dump() receives arguments from the Interpreter and prints
 * them to the display for debugging purposes (e.g. the last values of
 * Simpletron's registers and the signed values in Simpletron's memory). Lastly,
 * a toSring() method is used to implicitly display a welcome message.
 */
package simpletron;

public class Display
{
    // Following is a series of overloaded methods for printing strings, integers, and decimals
    
    // Display a message with a carriage return
    public void displayMessageLine( String message )
    {
        System.out.println(message);
    } // End method displayMessageLine
    
    // Display a message without a carriage return
    public void displayMessage( String message )
    {
        System.out.print(message);
    } // End method displayMessage
    
    // Display a message with a carriage return
    public void displayMessageLine( int message )
    {
        System.out.println(message);
    } // End method displayMessageLine
    
    // Display a message without a carriage return
    public void displayMessage( int message )
    {
        System.out.print(message);
    } // End method displayMessage
    
    // Display a message with a carriage return
    public void displayMessageLine( double message )
    {
        System.out.println(message);
    } // End method displayMessageLine
    
    // Display a message without a carriage return
    public void displayMessage( double message )
    {
        System.out.print(message);
    } // End method displayMessage     
    
    // Display debugging information for Simultron simulator
    public void dump(double accumulator, int ic, int ir, int oc, int op, double mem[])
    {
        // Print the registers for Simplestron simulator
        System.out.printf("REGISTERS:\n %-25s %+5.0f\n %-25s %5d\n %-25s %+5d\n %-25s %5d\n %-25s %5d\n", "Accumulator:", accumulator, "Insctruction Counter:", ic, "Insctruction Register:", ir, "Operation Code:", oc, "Operand", op);
        displayMessageLine("\nMEMORY:");
        // Print the memory of Simpletron simulator in formatted matrix
        System.out.printf("%2s %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d\n", "", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int i=0; i<mem.length; i+=10)
        {
            // Get the current row number
            int currRow = i/10;
            // Print formatted row of memory array elements
            System.out.printf("%2d %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f %+05.0f\n", currRow, mem[i], mem[i+1], mem[i+2], mem[i+3], mem[i+4], mem[i+5], mem[i+6], mem[i+7], mem[i+8], mem[i+9] );
        }
    } // End method dump
    
    // Implicitly called Simpletron welcome message
    @Override
    public String toString()
    {
        // Variables holding the welcome message on a line-by-line basis
        String filler = "***";
        String line1 = " Welcome to Simpletron! ";
        String line2 = " Please enter your program one instruction (or data word) at a time. ";
        String line3 = " I will display the location number and a question mark (?) ";
        String line4 = " You then type the word for that location. ";
        String line5 = " Type -99999 to stop entering your program. ";
        String line6 = " \n Input/output Codes: \n\n\tREAD = 10\n\tWRITE = 11\n\n Load/Store Codes:\n\n\tLOAD = 20\n\tSTORE = 21\n\n Arithmetic Codes:\n\n\tADD = 30\n\tSUBTRACT = 31\n\tDIVIDE = 32\n\tMULTIPLY = 33\n\n Transfer-of-control Codes:\n\n\tBRANCH = 40\n\tBRANCHNEG = 41\n\tBRANCHZERO = 42\n\tHALT = 43\n\n";
        
        return String.format("%-3s %-70s %3s\n%-3s %-70s %3s\n%-3s %-70s %3s\n%-3s %-70s %3s\n%-3s %-70s %3s\n\n %s", filler, line1, filler, filler, line2, filler, filler, line3, filler, filler, line4, filler, filler, line5, filler, line6);
    } // End method toString()
    
} // End class Display
