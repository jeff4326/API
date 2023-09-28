package com.example.ship.model;

public enum ItineraryStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String label;

    ItineraryStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
