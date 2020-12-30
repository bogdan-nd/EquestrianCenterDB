package com.db.coursework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity(name = "Payments")
@NoArgsConstructor
@AllArgsConstructor
public class FinancePayment{
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Client sender;
    @ManyToOne
    private Club receiver;
    private int moneyAmount;

    public FinancePayment(Client sender, Club receiver, int moneyAmount){
        this.sender = sender;
        this.receiver = receiver;
        this.moneyAmount = moneyAmount;
    }
}
