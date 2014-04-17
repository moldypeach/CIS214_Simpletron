/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Signature Block Class (Module 2)
 *Author:       Todd Parker
 *Date:         29 Sep 2013
 *Filename:     SigPrettyPrint.java
 */
package Sig_Block;

// Import API's to create, format, and color a frame and font's
//import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
//import java.awt.Graphics;

//import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SigPrettyPrint
{
    // Fields for signature block String information
    private String studentName; // Student Name for this dialog box
    private String studentEmail; // Student Email for this dialog box
    private String courseInfo; // Student course info for this dialog box
    
    // Font stylization variables for signature block name label
    private String nLabelFontName = "SansSerif"; // Font name to use
    private int nLabelFontStyle = 3; // Set font style (0-PLAIN, 1-BOLD, 2-ITALIC, 3-BOLD&ITALIC)
    private int nLabelFontSize = 25; // Font size to use
    
    // Font stylization variables for signature block body labels
    private String bLabelsFontName = "Serif"; // Font name to use
    private int bLabelsFontStyle = 0; // Set font style (0-PLAIN, 1-BOLD, 2-ITALIC, 3-BOLD&ITALIC)
    private int bLabelsFontSize = 15; // Font size to use    
        
    // constructor SigPrettyPrint initializes dialog box variables with String arguments
    public SigPrettyPrint( String name, String email, String course )
    {
        studentName = name; // Initialize student name
        studentEmail = email; // Initialize student email
        courseInfo = course; // Initialize student course information
    } // End constructor
    
    // Create signature block frame
    public void signatureFrame()
    {
        // Create labels for name, email, and course and center horizontally
        JLabel nameLabel = new JLabel( studentName, SwingConstants.CENTER );
        JLabel emailLabel = new JLabel( studentEmail, SwingConstants.CENTER );
        JLabel courseLabel = new JLabel( courseInfo, SwingConstants.CENTER );
        // Set vertical alignment of the labels for name, email, and course
        nameLabel.setVerticalAlignment( SwingConstants.TOP );
        emailLabel.setVerticalAlignment( SwingConstants.CENTER );
        courseLabel.setVerticalAlignment( SwingConstants.CENTER );
        
        // Set label font type, style, size
        nameLabel.setFont(new Font( nLabelFontName, nLabelFontStyle, nLabelFontSize ));
        emailLabel.setFont(new Font( bLabelsFontName, bLabelsFontStyle, bLabelsFontSize ));
        courseLabel.setFont(new Font( bLabelsFontName, bLabelsFontStyle, bLabelsFontSize ));
                
        // Title signature frame, set on-exit property, and create grid layout
        JFrame sigFrame = new JFrame( "Pretty Print Signature Block" );
        sigFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        JPanel sigPanel = new JPanel( new GridLayout(3,1,0,0 ));
        
        // Add signature block labels to signature panel
        sigPanel.add(nameLabel);
        sigPanel.add(emailLabel);
        sigPanel.add(courseLabel);
        
        // Set content pane and size/visibility of sigFrame
        sigFrame.setContentPane(sigPanel);
        sigFrame.setSize(500, 200);
        sigFrame.setVisible(true);        
    } // End method signatureFrame
    
    public void setNLabelFont( String font, int style, int size )
    {
        nLabelFontName = font; // Set name label font type
        nLabelFontStyle = style; // Set name label font style
        nLabelFontSize = size; // Set name label font size
    } // End setNLabelFont
    
    public void setBLabelFont( String font, int style, int size)
    {
        bLabelsFontName = font; // Set body labels font type
        bLabelsFontStyle = style; // Set body labels font style
        bLabelsFontSize = size; // Set body labels font size
    } // End set bLabelsFont
    
} // End class SigPrettyPrint
