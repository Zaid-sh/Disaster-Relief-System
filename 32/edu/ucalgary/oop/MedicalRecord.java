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
            throw new IllegalArgumentException("Date of treatment entered incorrectly.");
            }
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    // Setters
    public void setLocation(Location location) { this.location = location; }
    public void setTreatmentDetails(String treatmentDetails) { this.treatmentDetails = treatmentDetails; }
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        
        // if (!dateOfTreatment.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
        //     throw new IllegalArgumentException("Date of treatment entered incorrectly.");
        //     }
        //     this.dateOfTreatment = dateOfTreatment;
        //PREVIOUS CODE - Dont know how to parse this. Feel free to try so we can shorten the code for checking dates overall
        if (!dateOfTreatment.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            throw new IllegalArgumentException("Not a valid date of birth: " + dateOfTreatment);
        } else {
            String[] parts = dateOfTreatment.split("-");
            try {
            
            int year = Integer.parseInt(parts[0]);
            if (year < 1900 || year > 2025) {
                throw new IllegalArgumentException("Invalid year: " + year);
            }
            
            
            int month = Integer.parseInt(parts[1]);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month: " + month);
            }
            if (month==1||month ==3||month==5||month ==7||month==8||month ==10||month ==12){
                int date = Integer.parseInt(parts[2]);
                if (date < 1 || date > 31) {
                    throw new IllegalArgumentException("Invalid date: " + date);
                }
            }

            else if(month==4||month ==6||month==9||month ==11){
                int date = Integer.parseInt(parts[2]);
                if (date < 1 || date > 30) {
                    throw new IllegalArgumentException("Invalid date: " + date);
                }

            }

            else{
                int date = Integer.parseInt(parts[2]);
                if (date < 1 || date > 29) {
                    throw new IllegalArgumentException("Invalid date: " + date);
                }
            }

            } catch (NumberFormatException exeption) {
            throw new IllegalArgumentException("Invalid date format: " + dateOfTreatment, exeption);
            }
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Getters
    public Location getLocation() { return this.location; }
    public String getTreatmentDetails() { return this.treatmentDetails; }
    public String getDateOfTreatment() { return this.dateOfTreatment; }
}
