package com.example.accidentzoneidentifier;

public class DashboardData {
    private String dashid;
    private String numReports;

    public DashboardData(String dashid, String numReports) {
        this.dashid = dashid;
        this.numReports = numReports;
    }

    public String getDashid() {
        return dashid;
    }

    public void setDashid(String dashid) {
        this.dashid = dashid;
    }

    public String getNumReports() {
        return numReports;
    }

    public void setNumReports(String numReports) {
        this.numReports = numReports;
    }
}
