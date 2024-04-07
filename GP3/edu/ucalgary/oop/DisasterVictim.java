package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public class DisasterVictim extends Person { // DisasterVictim (child) implements Person (parent)
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String gender;
    private ArrayList<String> genderOptions;
    private static int counter;
    private Set<DietaryRestriction> dietaryRestrictions;
    private List<FamilyRelation> relations;

    // Default Constructor
    public DisasterVictim(String firstName, String ENTRY_DATE) {
        super(firstName);
        this.medicalRecords = new ArrayList<MedicalRecord>();
        this.familyConnections = new ArrayList<FamilyRelation>();
        this.personalBelongings = new ArrayList<Supply>();
        this.ASSIGNED_SOCIAL_ID = counter;
        validateDateFormat(ENTRY_DATE);
        counter++;
        this.dietaryRestrictions = new HashSet<>();
        this.relations = new ArrayList<>();

        genderOptions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("GenderOptions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                genderOptions.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Getters
    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public String getDateOfBirth() {
        return super.getDateOfBirth();
    }

    public Integer getAge() {
        return super.getAge();
    }

    public String getComments() {
        return this.comments;
    }

    public MedicalRecord[] getMedicalRecords() {
        return this.medicalRecords;
    }

    public String getEntryDate() {
        return this.ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings() {
        return this.personalBelongings;
    }

    public FamilyRelation[] getFamilyConnections() {
        return this.familyConnections;
    }

    public String getGender() {
        return this.gender;
    }

    // SETTERS
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
        return;
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
        return;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        super.validateDateFormatBirthday(dateOfBirth);
        return;
    }

    // NEW
    public void setAge(Integer age) throws IllegalArgumentException {
        // if date of birth already set, cannot set age
        if (this.dateOfBirth != null) {
            throw new IllegalArgumentException("Cannot set both age and date of birth");
        }

        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        this.age = age;
    }

    public void setComments(String comments) {
        this.comments = comments;
        return;
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
        return;
    }

    public void setPersonalBelongings(Supply[] supplies) {
        this.personalBelongings = supplies;
        return;
    }

    public void setFamilyConnections(FamilyRelation[] relation) {
        this.familyConnections = relation;
        return;
    }

    public void setGender(String gender) {
        this.gender = gender;
        return;
    }

    // OTHER METHODS
    public void addPersonalBelonging(Supply supply) {
        if (this.personalBelongings == null) {
            Supply[] arr = { supply };
            this.personalBelongings = arr;
        } else {
            Supply[] arr = new Supply[this.personalBelongings.length + 1];
            for (int i = 0; i < this.personalBelongings.length; i++) {
                arr[i] = this.personalBelongings[i];
            }
            arr[arr.length - 1] = supply;
            this.personalBelongings = arr;
        }
    }

    public void removePersonalBelonging(Supply supply) {
        int indexToRemove = -1;
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (this.personalBelongings[i] == supply) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Supply[] newArray = new Supply[this.personalBelongings.length - 1];
            System.arraycopy(this.personalBelongings, 0, newArray, 0, indexToRemove);
            System.arraycopy(this.personalBelongings, indexToRemove + 1, newArray, indexToRemove,
                    this.personalBelongings.length - indexToRemove - 1);
            this.personalBelongings = newArray;
        }
    }

    public void addFamilyConnection(FamilyRelation familyConnection) {
        if (this.familyConnections == null) {
            FamilyRelation[] arr = { familyConnection };
            this.familyConnections = arr;
        } else {
            FamilyRelation[] arr = new FamilyRelation[this.familyConnections.length + 1];
            for (int i = 0; i < this.familyConnections.length; i++) {
                arr[i] = this.familyConnections[i];
            }
            arr[arr.length - 1] = familyConnection;
            this.familyConnections = arr;
        }

    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        int indexToRemove = -1;
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (this.familyConnections[i] == familyConnection) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            FamilyRelation[] newArray = new FamilyRelation[this.familyConnections.length - 1];
            System.arraycopy(this.familyConnections, 0, newArray, 0, indexToRemove);
            System.arraycopy(this.familyConnections, indexToRemove + 1, newArray, indexToRemove,
                    this.familyConnections.length - indexToRemove - 1);
            this.familyConnections = newArray;
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {

    }
}