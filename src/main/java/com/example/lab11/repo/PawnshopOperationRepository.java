package com.example.lab11.repo;
import com.example.lab11.model.PawnshopOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PawnshopOperationRepository extends JpaRepository<PawnshopOperation, Integer> {
}

