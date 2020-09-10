package com.mwaoh.leaderboardGads.model;

import com.google.gson.annotations.SerializedName;

public class LearnerHours {

    private String name;
    private int hours;
    private String country;
    @SerializedName("badgeUrl")
    private String url;

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }

}
