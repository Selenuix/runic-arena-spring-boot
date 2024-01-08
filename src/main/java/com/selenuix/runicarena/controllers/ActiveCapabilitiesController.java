package com.selenuix.runicarena.controllers;

import com.selenuix.runicarena.entities.ActiveCapability;
import com.selenuix.runicarena.services.ActiveCapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/active-capabilities")
public class ActiveCapabilitiesController {

    @Autowired
    private ActiveCapabilityService activeCapabilitiesService;

    @GetMapping
    public ResponseEntity<List<ActiveCapability>> getAllActiveCapabilities() {
        List<ActiveCapability> activeCapabilities = activeCapabilitiesService.getAllActiveCapabilities();
        return new ResponseEntity<>(activeCapabilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiveCapability> getActiveCapabilitiesById(@PathVariable Integer id) {
        ActiveCapability activeCapability = activeCapabilitiesService.getActiveCapabilityById(id);
        if (activeCapability != null) {
            return new ResponseEntity<>(activeCapability, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ActiveCapability> createActiveCapabilities(@RequestBody ActiveCapability activeCapabilities) {
        ActiveCapability createdActiveCapability = activeCapabilitiesService.createActiveCapability(activeCapabilities);
        return new ResponseEntity<>(createdActiveCapability, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActiveCapabilities(@PathVariable Integer id) {
        boolean deleted = activeCapabilitiesService.deleteActiveCapability(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
