package org.example.touristguide.model;

public enum Tags {
    RESTAURANT("Restaurant"),
    FORLYSTELSESPARK("Forlystelsespark"),
    NATUROPLEVELSE("Naturoplevelse"),
    KUNST("Kunst"),
    HISTORIE("Historie"),
    LANDSKAB("Landskab"),
    ARKITEKTUR("Arkitektur"),
    UDSIGTSPUNKT("Udsigtspunkt"),
    MUSEUM("Museum");

    private String displayName;

    Tags(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}