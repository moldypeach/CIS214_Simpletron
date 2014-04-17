/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Signature Block Class (Module 2)
 *Author:       Todd Parker
 *Date:         18 Sep 2013
 *Filename:     Student_Sig_Block.java
 */
package Sig_Block;

import java.util.Scanner; // Import scanner utility

public class Student_Sig_Block
{
    // Create Scanner object to receive input from a user
    Scanner input = new Scanner( System.in);    
    
    // Declare and initialize variables to hold student/course information
    private String studentName = "Todd Parker";
    private String studentEmail = "todd.i.parker@maine.edu";
    private String courseInfo = "CIS214 Intro to Java Programming";
        
    // Print a signature block with an * border
    /** This is the legacy signature block function from Module1 */
    public void displaySignature()
    {
        // Declare variables to create ascii border for signature block
        String border = "";
        int borderCharacters = 80;
        
        // Use a for loop structure to populate the border variable with an
        // 80 character line of *'s. Loop utilizes string concatenation.
        for (int i = 0; i < borderCharacters; ++i)
        {
            border += "*";
        }
        // Print sig-block output as five strings, separated by newlines
        System.out.printf("\n%s\n%s\n%s\n%s\n\n%s\n\n", border, studentName,
                studentEmail, courseInfo, border);
    } // end method displaySignature
    
    // Print a signature block within a dialog box window
    // Get and set method functionality is built-in to SigDialogBox class, but
    // not utilitized in this version of the signature block program
    public void dailogBox()
    {
       // Create SigDialogBox object initialized to default values
       SigDialogBox sigBox = new SigDialogBox( studentName, studentEmail, courseInfo );
       
       // Call SigDialogBox method "displayDialogBox" to output dialog box with signature block
       sigBox.displayDialogBox();
    } // End method dialogBox
    
    // Print a signature block within a JFrame, and with formatted text
    public void prettyPrint()
    {
        // Create SigPrettyPrint object initialized to default values
        SigPrettyPrint sigPP = new SigPrettyPrint( studentName, studentEmail, courseInfo);
        
        // Declare font formatting input variables
        String fontIn = "";
        int styleIn = 3;
        int sizeIn = 20;
        
        System.out.print("\nWould you like to modify any of the signature block fonts? ( 1 or 0 ): ");
        int formatChoice = input.nextInt();
        
        if ( formatChoice == 1 )
        {
            // Print usage information to screen
            System.out.println("\n\n******************** Font Style Entry Examples ********************");
            System.out.println("Font Types: Monospaced, SansSerif, Serif");
            System.out.println("Font Styles: 0-PLAIN, 1-BOLD, 2-ITALICS, 3-BOLD & ITALICS");
            System.out.println("Font Sizes: Any integer value (measured in points which equal 1/72 of an inch\n");
            System.out.println("\nPlease select a menu option as follows: \n");
            System.out.println("\t (0) - Modify Signature Block Name font");
            System.out.println("\t (1) - Modify Signature Block Email and Course Information font");
            System.out.println("\t (2) - Modify Both");
            System.out.println("\t (3) - Cancel \n");

            // Prompt user for menu option entry
            System.out.print("Menu choice: ");
            // Store user entry
            int formatOption = input.nextInt();
          
            switch ( formatOption )
            {
                case 0: // Modify Signature Block Name Font
                    System.out.print("\nPlease enter a font type: ");
                    fontIn = input.next();
                    System.out.print("\nPlease enter a font style: ");
                    styleIn = input.nextInt();
                    System.out.print("\nPlease enter a font size: ");
                    sizeIn = input.nextInt();
                    sigPP.setNLabelFont( fontIn, styleIn, sizeIn );                    
                    break;
                case 1: // Modify Signature Block Email and Course Information Font
                    System.out.print("\nPlease enter a font type: ");
                    fontIn = input.next();
                    System.out.print("\nPlease enter a font style: ");
                    styleIn = input.nextInt();
                    System.out.print("\nPlease enter a font size: ");
                    sizeIn = input.nextInt();
                    sigPP.setBLabelFont( fontIn, styleIn, sizeIn );
                    break;
                case 2: // Modify Font for Both
                    System.out.print("\nPlease enter a font type: ");
                    fontIn = input.next();
                    System.out.print("\nPlease enter a font style: ");
                    styleIn = input.nextInt();
                    System.out.print("\nPlease enter a font size: ");
                    sizeIn = input.nextInt();
                    sigPP.setNLabelFont( fontIn, styleIn, sizeIn );                     
                    sigPP.setBLabelFont( fontIn, styleIn, sizeIn );
                    break;
                case 3: // Cancel Font Modification
                    break;
                default: // Input was not valid
                    System.out.println("\n\t\tInput was invalid, please try again\n");
                    break;
            }            
        }
        
        sigPP.signatureFrame();
    } // End method prettyPrint
    
} // end class Student_Sig_Block

