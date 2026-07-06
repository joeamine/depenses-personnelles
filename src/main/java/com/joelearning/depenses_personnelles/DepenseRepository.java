package com.joelearning.depenses_personnelles;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {
}
