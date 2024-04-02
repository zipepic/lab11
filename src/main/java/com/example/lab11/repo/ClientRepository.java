package com.example.lab11.repo;
import com.example.lab11.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Page<Client> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);
}

