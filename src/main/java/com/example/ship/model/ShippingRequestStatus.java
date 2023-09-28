package com.example.ship.model;

public enum ShippingRequestStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String label;

    ShippingRequestStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
