package com.selenuix.runicarena.repositories;

import com.selenuix.runicarena.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
