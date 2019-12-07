package com.example.accidentzoneidentifier;

public class AccidentData {
    private String id;
    private String address;
    private String state;
    private String zip;

    public AccidentData(String id, String address, String state, String zip) {
        this.id = id;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
