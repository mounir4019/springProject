
// Java Program to Illustrate Creation Of
// Service Interface

package com.example.springProject.sendEmail;

// Importing required classes
import com.example.springProject.sendEmail.EmailDetails;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}