package com.abhishekshah.railconnect;


public class StudentDetails {


    private String status;
    private String uid;
    private String time;
    private String source;
    private String destination;
    private String type;
    private String delay;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public StudentDetails(String status, String uid, String time, String source, String destination, String type, String delay) {

        this.status = status;
        this.uid = uid;
        this.time = time;
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.delay = delay;
    }
}