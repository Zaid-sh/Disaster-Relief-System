package edu.ucalgary.oop;

import java.util.regex.*;

public class ReliefService {
    // Member Variables
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    // Constructor
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation){
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    // Setters
    public void setInquirer(Inquirer inquirer) {this.inquirer = inquirer; }
    public void setMissingPerson(DisasterVictim missingPerson) {this.missingPerson = missingPerson; }
    public void setDateOfInquiry(String dateOfInquiry) {this.dateOfInquiry = dateOfInquiry; }
    public void setInfoProvided(String infoProvided) {this.infoProvided = infoProvided; }
    public void setLastKnownLocation(Location lastKnownLocation) {this.lastKnownLocation = lastKnownLocation; }

    // Getters
    public Inquirer getInquirer() {return this.inquirer; }
    public DisasterVictim getMissingPerson() {return this.missingPerson; }
    public String getDDateOfInquiry() {return this.dateOfInquiry; }
    public String getInfoProvided() {return this.infoProvided; }
    public Location getLastKnownLocation() {return this.lastKnownLocation; }

    public String getLogDetails() {return null}
    //what do we return for this setter?
    //potentially log details we can get from a value from a diff class?
}
