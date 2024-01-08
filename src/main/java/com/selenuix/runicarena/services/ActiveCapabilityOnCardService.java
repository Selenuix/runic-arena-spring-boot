package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.ActiveCapabilityOnCard;
import com.selenuix.runicarena.repositories.ActiveCapabilityOnCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiveCapabilityOnCardService {

    @Autowired
    private ActiveCapabilityOnCardRepository activeCapabilityOnCardRepository;

    public List<ActiveCapabilityOnCard> getAllActiveCapabilitiesOnCard() {
        return activeCapabilityOnCardRepository.findAll();
    }

    public ActiveCapabilityOnCard getActiveCapabilityOnCardById(Integer id) {
        Optional<ActiveCapabilityOnCard> optionalActiveCapabilityOnCard = activeCapabilityOnCardRepository.findById(id);
        return optionalActiveCapabilityOnCard.orElse(null);
    }

    public ActiveCapabilityOnCard createActiveCapabilityOnCard(ActiveCapabilityOnCard activeCapabilityOnCard) {
        return activeCapabilityOnCardRepository.save(activeCapabilityOnCard);
    }

    public boolean deleteActiveCapability(Integer id) {
        Optional<ActiveCapabilityOnCard> optionalActiveCapabilityOnCard = activeCapabilityOnCardRepository.findById(id);

        if (optionalActiveCapabilityOnCard.isPresent()) {
            activeCapabilityOnCardRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
