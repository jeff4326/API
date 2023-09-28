package com.example.ship.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="shipping_requests")
public class ShippingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name= "pickup_address")
    private String pickupAddress;

    @Column(name= "delivery_address")
    private String deliveryAddress;

    @Column(name= "item_description")
    private String itemDescription;

    @Column(name="delivery_instructions")
    private String instructions;

    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private ShippingRequestStatus status;

    @Column(name="request_date")
    private Date requestDate;

    public ShippingRequest() {
    }

    public ShippingRequest(User user, String pickupAddress, String deliveryAddress, String itemDescription,
                           String instructions, ShippingRequestStatus status, Date requestDate) {
        this.user = user;
        this.pickupAddress = pickupAddress;
        this.deliveryAddress = deliveryAddress;
        this.itemDescription = itemDescription;
        this.instructions = instructions;
        this.status = status;
        this.requestDate = requestDate;
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

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public ShippingRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingRequestStatus status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
