package Model;

import java.io.Serializable;

/**
 * Created by kp26842 on 6/30/2016.
 */
public class User extends Person implements Serializable, Comparable<User> {
    String userName;
    String email;
    String phoneNo;
    String passWord;
    String profilePic;
    String confirmPassword;


    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String firstName, String lastName, Long SSN, String DOB, String gender, String userName) {
        super(firstName, lastName, SSN, DOB, gender);
        this.userName = userName;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getDOB() {

        return DOB;
    }

    public void setDOB(String DOB) {

        this.DOB = DOB;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @Override
    public int compareTo(User user) {
        return (this.userName.compareTo(user.userName));

    }

   /* @Override
    public boolean equals(User user){
        return false;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", passWord='" + passWord + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}


