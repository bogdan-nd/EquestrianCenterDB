package com.db.coursework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue
    private int id;
    private int moneyAmount;
    private int seedCapital;

    public Club(int seedCapital) {
        this.moneyAmount = 0;
        this.seedCapital = seedCapital;
    }

    public void spendMoney(int wasteAmount) {
        moneyAmount -= wasteAmount;
    }

    public void earnMoney(int earningAmount) {
        moneyAmount += earningAmount;
    }
}

