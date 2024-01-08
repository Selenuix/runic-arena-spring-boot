package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.ActiveCapability;
import com.selenuix.runicarena.repositories.ActiveCapabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiveCapabilityService {

    @Autowired
    private ActiveCapabilityRepository activeCapabilityRepository;

    public List<ActiveCapability> getAllActiveCapabilities() {
        return activeCapabilityRepository.findAll();
    }

    public ActiveCapability getActiveCapabilityById(Integer id) {
        Optional<ActiveCapability> optionalActiveCapability = activeCapabilityRepository.findById(id);
        return optionalActiveCapability.orElse(null);
    }

    public ActiveCapability createActiveCapability(ActiveCapability activeCapability) {
        return activeCapabilityRepository.save(activeCapability);
    }

    public boolean deleteActiveCapability(Integer id) {
        Optional<ActiveCapability> optionalActiveCapability = activeCapabilityRepository.findById(id);

        if (optionalActiveCapability.isPresent()) {
            activeCapabilityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
