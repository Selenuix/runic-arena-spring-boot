package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.PassiveCapability;
import com.selenuix.runicarena.repositories.PassiveCapabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassiveCapabilityService {

    @Autowired
    private PassiveCapabilityRepository passiveCapabilityRepository;

    public List<PassiveCapability> getAllPassiveCapabilities() {
        return passiveCapabilityRepository.findAll();
    }

    public PassiveCapability getPassiveCapabilityById(Integer id) {
        Optional<PassiveCapability> optionalPassiveCapability = passiveCapabilityRepository.findById(id);
        return optionalPassiveCapability.orElse(null);
    }

    public PassiveCapability createPassiveCapability(PassiveCapability passiveCapability) {
        return passiveCapabilityRepository.save(passiveCapability);
    }

    public boolean deletePassiveCapability(Integer id) {
        Optional<PassiveCapability> optionalPassiveCapability = passiveCapabilityRepository.findById(id);

        if (optionalPassiveCapability.isPresent()) {
            passiveCapabilityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
