package com.example.lab11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;

    @Column(name = "Item_Name")
    private String itemName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Photos")
    private String photos;

    @Column(name = "Price")
    private BigDecimal price;
}

