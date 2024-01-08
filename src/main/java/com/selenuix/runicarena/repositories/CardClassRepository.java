package com.selenuix.runicarena.repositories;

import com.selenuix.runicarena.entities.CardClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardClassRepository extends JpaRepository<CardClass, Integer> {
}
