package com.example.ship.controller;

import com.example.ship.exception.ResourceNotFoundException;
import com.example.ship.model.User;
import com.example.ship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get user
    @GetMapping("users")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    //get user by ID
     @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found" + userId));
        return ResponseEntity.ok().body(user);

    }

    // Get user profile by ID
    @GetMapping("/users/{id}/profile")
    public ResponseEntity<User> getUserProfile(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        return ResponseEntity.ok().body(user);
    }

    //Save user
    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }
    //update user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long userId,
                                                   @Valid @RequestBody User employeeDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setEmail(employeeDetails.getEmail());
        user.setSurname(employeeDetails.getSurname());
        user.setFirstName(employeeDetails.getFirstName());
        user.setNationality(employeeDetails.getNationality());
        user.setPassportNumber(employeeDetails.getPassportNumber());
        user.setPassword(employeeDetails.getPassword());
        final User updatedEmployee = userRepository.save(user);
        return ResponseEntity.ok(updatedEmployee);
    }
    //delete user
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :  " + employeeId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
