package com.juancarlosmaya.stepdefinition.registerform;

import com.github.javafaker.Faker;

public class RegisterFormUser
{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String ssn;
    private String zip;
    private String user;
    private String password;

    public RegisterFormUser() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        address = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.address().state();
        phone = "301"+ faker.numerify("#######");
        ssn = "10"+faker.numerify("########");
        zip = faker.numerify("######");
        user= firstName+".maya";
        password = "1234567";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }

    public String getZip() {
        return zip;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
