package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.Card;
import com.selenuix.runicarena.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    // Create
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    // Read
    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Integer id) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        return optionalCard.orElse(null);
    }

    // Update
    public Card updateCard(Integer id, Card updatedCard) {
        Optional<Card> optionalExistingCard = cardRepository.findById(id);

        if (optionalExistingCard.isPresent()) {
            Card existingCard = optionalExistingCard.get();
            // Update fields based on your needs
            existingCard.setName(updatedCard.getName());
            existingCard.setImage(updatedCard.getImage());
            existingCard.setPower(updatedCard.getPower());

            return cardRepository.save(existingCard);
        } else {
            return null;
        }
    }

    // Delete
    public boolean deleteCard(Integer id) {
        Optional<Card> optionalCard = cardRepository.findById(id);

        if (optionalCard.isPresent()) {
            cardRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
