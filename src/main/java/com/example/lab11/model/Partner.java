package com.example.lab11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Partners")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "Partner_Name")
    private String partnerName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Contact_Information")
    private String contactInformation;
}
