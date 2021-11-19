package com.postserver.Account;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Account {
    private UUID accountNumber;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String bio;
    private String eMail;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate bDay;
    public Account(String userName, String firstName, String lastName, String password, String bio, String eMail, String phoneNumber, int month, int day, int year){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.bio = bio;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        bDay = LocalDate.of(year, month, day);
        this.accountNumber = UUID.randomUUID();
    }
    public Account(String userName, String firstName, String lastName, String password, String bio, String eMail, String phoneNumber, UUID a){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.bio = bio;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        bDay = LocalDate.now();
        this.accountNumber = a;
    }
    public Account(String userName, String firstName, String lastName, String password, String bio, String eMail, String phoneNumber, UUID a, LocalDate lol){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.bio = bio;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        bDay = lol;
        this.accountNumber = a;
    }
    public Account(){
        this.userName = "aBlankUsername";
        this.firstName = "aBlankFirstName";
        this.lastName = "aBlankLastName";
        this.password = "aBlankP@ssw0rd11";
        this.bio = "a Blank bio";
        this.eMail = "aBlankEMail@gmail.com";
        this.phoneNumber = "000-000-0000";
        bDay = LocalDate.now();
        this.accountNumber = UUID.randomUUID();
    }
    public UUID getAccountNumber(){return accountNumber;}
    public String getUserName(){return userName;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    //Usually don't return password because its easy to get/use
    public String getPassword(){return password;}
    public String getBio(){return bio;}
    public String getEMail(){return eMail;}
    public String getPhoneNumber(){return phoneNumber;}
    public LocalDate getbDay() {return bDay;}
    public void seteMail(String eMail) {this.eMail = eMail;}
}