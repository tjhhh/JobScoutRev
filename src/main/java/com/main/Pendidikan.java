package com.main;

public class Pendidikan {
    private String school;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;

    public Pendidikan(String school, String degree, String fieldOfStudy, String startDate, String endDate) {
        this.school = school;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEducation() {
        return school + ", " + degree + " " + fieldOfStudy;
    }
}
