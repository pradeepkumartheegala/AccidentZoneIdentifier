package com.example.accidentzoneidentifier;

public class ProneArea {
    private String areaId;
    private String start;
    private String dest;

    public ProneArea(String areaId, String start, String dest) {
        this.areaId = areaId;
        this.start = start;
        this.dest = dest;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
