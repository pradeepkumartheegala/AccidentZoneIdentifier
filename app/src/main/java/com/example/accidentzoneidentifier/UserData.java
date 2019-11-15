package com.example.accidentzoneidentifier;

//Storing the user details to the Firebase database
public class UserData {
    private String name,email,password,address,phonenumber;

    public UserData() {
    }

    public UserData(String name, String email, String password, String address, String phonenumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    //getter methods helps to get the data from the firebase
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}

