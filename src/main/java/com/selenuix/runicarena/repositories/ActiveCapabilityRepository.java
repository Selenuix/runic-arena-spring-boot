package com.selenuix.runicarena.repositories;

import com.selenuix.runicarena.entities.ActiveCapability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveCapabilityRepository extends JpaRepository<ActiveCapability, Integer> {
}
