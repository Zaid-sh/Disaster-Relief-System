package edu.ucalgary.oop;

import java.util.regex.*;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    // Constructor
    public Location(String name, String address) {
        // initialize these variables?
        this.name = name;
        this.address = address;
    }

    // Setters
    public void setName(String name) {this.name = name; }
    public void setAddress(String address) {this.address = address; }
    public void setOccupants(DisasterVictim[] occupants) {this.occupants = occupants; }
    public void setSupplies(Supply[] supplies) {this.supplies = supplies; }

    // Other methods
    public void addOccupant(DisasterVictim occupant)
    {

    }

    public void removeOccupant(DisasterVictim occupant) {

    }

    public void addSupply(Supply supply) {

    }

    public void removeSupply(Supply supply) {

    }

    // Getters
    public String getName() { return this.name; } //Duplicate modifier for the method getName in type Location ?
    public String getAddress() { return this.address; }
    public DisasterVictim[] getOccupants() {return this.occupants; }
    public Supply[] getSupplies() { return this.supplies; }
}