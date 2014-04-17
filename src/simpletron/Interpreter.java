/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Interpreter.java
 * 
 * This class ...
 */
package simpletron;

public class Interpreter extends Simulator
{
    // Represent accumulator register
    private double accumulator;
    // Track memory location of current instruction
    private int instructionCounter;
    // Receive next instruction to perform from memory
    private int instructionRegister;
    // Current operation to perform
    private int opCode;
    // Memory location on which current operation performs
    private int operand;
    // Get Display reference from super class
    private Display display = getDisplay();
    // Get keyboard reference from super class
    private Keyboard keyboard = getKeyboard();
    // Get memory reference from super class
    private double[] memory = getMemory();
        
    // Interpreter constructor
    public Interpreter(Display displayIn, Keyboard keyboardIn)
    {
        super(displayIn, keyboardIn);
        // Initialize accumulator to 0
        accumulator = 0; 
        // Initialize instruction counter to 0
        setCounter(0);
        // Initialize instruction register to memory location 0
        setRegister(instructionCounter);
        // Initialize operation code to leftmost two digits of instruction register
        setOpCode();
        // Initialize operand to rightmost two digits of instruction register
        setOperand();
    } // End constructor Interpreter
    
    // Method execute interprets/runs instructions programed into memory from loader
    @Override
    public void execute()
    {
        display.displayMessageLine("*** Program execution begins ***\n");
        
        runTime:
        while (getOpCode() != 43)
        {
            switch (getOpCode())
            {
                case 10: // READ
                    display.displayMessage("Please enter an integer: ");
                    memory[getOperand()] = validateInput( keyboard.getInteger() );
                    nextInstruction();
                    break;
                case 11: // WRITE
                    display.displayMessageLine("\n\tCurrent accumulator value is: " + memory[getOperand()] + "\n");
                    nextInstruction();
                    break;
                case 20: // LOAD
                    accumulator = memory[getOperand()];
                    nextInstruction();
                    break;
                case 21: // STORE
                    memory[getOperand()] = getAccumulator();
                    nextInstruction();
                    break;
                case 30: // ADD
                    performArithmetic();
                    nextInstruction();
                    break;
                case 31: // SUBTRACT
                    performArithmetic();
                    nextInstruction();
                    break;
                case 32: // DIVIDE
                    performArithmetic();
                    nextInstruction();
                    break;
                case 33: // MULTIPLY
                    performArithmetic();
                    nextInstruction();
                    break;
                case 40: // BRANCH
                    nextInstruction( getOperand() );
                    break;
                case 41: // BRANCHNEG
                    if( getAccumulator() < 0 )
                        nextInstruction( getOperand() );
                    else
                        nextInstruction();
                    break;
                case 42: // BRANCHZERO
                    if ( getAccumulator() == 0 )
                        nextInstruction( getOperand() );
                    else
                        nextInstruction();
                    break;                            
                case 43: // HALT
                    display.displayMessageLine("\n*** Simpletron execution terminated ***\n");
                    break;
                case 00:
                    display.displayMessageLine("\n*** Simpletron execution abnormally terminated ***\n");
                    break runTime;                   
                default:
                    display.displayMessageLine("*** Simpletron execution abnormally terminated ***");
                    break runTime;
            } // End switch
        } // End while opCode != 43 (halt code)
        
        display.displayMessageLine("\n*** Simpletron execution terminated ***\n");
        
        display.dump(getAccumulator(), getCounter(), getRegister() , getOpCode(), getOperand(), memory);
    }
    
    private int validateInput(int numIn)
    {
        Boolean isValidInput = new Boolean(false);
        
        while( !isValidInput )
        {
            if( numIn >= -9999 && numIn <= 9999 )
            {
                isValidInput = true;
            }
            else
            {
                display.displayMessageLine("\nERROR: Integer must be within range of -9999:9999\n");
                display.displayMessage("Please enter an integer: ");
                numIn = keyboard.getInteger();
            }
        } // End while is isValidInput
        
        return numIn;
    } // End method validateInput
    
    // Get the Simpletron Accumulator value
    private double getAccumulator()
    {
        return accumulator;
    } // End method getAccumulator
    
    // Set the Simpletron Regsiter
    private void setRegister(int ic)
    {
        instructionRegister = (int) memory[ic];
    } // End method setRegister
    
    // Get the current Simpletron register value
    private int getRegister()
    {
        return instructionRegister;
    } // End method getRegister
    
    // Set the Simpletron Instruction Counter for initialization/branching
    private void setCounter(int op)
    {
        instructionCounter = op;
    } // End method setCounter
    
    // Set the Simpletron Instruction Counter for incrementation operations
    private void setCounter()
    {
        instructionCounter++;
    } // End method setCounter 
    
    // Get the Simpletron instructionCounter
    private int getCounter()
    {
        return instructionCounter;
    } // End method getCounter
    
    // Set the operation code
    private void setOpCode()
    {
        opCode = getRegister() / 100;
    } // End method setOpCode
    
    // Set the operation code on errors to break from execution
    private void setOpCode(int op)
    {
        opCode = op;
    } // End method setOpCode
    
    // Get the operation code
    private int getOpCode()
    {
        return opCode;
    } // End method getOpCode
    
    // Set the operand
    private void setOperand()
    {
        operand = getRegister() % 100;
    } // End method setOperand
    
    // Get the operand
    private int getOperand()
    {
        return operand;
    } // End method getOperand
    
    // Retrieve next sequential instruction and set fields
    private void nextInstruction()
    {
        setCounter(); // Increment Instruction Counter
        setRegister( getCounter() ); // Set register to memory location at instruction counter
        setOpCode(); // Set opcode at memory location
        setOperand(); // Set operand at memory location
    } // End method nextInstruction
    
    // Retrieve next branching instruction and set fields
    private void nextInstruction(int op)
    {
        setCounter(op); // set Instruction Counter to operand (branch event)
        setRegister( getCounter() ); // Set register to memory location at instruction counter
        setOpCode(); // Set opcode at memory location
        setOperand(); // Set operand at memory location 
    } // End method nextInstruction
    
    // Perform an arithmetic operation upon the accumulator
    private void performArithmetic()
    {
        switch (opCode)
        {
            case 30:
                // Add a word at memory location into the accumulator
                if ( ( accumulator + memory[getOperand()] ) > 9999 || ( accumulator + memory[getOperand()] ) < -9999)
                {
                    display.displayMessageLine("\n*** FATAL ERROR: accumulator overflow ***");
                    setOpCode(00);
                }          
                else
                    accumulator += memory[getOperand()]; 
                break;
            case 31:
                // Subtract a word at a memory location from the accumulator
                if( ( accumulator - memory[getOperand()] ) > 9999 || ( accumulator - memory[getOperand()] ) < -9999 )
                {
                    display.displayMessageLine("\n*** FATAL ERROR: accumulator overflow ***");
                    setOpCode(00);                    
                }                
                else
                    accumulator -= memory[getOperand()];
                break;
            case 32:
                // Divide a word at a memory location from the accumulator
                if( accumulator == 0 )
                {
                    display.displayMessageLine("\n*** FATAL ERROR: cannot divide by zero ***");
                    setOpCode(00);                     
                }
                else
                    accumulator /= memory[getOperand()];
                break;
            case 33:
                // Multiply a word at a memory location by the accumulator
                if( ( accumulator * memory[getOperand()] ) > 9999 || ( accumulator * memory[getOperand()] ) < -9999 )
                {
                    display.displayMessageLine("\n*** FATAL ERROR: accumulator overflow ***");
                    setOpCode(00);                      
                }
                else
                    accumulator *= memory[getOperand()];
                break;
            default:
                display.displayMessageLine("\nERROR: invalid opCode received. \n");
        } // End switch arithmetic operation
    } // End method performArithmetic
    
} // End class Interpreter
