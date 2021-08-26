package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = createRandomPassword(defaultPasswordLength);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        System.out.println("Your email is: " + this.email);
    }

    private String setDepartment() {
        System.out.println("\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nENTER DEPARTMENT CODE: ");

        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acc";
        } else {
            return "";
        }
    }

    private String createRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
