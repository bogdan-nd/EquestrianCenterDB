package com.db.coursework.services;

import com.db.coursework.api.dto.TrainingDTO;
import com.db.coursework.entities.*;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateTrainingService {
    private final TrainingService trainingService;
    private final FinanceService financeService;
    private final ClientService clientService;
    private final TrainerService trainerService;
    private final ClubService clubService;
    private final HorseService horseService;

    private final Logger logger = LoggerFactory.getLogger(CreateTrainingService.class);

    public void createTraining(TrainingDTO dto) {
        try {
            Trainer trainer = trainerService.getById(dto.getTrainerId());
            Client client = clientService.getByToken(dto.getClientToken());
            Club club = clubService.getAccount();
            Horse horse = horseService.getById(dto.getHorseId());

            int workoutPrice = trainer.getTrainingPrice();
            client.spendMoney(workoutPrice);
            clientService.saveClient(client);
            club.earnMoney(workoutPrice);
            clubService.saveClub(club);

            FinancePayment payment = new FinancePayment(client, club, workoutPrice);
            financeService.createPayment(payment);
            Training training = new Training(trainer, horse, client, dto.getStartTime());
            trainingService.saveTraining(training);
        } catch (NotFoundException e) {
            logger.warn(e.getMessage());
        }
    }
}
