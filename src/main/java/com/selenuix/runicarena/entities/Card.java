package com.selenuix.runicarena.entities;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String image;

    private Integer power;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "card_class_id")
    private CardClass cardClass;

    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "passive_capability_id")
    private PassiveCapability passiveCapability;

    @ManyToOne
    @JoinColumn(name = "active_capability_id")
    private ActiveCapability activeCapability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public CardClass getCardClass() {
        return cardClass;
    }

    public void setCardClass(CardClass cardClass) {
        this.cardClass = cardClass;
    }

    public PassiveCapability getPassiveCapability() {
        return passiveCapability;
    }

    public void setPassiveCapability(PassiveCapability passiveCapability) {
        this.passiveCapability = passiveCapability;
    }

    public ActiveCapability getActiveCapability() {
        return activeCapability;
    }

    public void setActiveCapability(ActiveCapability activeCapability) {
        this.activeCapability = activeCapability;
    }
}
