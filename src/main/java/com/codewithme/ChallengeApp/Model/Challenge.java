package com.codewithme.ChallengeApp.Model;

public class Challenge {
    private Long id;
    private String month;
    private String description;

    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
        //return month != null ? month : "Unknown";
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
