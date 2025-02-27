package com.karsom.car_rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {

    // Key ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    private Long userId;

    // Main Attributes
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("full_name")
    private String fullName = firstName + " " + lastName;

    @JsonProperty("ic_number")
    private String icNumber;

    @JsonProperty("gender")
    private boolean gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    // Contact Details
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("home_address")
    private String homeAddress;


    public Customer(Long userId, String firstName, String lastName, String icNumber, boolean gender, LocalDate birthDate, String phoneNumber, String emailAddress, String homeAddress) {
        this.userId = userId;
        this.icNumber = icNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
    }

    public Customer() {}

    // Getter
    public Long getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getIcNumber() { return icNumber; }
    public String getGender() { return gender ? "Male" : "Female"; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmailAddress() { return emailAddress; }
    public String getHomeAddress() { return homeAddress; }


    //Setter
    public void setUserId(Long userId) { this.userId = userId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setIcNumber(String icNumber) { this.icNumber = icNumber; }
    public void setGender(String gender) {
        this.gender = gender.equalsIgnoreCase("Male");
    }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }



}
