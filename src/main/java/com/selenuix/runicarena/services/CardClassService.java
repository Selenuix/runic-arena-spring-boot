package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.CardClass;
import com.selenuix.runicarena.repositories.CardClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardClassService {

    @Autowired
    private CardClassRepository cardClassRepository;

    public List<CardClass> getAllCardClasses() {
        return cardClassRepository.findAll();
    }

    public CardClass getCardClassById(Integer id) {
        Optional<CardClass> optionalCardClass = cardClassRepository.findById(id);
        return optionalCardClass.orElse(null);
    }

    public CardClass createCardClass(CardClass cardClass) {
        return cardClassRepository.save(cardClass);
    }

    public boolean deleteCardClass(Integer id) {
        Optional<CardClass> optionalCardClass = cardClassRepository.findById(id);

        if (optionalCardClass.isPresent()) {
            cardClassRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
