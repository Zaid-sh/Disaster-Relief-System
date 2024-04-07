package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person implements DateValidator {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer age;

    // Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Default Constructor
    public Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = 21;
    }

    @Override
    public void validateDateFormatBirthday(String date) throws IllegalArgumentException {
        try {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.dateOfBirth = parsedDate;
            this.age = null;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use the format 'yyyy-MM-dd'.");
        }
    }

    @Override
    public void validateDateFormat(String date) throws IllegalArgumentException {
        return;
    }

    // Getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth.toString();
    }

    public Integer getAge() {
        return this.age;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (this.age != null) {
            throw new IllegalArgumentException("Cannot set both age and date of birth");
        } else {
            validateDateFormatBirthday(dateOfBirth);
        }
    }

    public void setAge(Integer age) throws IllegalArgumentException{
        if (this.dateOfBirth != null) {
            throw new IllegalArgumentException("Cannot set both age and date of birth");
        } else {
            this.age = age;
        }
    }
}