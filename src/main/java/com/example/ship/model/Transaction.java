package com.example.ship.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipping_request_id",referencedColumnName = "id")
    private ShippingRequest shippingRequest;

    @ManyToOne
    @JoinColumn(name = "itinerary_id",referencedColumnName = "id")
    private Itinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "delivery_user_id",referencedColumnName = "id")
    private User deliveryUser;

    @Column(name = "transaction_date",nullable = false)
    private Date transactionDate;

    @Column(name = "description")
    private String description;

    public Transaction() {
    }

    public Transaction(ShippingRequest shippingRequest, Itinerary itinerary, User deliveryUser, Date transactionDate, String description) {
        this.shippingRequest = shippingRequest;
        this.itinerary = itinerary;
        this.deliveryUser = deliveryUser;
        this.transactionDate = transactionDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShippingRequest getShippingRequest() {
        return shippingRequest;
    }

    public void setShippingRequest(ShippingRequest shippingRequest) {
        this.shippingRequest = shippingRequest;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public User getDeliveryUser() {
        return deliveryUser;
    }

    public void setDeliveryUser(User deliveryUser) {
        this.deliveryUser = deliveryUser;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
