package com.example.lab11.repo;

import com.example.lab11.model.RegulatoryAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulatoryAuthorityRepository extends JpaRepository<RegulatoryAuthority, Integer> {
}

