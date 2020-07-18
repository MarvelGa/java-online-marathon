package com.softserve.itacademy.model;

import java.util.List;

public class ErrorObj {

    private String firstName;
    private String lastName;

    private List<String> errorMessages;
    private String inputError = "";
    private String errorAlreadyExist = "";
    private String errorNotFoundPerson = "";
    private boolean isError = false;


    public String getErrorNotFoundPerson() {
        return errorNotFoundPerson;
    }

    public void setErrorNotFoundPerson(String firstName, String lastName) {
        this.errorNotFoundPerson = "Person with name " + "'" + firstName + " " + lastName + "'" + " not found in Address Book";
    }

    public String getInputError() {
        return inputError;
    }

    public void setInputError() {
        this.inputError = "Fill in each of the following fields";
    }

    public String getErrorAlreadyExist() {
        return errorAlreadyExist;
    }

    public void setErrorAlreadyExist() {
        this.errorAlreadyExist = "An error occurred! Please try again!";
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
