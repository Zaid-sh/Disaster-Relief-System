package edu.ucalgary.oop;

import java.util.regex.*;

public class FamilyRelation {
    // Member Variables
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    // Constructor
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    // Setters
    public void setPersonOne(DisasterVictim personOne) {this.personOne = personOne; }
    public void setRelationshipTo(String relationshipTo) {this.relationshipTo = relationshipTo; }
    public void setPersonTwo(DisasterVictim personTwo) {this.personTwo = personTwo;}

    // Getters
    public DisasterVictim getPersonOne() {return this.personOne; }
    public String getRelationshipTo() {return this.relationshipTo; }
    public DisasterVictim getPersonTwo() {return this.personTwo; }

    // No additional Methods
}
