package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface DateValidator {
    void validateDateFormat(String date) throws IllegalArgumentException;

    void validateDateFormatBirthday(String date) throws IllegalArgumentException;
}