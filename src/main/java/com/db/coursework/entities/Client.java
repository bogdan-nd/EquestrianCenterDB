package com.db.coursework.entities;

import com.db.coursework.entities.enums.HorsemanStatus;
import com.db.coursework.entities.enums.SportsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private String clientToken;
    private String name;
    private int creditMoney;
    private SportsCategory sportCategory;
    private HorsemanStatus horsemanStatus;


    public Client(String name, SportsCategory sportCategory, HorsemanStatus horsemanStatus,String clientToken) {
        this.clientToken = clientToken;
        this.name = name;
        this.creditMoney = 0;
        this.sportCategory = sportCategory;
        this.horsemanStatus = horsemanStatus;
    }

    public void spendMoney(int moneyAmount) {
        creditMoney += moneyAmount;
    }

    public void getMoney(int moneyAmount) {
        creditMoney -= moneyAmount;
    }
}
