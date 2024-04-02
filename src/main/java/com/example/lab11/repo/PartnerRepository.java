package com.example.lab11.repo;
import com.example.lab11.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
}

