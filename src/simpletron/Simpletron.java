/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Simpletron.java
 * 
 * This program utilizes software-based emulation to create an object-oriented 
 * software model of a Simpletron Computer. The program operates in two phases, 
 * load and execute. During load phase, a user is prompted to input instruction
 * codes (Simpletron Machine Language - SML) into the simulator's memory. When
 * finished programming Simpletron's memory, a sentinel value is entered by the
 * user, and the execution phase automatically commences.  During execution, 
 * the SML codes are interpreted, validated, and processed; which, results in
 * the user being able to run the program entered during the load phase. The
 * output of this simulator is simple arithmetic operations, limited in range
 * of values between -9999 and 9999
 */
package simpletron;

import Sig_Block.Student_Sig_Block; // Import signature block class

public class Simpletron
{        
    public static void main(String[] args) 
    {
        // create and instantiate signature block object
        Student_Sig_Block sig = new Student_Sig_Block();
        Display display = new Display();
        Keyboard keyboard = new Keyboard();
        
        // Print signature block header to output
        sig.displaySignature();
        // Create and initialize simulator object of type Loader
        Simulator simulator = new Loader(display, keyboard);
        // Start simulator
        simulator.execute();
    } // End program main
} // End class Simpletron
