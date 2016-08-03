package Model;

/**
 * Created by kp26842 on 6/30/2016.
 */
public class Person {
    String firstName;
    String lastName;
    Long SSN;
    String DOB;
    String gender;

    public Person() {
    }

    public Person(String firstName, String lastName, Long SSN, String DOB, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.DOB = DOB;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getSSN() {
        return SSN;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSSN(Long SSN) {
        this.SSN = SSN;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
