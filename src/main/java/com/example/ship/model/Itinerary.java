package com.example.ship.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="itineraries")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "start_location", nullable = false)
    private String startLocation;

    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @Column(name = "travel_date", nullable = false)
    private Date travelDate;

    @Column(name ="available_space", nullable = false)
    private int availableSpace;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ItineraryStatus status;


    public Itinerary() {
    }

    public Itinerary(User user, String startLocation, String endLocation, Date travelDate,
                     int availableSpace, ItineraryStatus status) {
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.travelDate = travelDate;
        this.availableSpace = availableSpace;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    public ItineraryStatus getStatus() {
        return status;
    }

    public void setStatus(ItineraryStatus status) {
        this.status = status;
    }
}
