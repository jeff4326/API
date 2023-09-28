package com.example.ship.controller;

import com.example.ship.exception.ResourceNotFoundException;
import com.example.ship.model.ShippingRequest;
import com.example.ship.model.ShippingRequestStatus;
import com.example.ship.repository.ShippingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ShippingController {

    @Autowired
    private ShippingRepository shippingRepository;

    //get All shipping
    @GetMapping("shippings")
    public List<ShippingRequest> getAllshipping(){
        List<ShippingRequest> shippingRequests = this.shippingRepository.findAll();
        // Add logging to print the list
        System.out.println("All Shipping Requests: " + shippingRequests);
        return shippingRequests;
    }

    //get shipping by id
    @GetMapping("/shippings/{id}")
    public ResponseEntity<ShippingRequest> getShippingById(@PathVariable(value = "id") Long shippingId )
            throws ResourceNotFoundException {
         ShippingRequest shippingRequest = shippingRepository.findById(shippingId)
                 .orElseThrow(()-> new ResourceNotFoundException("Shipping not found" + shippingId));
         return ResponseEntity.ok().body(shippingRequest);

    }

    //create shipping
    @PostMapping("shippings")
    public ShippingRequest createShipping(@RequestBody ShippingRequest shippingRequest){
        shippingRequest.setStatus(ShippingRequestStatus.DELIVERED);
        return this.shippingRepository.save(shippingRequest);


    }

    //Retrieve user shipping-requested
    @GetMapping("/users/{userId}/shipping")
    public List<ShippingRequest> getUserShippingRequests(@PathVariable("user_id") Long userId) {
        // Query the database to retrieve shipping requests for the user
        List<ShippingRequest> shippingRequests = shippingRepository.findByUserId(userId);
        return shippingRequests;
    }


    //update shipping
    @PutMapping("/shippings/{id}")
    public ResponseEntity<ShippingRequest> updateShipping(@PathVariable(value = "id") Long shippingId,
                                               @Valid @RequestBody ShippingRequest shippingDetails) throws ResourceNotFoundException {
        ShippingRequest shippingRequest = shippingRepository.findById(shippingId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipping not found for this id   : " + shippingId));

        shippingRequest.setUser(shippingDetails.getUser());
        shippingRequest.setPickupAddress(shippingDetails.getPickupAddress());
        shippingRequest.setDeliveryAddress(shippingDetails.getDeliveryAddress());
        shippingRequest.setItemDescription(shippingDetails.getItemDescription());
        shippingRequest.setInstructions(shippingDetails.getInstructions());
        shippingRequest.setStatus(ShippingRequestStatus.ACCEPTED);
        shippingRequest.setRequestDate(shippingDetails.getRequestDate());
        final ShippingRequest updatedShipping = shippingRepository.save(shippingRequest);
        return ResponseEntity.ok(updatedShipping);
    }
    //delete shipping
    @DeleteMapping("/shippings/{id}")
    public Map<String, Boolean> deleteShipping(@PathVariable(value = "id") Long shippingId)
            throws ResourceNotFoundException {
        ShippingRequest shippingRequest = shippingRepository.findById(shippingId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipping not found for this id   : " + shippingId));

        shippingRepository.delete(shippingRequest);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
