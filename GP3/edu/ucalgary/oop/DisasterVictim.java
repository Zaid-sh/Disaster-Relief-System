package edu.ucalgary.oop;

public class DisasterVictim extends Person { // DisasterVictim (child) implements Person (parent)
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private final String ENTRY_DATE;
    private Supply[] personalBelongings;
    private String gender;
    private static int counter;
 
    // Constructor
    public DisasterVictim(String firstName, String entry_Date) throws IllegalArgumentException {
        if (!entry_Date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
            throw new IllegalArgumentException("Date of birth entered incorrectly.");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = entry_Date;
        this.ASSIGNED_SOCIAL_ID = counter;
        counter++;
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