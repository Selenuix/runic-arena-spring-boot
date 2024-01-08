package com.selenuix.runicarena.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CardClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "cardClass")
    private List<Card> cards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
