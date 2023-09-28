package com.example.ship.controller;


import com.example.ship.exception.ResourceNotFoundException;
import com.example.ship.model.Transaction;
import com.example.ship.repository.ItineraryRepository;
import com.example.ship.repository.ShippingRepository;
import com.example.ship.repository.TransactionRepository;
import com.example.ship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a transaction for shipping
    @PostMapping("transactions")
    public Transaction transaction(@RequestBody Transaction transaction){
        return this.transactionRepository.save(transaction);
    }

    //Get all transactions
    @GetMapping("transactions")
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    //Get all transactions by id
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") Long transactionId)
            throws ResourceNotFoundException{
        Transaction transaction= transactionRepository.findById(transactionId)
                .orElseThrow(()-> new ResourceNotFoundException("Transaction not found for id : " + transactionId));
        return ResponseEntity.ok().body(transaction);

    }
    //Retrieve user transaction
    @GetMapping("/transactions/users/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable Long userId) {
        // Query the database to retrieve transactions for the user
        return transactionRepository.findByDeliveryUserId(userId);
    }


        //Delete transaction
    @DeleteMapping("/transactions/{id}")
    public Map<String, Boolean> deleteTransaction(@PathVariable(value = "id") Long transactionId)
            throws ResourceNotFoundException {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + transactionId));

        transactionRepository.delete(transaction);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
