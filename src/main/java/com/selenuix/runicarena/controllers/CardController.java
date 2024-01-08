package com.selenuix.runicarena.controllers;

import com.selenuix.runicarena.entities.Card;
import com.selenuix.runicarena.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // Create
    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity<Iterable<Card>> getAllCards() {
        Iterable<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer id) {
        Card card = cardService.getCardById(id);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Integer id, @RequestBody Card updatedCard) {
        Card card = cardService.updateCard(id, updatedCard);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Integer id) {
        boolean deleted = cardService.deleteCard(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
