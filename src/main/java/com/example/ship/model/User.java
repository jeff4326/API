package com.example.ship.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name ="surname")
    private String surname;
    @Column(name= "nationality")
    private String nationality;
    @Column(name ="email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "passport_Number")
    private String passportNumber;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "biography", length = 1000) // Adjust length as needed
    private String biography;

    public User() {
    }

    public User(String firstName, String surname, String nationality, String email, String password, String passportNumber,
                String profilePictureUrl, String contactNumber, String biography) {
        this.firstName = firstName;
        this.surname = surname;
        this.nationality = nationality;
        this.email = email;
        this.password = password;
        this.passportNumber = passportNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.contactNumber = contactNumber;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
