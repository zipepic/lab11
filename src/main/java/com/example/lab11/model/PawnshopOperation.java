package com.example.lab11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PawnshopOperations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PawnshopOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "Item_ID")
    private Item item;

    @Column(name = "Transaction_Date")
    private Date transactionDate;

    @Column(name = "Loan_Amount")
    private BigDecimal loanAmount;
}
