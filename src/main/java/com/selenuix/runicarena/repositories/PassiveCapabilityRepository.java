package com.selenuix.runicarena.repositories;

import com.selenuix.runicarena.entities.PassiveCapability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassiveCapabilityRepository extends JpaRepository<PassiveCapability, Integer> {
}
