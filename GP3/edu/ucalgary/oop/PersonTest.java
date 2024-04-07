package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testSetAndGetFirstName() {
        Person person = new Person("John", "Doe");
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        Person person = new Person("John", "Doe");
        person.setLastName("Doe");
        assertEquals("Doe", person.getLastName());
    }

    @Test
    public void testSetandGetDateOfBirth() {
        Person person = new Person("John", "Doe");
        person.setDateOfBirth("1999-01-01");
        assertEquals("1999-01-01", person.getDateOfBirth());
    }

    @Test
    public void testSetandGetage() {
        Person person = new Person("John", "Doe");
        person.setAge(21);
        assertEquals(Integer.valueOf(21), person.getAge());
    }

    // test set age if date of birth is already set
    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeIfDateOfBirthIsAlreadySet() {
        Person person = new Person("John", "Doe");
        person.setDateOfBirth("1999-01-01");
        person.setAge(25);
        assertEquals(Integer.valueOf(25), person.getAge());
    }

    // test set date of birth if age is already set
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthIfAgeIsAlreadySet() {
        Person person = new Person("John", "Doe");
        person.setAge(25);
        person.setDateOfBirth("1999-01-01");
        assertEquals("1999-01-01", person.getDateOfBirth());
    }
}