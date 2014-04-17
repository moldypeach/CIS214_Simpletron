/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Loader.java
 * 
 * This class ...
 */
package simpletron;

import java.util.Arrays;

public class Loader extends Simulator
{
    private Display display = getDisplay(); // Get Display reference from super class
    private Keyboard keyboard = getKeyboard(); // Get keyboard reference from super class
    private double[] memory = getMemory(); // Get memory reference from super class
        
    // Loader constructor
    public Loader(Display displayIn, Keyboard keyboardIn)
    {
        super(displayIn, keyboardIn);
    } // End constructor Loader
    
    // Method execute allows user to program Simpletron's memory with instructions
    @Override
    public void execute()
    {
        // Store user's program instruction code
        int instructionRegister = 0;
        // Track storage location of current instruction
        int instructionCounter = 0;
        // Track current opCode
        int opCode = 0;
        // Track current operand
        int operand = 0;
        // Prints Simpletron welcome message implicitly via class Display's toString() method
        System.out.print(display);

        // Get input from user to program Simpletron's memory
        do
        {
            boolean validInput = false; // Determine if valid input was received
            
            // Prompt for input while valid input is provided by user or counter is less than size of memory
            while( !validInput && instructionCounter < 100 )
            {
                System.out.printf("%02d ? ", instructionCounter);
                instructionRegister = keyboard.getInteger();
                validInput = validateCode(instructionRegister);
            }
            // If sentinel value was input by user, skip this block
            if( instructionRegister != -99999 )
            {
                opCode = instructionRegister / 100;
                operand = instructionRegister % 100;
                // Codes 10 && 21 write values to a location in memory, and are
                // checked for to ensure user is aware of programming instruct-
                // ions that will overwrite a previously stored value
                if ( ((opCode ) == 10 || ( opCode ) == 21) )
                {
                    // User wrapper classes for explicit usage of methods
                    Boolean memLocationUsed = new Boolean(false);
                    Integer tempOp = new Integer ( operand);
                    Integer tempMem = new Integer(0);
                    
                    search: // Labeled break from loop on value found
                    for(int i=0; i<instructionCounter; i++)
                    {
                        tempMem = ( (int) memory[i] ) % 100;
                        memLocationUsed = tempMem.equals(tempOp);
                        
                        if( memLocationUsed ) // ; --RIP accidental semi-colon... You stole five hours of my life, and I couldn't be happier that you're dead!-- 
                        {
                            memLocationUsed = true;
                            break search;
                        }
                    }
                    // opCode was a 10 || 21, and did already exist in memory
                    if ( memLocationUsed )
                    {
                        display.displayMessageLine("\nWARNING: an instruction is already written into memory at location " + operand);
                        display.displayMessage("Would you like to overwrite? (Y or N): ");
                        Character response = new Character( keyboard.getResponse() );
                        if( response == 'y' )
                        {
                            display.displayMessageLine("\n*** Location Overwritten ***\n");
                            memory[instructionCounter] = instructionRegister;
                            instructionCounter++;
                        }
                        // if response was "n", instruction counter is not incremented
                        // allowing the code to be re-entered
                        else
                            display.displayMessageLine("\n*** Overwrite Aborted ***\n");                        
                    }
                    // opCode was a 10 || 21, but did not already exist in memory
                    else
                    {
                        memory[instructionCounter] = instructionRegister;
                        instructionCounter++;  
                    }
                } // End if opCode 10 || 21
                // Valid opCode entered, that was not a 10 || 21
                else
                {
                    memory[instructionCounter] = instructionRegister;
                    instructionCounter++;                        
                } // End else opCode is NOT 10 || 21
            }
            // Else, time permitting, check to ensure a halt-code was entered
        } while (instructionRegister != -99999); // End do/while get input from user
        
        // Create Interpreter object
        Simulator interpreter = new Interpreter(display, keyboard);
        // Transfer control to Interpreter
        interpreter.execute();
        
//        display.dump(0000, instructionCounter, instructionRegister, opCode, operand, super.getMemory());
    } // End method execute
    
    // Validates user input to ensure valid instructions are given
    private boolean validateCode(int numIn)
    {
        boolean valid = false; // Determine if a valid instruction code was entered
        
        if( numIn > -9999 && numIn < 9999 )
        {
            switch ( numIn / 100)
            {
                case 10: // READ
                case 11: // WRITE
                case 20: // LOAD
                case 21: // STORE
                case 30: // ADD
                case 31: // SUBTRACT
                case 32: // DIVIDE
                case 33: // MULTIPLY
                case 40: // BRANCH
                case 41: // BRANCHNEG
                case 42: // BRANCHZERO
                case 43: // HALT
                    valid = true;
                    break;
                default: // Unknown code
                    display.displayMessageLine("\nERROR:\n\t CODE => " + numIn / 100 + " is unknown\n");
                    break;
            } // End switch
        } // End if validate codes
        else if (numIn == -99999)
        {
            valid = true;
            display.displayMessageLine("\n*** Program loading completed ***\n");
        }
        else
        {
            display.displayMessage("\nERROR:\n\tAn instruction code must be a four-digit number between -9999 and 9999\n");
        } // End else code input number was out of range
        
        return valid;
    }
    
} // End class Loader
