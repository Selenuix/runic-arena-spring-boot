package com.selenuix.runicarena.entities;

import jakarta.persistence.*;

@Entity
public class ActiveCapabilityOnCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer cardId;

    @ManyToOne
    private ActiveCapability activeCapability;

    public ActiveCapability getActiveCapability() {
        return activeCapability;
    }

    public void setActiveCapability(ActiveCapability activeCapability) {
        this.activeCapability = activeCapability;
    }

}
