package edu.ucalgary.oop;

import java.util.regex.*;

public class MedicalRecord {
    // Member variables
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    // Constructor
    public MedicalRecord (Location location, String treatmentDetails, String dateOfTreatment) {
        
        if (!dateOfTreatment.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
            throw new IllegalArgumentException("Date of birth entered incorrectly.");
            }
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    // Setters
    public void setLocation(Location location) { this.location = location; }
    public void setTreatmentDetails(String treatmentDetails) { this.treatmentDetails = treatmentDetails; }
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        
        if (){

        }
        throw new IllegalArgumentException("Not a valid entry date of treatment: "+dateOfTreatment);        
        // this.dateOfTreatment = dateOfTreatment;
    }

    // Getters
    public Location getLocation() { return this.location; }
    public String getTreatmentDetails() { return this.treatmentDetails; }
    public String getDateOfTreatment() { return this.dateOfTreatment; }
}
