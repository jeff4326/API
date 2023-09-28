package com.example.ship.controller;

import com.example.ship.exception.ResourceNotFoundException;
import com.example.ship.model.Itinerary;
import com.example.ship.repository.ItineraryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ItineraryController {

    @Autowired
    private ItineraryRepository itineraryRepository;

    //get user
    @GetMapping("itineraries")
    public List<Itinerary> getAllItineraries(){
        return this.itineraryRepository.findAll();
    }
    //get user by ID
    @GetMapping("/itineraries/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable(value = "id") Long itineraryId)
            throws ResourceNotFoundException{
        Itinerary itinerary= itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found for id :  " + itineraryId));
        return ResponseEntity.ok().body(itinerary);

    }
    //Save user
    @PostMapping("itineraries")
    public Itinerary createItinerary(@RequestBody Itinerary itinerary){
        return this.itineraryRepository.save(itinerary);
    }

    //Retrieve user itinerary
    @GetMapping("/users/{userId}/itineraries")
    public List<Itinerary> getUserItineraries(@PathVariable(value = "user_id") Long userId) {
        // Query the database to retrieve itineraries for the user
        List<Itinerary> itineraries = itineraryRepository.findByUserId(userId);
        return itineraries;
    }

    //update user
    @PutMapping("/itineraries/{id}")
    public ResponseEntity<Itinerary> updateEmployee(@PathVariable(value = "id") Long itineraryId,
                                               @Valid @RequestBody Itinerary itineraryDetails) throws ResourceNotFoundException {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + itineraryDetails));

        itinerary.setUser(itineraryDetails.getUser());
        itinerary.setStartLocation(itineraryDetails.getStartLocation());
        itinerary.setEndLocation(itineraryDetails.getEndLocation());
        itinerary.setTravelDate(itineraryDetails.getTravelDate());
        itinerary.setStatus(itineraryDetails.getStatus());
        itinerary.setAvailableSpace(itineraryDetails.getAvailableSpace());
        final Itinerary updatedItinerary = itineraryRepository.save(itinerary);
        return ResponseEntity.ok(updatedItinerary);
    }
    //delete user
    @DeleteMapping("/itineraries/{id}")
    public Map<String, Boolean> deleteItineraries(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Itinerary itinerary = itineraryRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :  " + employeeId));

        itineraryRepository.delete(itinerary);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
