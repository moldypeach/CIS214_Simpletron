/**
 *Course:       CIS214 Intro to Java
 *Assignment:   Signature Block Class (Module 2)
 *Author:       Todd Parker
 *Date:         29 Sep 2013
 *Filename:     SigDialogBox.java
 */
package Sig_Block;

import javax.swing.JOptionPane; // import class JOptionPane for dialog box

public class SigDialogBox
{
    private String studentName; // Student Name for this dialog box
    private String studentEmail; // Student Email for this dialog box
    private String courseInfo; // Student course info for this dialog box
    
    // constructor SigDialogBox initializes dialog box variables with String arguments
    public SigDialogBox( String name, String email, String course )
    {
        studentName = name; // Initialize student name
        studentEmail = email; // Initialize student email
        courseInfo = course; // Initialize student course information
    } // End constructor
    
    // Method to SET the signature block name
    public void setStudentName( String name )
    {
        studentName = name; // Store the student name
    } // End method setStudentName
    
    // Method to SET the signature block email
    public void setStudentEmail( String email )
    {
        studentEmail = email; // Store the student email
    } // End method setStudentEmail
    
    // Method to SET the signature block course information
    public void setCourseInfo( String course )
    {
        courseInfo = course; // Store the course information
    } // End method setCourseInfo
    
    // Method to GET the signature block name
    public String getStudentName()
    {
        return studentName;
    } // End method getStudentName
    
    // Method to GET the signature block email
    public String getStudentEmail()
    {
        return studentEmail;
    } // End method getStudentEmail
    
    // Method to GET the signature block course information
    public String getCourseInfo()
    {
        return courseInfo;
    } // End method getCourseInfo
    
    // Display a dialog box with signature block information
    public void displayDialogBox()
    {
        // Create the signature block message to display in dialog box
        String sigMessage = String.format( "Name: %s\n Email: %s\n Course: %s\n", studentName, studentEmail, courseInfo);
        // Display a dialog with signature block information
        JOptionPane.showMessageDialog( null, sigMessage, "Signature Block", JOptionPane.PLAIN_MESSAGE);
    } // End method displayDialogBox
    
} // End class SigDialogBox
