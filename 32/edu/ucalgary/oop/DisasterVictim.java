package edu.ucalgary.oop;

import java.util.regex.*;

public class DisasterVictim{
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private int assignedSocialID;
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private String entryDate;
    private Supply[] personalBelongings;
    private String gender;
    private int counter;

    public DisasterVictim (String firstName, String entry_Date) throws IllegalArgumentException
    {
        if()
        {

        }
        throw new IllegalArgumentException("Not a valid entry date: "+entry_Date);
        // this.firstName = firstName;
        // this.entryDate = entry_Date;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (!dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            throw new IllegalArgumentException("Not a valid date of birth: " + dateOfBirth);
        } else {
            String[] parts = dateOfBirth.split("-");
            try {
            
            int year = Integer.parseInt(parts[0]);
            if (year < 1900 || year > 2025) {
                throw new IllegalArgumentException("Invalid year: " + year);
            }
            
            
            int month = Integer.parseInt(parts[1]);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month: " + month);
            }

            int date = Integer.parseInt(parts[2]);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("Invalid month: " + month);
            }
            
            } catch (NumberFormatException exeption) {
            throw new IllegalArgumentException("Invalid date format: " + dateOfBirth, exeption);
            }
        }
    }

    public void setComments(String comments) { this.comments = comments; }
    public void setMedicalRecords(MedicalRecord[] medicalRecords) { this.medicalRecords = medicalRecords; }
    public void setPersonalBelongings(Supply[] supplies) { this.personalBelongings = supplies; }
    public void setFamilyConnections(FamilyRelation[] relation) { this.familyConnections = relation; }
    public void setGender(String gender) { this.gender = gender; }

    public void addPersonalBelonging(Supply supply)
    {

    }

    public void removePersonalBelonging(Supply supply)
    {

    }

    public void addFamilyConnection(FamilyRelation familyConnection)
    {

    }

    public void removeFamilyConnection(FamilyRelation familyConnection)
    {

    }

    public void addMedicalRecord(MedicalRecord medicalRecord)
    {

    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getComments() { return comments; }
    public MedicalRecord[] getMedicalRecords() { return medicalRecords; }
    public String getEntryDate() { return entryDate; }
    public int getAssignedSocialID() { return assignedSocialID; }
    public Supply[] getPersonalBelongings() { return personalBelongings; }
    public FamilyRelation[] getFamilyConnections() { return familyConnections; }
    public String getGender() { return gender; }
}