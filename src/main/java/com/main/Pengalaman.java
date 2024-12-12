package com.main;

public class Pengalaman {
    private String position;
    private String company;
    private String startDate;
    private String endDate;
    private String description;

    public Pengalaman(String position, String company, String startDate, String endDate, String description) {
        this.position = position;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getPengalamanLengkap() {
        return position + " di " + company + " (" + startDate + " - " + endDate + ")";
    }
}
