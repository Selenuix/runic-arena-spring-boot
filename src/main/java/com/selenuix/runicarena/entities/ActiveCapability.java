package com.selenuix.runicarena.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class ActiveCapability extends PassiveCapability {
    private String type;

    @OneToMany(mappedBy = "activeCapability")
    private List<ActiveCapabilityOnCard> cards;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
