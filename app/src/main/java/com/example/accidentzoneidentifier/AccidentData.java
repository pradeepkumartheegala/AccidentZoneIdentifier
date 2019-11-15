package com.example.accidentzoneidentifier;

public class AccidentData {
    private String location;
    private String street;
    private String zip;
    private String landmark;

    public AccidentData(String location, String street, String zip, String landmark) {
        this.location = location;
        this.street = street;
        this.zip = zip;
        this.landmark = landmark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
