package edu.ucalgary.oop;

import java.util.regex.*;

public class Inquirer {
    // Member variables
    private String firstName;
    private String lastName;
    private String info;
    private String servicesPhone;

    // Constructor
    public Inquirer(String firstName, String lastName, String servicesPhone, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.servicesPhone = servicesPhone;
        this.info = info;
    }

    // No Setters or additional Methods
    // Getters
    public String getFirstName() {return this.firstName; }
    public String getLastName() {return this.lastName; }
    public String getInfo() {return this.info; }
    public String getServicesPhone() {return this.servicesPhone; }
}
