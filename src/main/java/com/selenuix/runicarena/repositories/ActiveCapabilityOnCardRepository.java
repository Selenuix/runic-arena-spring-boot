package com.selenuix.runicarena.repositories;

import com.selenuix.runicarena.entities.ActiveCapabilityOnCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveCapabilityOnCardRepository extends JpaRepository<ActiveCapabilityOnCard, Integer> {
}
