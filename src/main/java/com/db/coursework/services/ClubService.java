package com.db.coursework.services;

import com.db.coursework.entities.Club;
import com.db.coursework.repo.ClubRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClubService {
    private final ClubRepository repository;

    @Autowired
    public ClubService(ClubRepository repository){
        this.repository = repository;
    }


    @Transactional
    public Club getAccount(){
        List<Club> clubs = repository.findAll();
        return clubs.get(0);
    }

    @Transactional
    public void spendMoney(int moneyAmount) throws NotFoundException{
        Club club = getAccount();
        club.spendMoney(moneyAmount);
        repository.save(club);
    }

    @Transactional
    public void saveClub(Club club){
        repository.save(club);
    }

    @Transactional
    public void earnMoney(int moneyAmount) throws NotFoundException{
        Club club = getAccount();
        club.earnMoney(moneyAmount);
        repository.save(club);
    }
}
