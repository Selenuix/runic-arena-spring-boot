package com.selenuix.runicarena.controllers;

import com.selenuix.runicarena.entities.PassiveCapability;
import com.selenuix.runicarena.services.PassiveCapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passive-capabilities")
public class PassiveCapabilitiesController {

    @Autowired
    private PassiveCapabilityService passiveCapabilitiesService;

    @GetMapping
    public ResponseEntity<List<PassiveCapability>> getAllPassiveCapabilities() {
        List<PassiveCapability> passiveCapabilities = passiveCapabilitiesService.getAllPassiveCapabilities();
        return new ResponseEntity<>(passiveCapabilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassiveCapability> getPassiveCapabilitiesById(@PathVariable Integer id) {
        PassiveCapability passiveCapability = passiveCapabilitiesService.getPassiveCapabilityById(id);
        if (passiveCapability != null) {
            return new ResponseEntity<>(passiveCapability, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PassiveCapability> createPassiveCapabilities(@RequestBody PassiveCapability passiveCapabilities) {
        PassiveCapability createdPassiveCapability = passiveCapabilitiesService.createPassiveCapability(passiveCapabilities);
        return new ResponseEntity<>(createdPassiveCapability, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassiveCapabilities(@PathVariable Integer id) {
        boolean deleted = passiveCapabilitiesService.deletePassiveCapability(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
