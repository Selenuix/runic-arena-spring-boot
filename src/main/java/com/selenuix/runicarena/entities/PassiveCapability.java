package com.selenuix.runicarena.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PassiveCapability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "passiveCapability")
    private List<Card> cards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
