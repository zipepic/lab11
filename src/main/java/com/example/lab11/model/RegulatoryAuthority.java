package com.example.lab11.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RegulatoryAuthorities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegulatoryAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "Authority_Name")
    private String authorityName;

    @Column(name = "Contact_Information")
    private String contactInformation;
}

