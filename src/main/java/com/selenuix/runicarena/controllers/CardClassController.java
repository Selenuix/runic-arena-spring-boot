package com.selenuix.runicarena.controllers;

import com.selenuix.runicarena.entities.CardClass;
import com.selenuix.runicarena.services.CardClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards/classes")
public class CardClassController {

    @Autowired
    private CardClassService cardClassService;

    @GetMapping
    public ResponseEntity<List<CardClass>> getAllCardClasses() {
        List<CardClass> cardClasses = cardClassService.getAllCardClasses();
        return new ResponseEntity<>(cardClasses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardClass> getCardClassById(@PathVariable Integer id) {
        CardClass cardClass = cardClassService.getCardClassById(id);
        if (cardClass != null) {
            return new ResponseEntity<>(cardClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CardClass> createCardClass(@RequestBody CardClass cardClass) {
        CardClass createdCardClass = cardClassService.createCardClass(cardClass);
        return new ResponseEntity<>(createdCardClass, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardClass(@PathVariable Integer id) {
        boolean deleted = cardClassService.deleteCardClass(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
