package edu.ucalgary.oop;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private final String ENTRY_DATE;
    private Supply[] personalBelongings;
    private String gender;
    private Integer age;
    private static int counter;

    public DisasterVictim(String firstName, String entry_Date) throws IllegalArgumentException {
        if (!entry_Date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
            throw new IllegalArgumentException("Date of birth entered incorrectly.");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = entry_Date;
        this.ASSIGNED_SOCIAL_ID = counter;
        counter++;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        // if age already set, cannot set date of birth
        if (this.age != null) {
            throw new IllegalArgumentException("Cannot set both age and date of birth");
        }

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
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    int date = Integer.parseInt(parts[2]);
                    if (date < 1 || date > 31) {
                        throw new IllegalArgumentException("Invalid date: " + date);
                    }
                }

                else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    int date = Integer.parseInt(parts[2]);
                    if (date < 1 || date > 30) {
                        throw new IllegalArgumentException("Invalid date: " + date);
                    }

                }

                else {
                    int date = Integer.parseInt(parts[2]);
                    if (date < 1 || date > 29) {
                        throw new IllegalArgumentException("Invalid date: " + date);
                    }
                }

            } catch (NumberFormatException exeption) {
                throw new IllegalArgumentException("Invalid date format: " + dateOfBirth, exeption);
            }
        }
        this.dateOfBirth = dateOfBirth;
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
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPersonalBelongings(Supply[] supplies) {
        this.personalBelongings = supplies;
    }

    public void setFamilyConnections(FamilyRelation[] relation) {
        this.familyConnections = relation;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public String getComments() {
        return comments;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public String getGender() {
        return gender;
    }
}