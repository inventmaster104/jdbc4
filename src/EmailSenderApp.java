//import javax.mail.*;
//import javax.mail.internet.*;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList.*;
import java.util.Properties;

public class EmailSenderApp {

    // Database configuration
    private static final String DB_URL = "jdbc:mysql://localhost:3306/email_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Email configuration - USE YOUR GMAIL APP PASSWORD
    private static final String SENDER_EMAIL = "cyclone6527@gmail.com";
    private static final String SENDER_PASSWORD = "ndnj jebb xokk tlqo";

    public static void main(String[] args) {
        System.out.println("===== Java Email Sender Application =====");
        System.out.println("Starting email sending process...\n");

        try {
            // Get emails from database
            System.out.println("Connecting to database...");
            List<String> recipients = getEmailsFromMySQL();

            if (recipients.isEmpty()) {
                System.out.println(" No emails found in database.");
                return;
            }

            System.out.println(" Found " + recipients.size() + " email(s) in database:");
            for (String email : recipients) {
                System.out.println("   - " + email);
            }

            // Send emails
            System.out.println("\n Starting email sending...");
            int sentCount = sendEmailToRecipients(recipients);

            System.out.println("\n Summary:");
            System.out.println("Total recipients: " + recipients.size());
            System.out.println("Successfully sent: " + sentCount);

        } catch (Exception e) {
            System.err.println("\n ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<String> getEmailsFromMySQL() {
        List<String> emails = new ArrayList<>();

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT email FROM contacts")) {

                while (rs.next()) {
                    emails.add(rs.getString("email"));
                }

            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found!");
            System.err.println("Make sure mysql-connector-j-8.0.33.jar is in lib folder");
        }

        return emails;
    }

    private static int sendEmailToRecipients(List<String> recipients) {
        int sentCount = 0;

        // Email content
        String subject = "Welcome to the Team - Alecom";
        String body = """
            Dear Employee,

            We are pleased to inform you that your employment with Alecom has been approved. 
            Your first day of work will be tomorrow.

            Please report to Ethio Telecom office at 2:00 PM. 
            Make sure to bring any required documents or equipment.

            We are excited to have you on board and look forward to working with you. 
            Welcome to the team!

            Best regards,
            Network Engineer
            Company Alecom
            """;

        // SMTP configuration for Gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.debug", "false");  // Change to true for debugging

        try {
            // Create session
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
                }
            });

            // Send to each recipient
            for (String recipient : recipients) {
                try {
                    System.out.print("\nSending to " + recipient + "... ");

                    // Create message
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(SENDER_EMAIL));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                    message.setSubject(subject);
                    message.setText(body);

                    // ========== MISSING LINE ADDED HERE ==========
                    // Send the email!
                    Transport.send(message);


                    System.out.println(" SUCCESS");
                    sentCount++;

                    // Small delay to avoid rate limiting
                    Thread.sleep(2000);

                } catch (MessagingException e) {
                    System.out.println(" FAILED: " + getErrorMessage(e));
                } catch (InterruptedException e) {
                    System.out.println(" Interrupted");
                }
            }

        } catch (Exception e) {
            System.err.println("Fatal error in email sending: " + e.getMessage());
            e.printStackTrace();
        }

        return sentCount;
    }

    private static String getErrorMessage(MessagingException e) {
        String message = e.getMessage();

        if (message.contains("AuthenticationFailedException")) {
            return "Gmail authentication failed. Use App Password (not regular password)";
        } else if (message.contains("Could not connect to SMTP host")) {
            return "Cannot connect to Gmail SMTP. Check internet/firewall";
        } else if (message.contains("535")) {
            return "Invalid credentials. Generate new App Password";
        } else if (message.contains("javax.activation")) {
            return "Missing JAR file. Add activation-1.1.1.jar to lib folder";
        }

        return message;
    }
}