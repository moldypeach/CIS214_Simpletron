/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Simpletron Simulator (Module 6)
 *Author:       Todd Parker
 *Date:         17 Dec 2013
 *Filename:     Simulator.java
 * 
 * This abstract class simulates the program loader and Simpletron interpreter,
 * which are concrete classes of this class. This classes constructor is used
 * to initialize a 100-word decimal memory shared by subclasses, and to make
 * the Simpletron's simulated memory, display and keyboard available via methods
 * getMemory(), getDisplay(), and getKeyboard(). Abstract method execute() is 
 * overloaded by subclasses to afford the unique functionality of those classes.
 */
package simpletron;

public abstract class Simulator
{
    // Simpletron's 100-word 4-digit decimal memory
    private static double[] memory = new double[100];
    // Simpletron's display
    private Display display;
    // Simpletron's keyboard
    private Keyboard keyboard;
    
    // Simulator constructor invoked by sublasses
    public Simulator(Display displayIn, Keyboard keyboardIn )
    {
        display = displayIn;
        keyboard = keyboardIn;
    } // End constructor Simulator  
    
    // Get memory reference
    public double[] getMemory()
    {
        return memory;
    } // End get method getMemory
    
    // Get Display reference
    public Display getDisplay()
    {
        return display;
    } // End get method getDisplay
    
    // Get Keyboard reference
    public Keyboard getKeyboard()
    {
        return keyboard;
    } // End get method getKeyboard    
        
    // Perform simulation based upon the execution phase, as determined by
    // subclasses (i.e. program-load or program-execution)
    abstract public void execute();
    
} // End abstract class Simulator
