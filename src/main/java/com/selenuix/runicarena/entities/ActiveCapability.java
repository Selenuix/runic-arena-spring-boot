package com.selenuix.runicarena.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ActiveCapability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

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
