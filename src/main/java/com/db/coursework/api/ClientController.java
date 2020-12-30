package com.db.coursework.api;

import com.db.coursework.api.dto.ClientDTO;
import com.db.coursework.entities.Client;
import com.db.coursework.entities.Horse;
import com.db.coursework.entities.Trainer;
import com.db.coursework.entities.enums.SportsCategory;
import com.db.coursework.services.ClientService;
import com.db.coursework.services.HorseService;
import com.db.coursework.services.TrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final HorseService horseService;
    private final TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Client>> showClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("{clientToken}")
    public ResponseEntity<Client> showClientById(@PathVariable String clientToken){
        try {
            return ResponseEntity.ok(clientService.getByToken(clientToken));
        }
        catch (NotFoundException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("{clientToken}/suitable-horses")
    public ResponseEntity<List<Horse>> getSuitableHorse(@PathVariable String clientToken) {
        try {
            Client client = clientService.getByToken(clientToken);
            return ResponseEntity.ok(horseService.findSuitable(client.getHorsemanStatus()));
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("{clientToken}/suitable-trainers")
    public ResponseEntity<List<Trainer>> getSuitableTrainer(@PathVariable String clientToken){
        try {
            Client client = clientService.getByToken(clientToken);
            return ResponseEntity.ok(trainerService.getSuitable(client.getSportCategory()));
        }
        catch (NotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody ClientDTO clientDTO) {
        Client newClient = new Client(clientDTO.getName(), clientDTO.getSportsCategory(),
                clientDTO.getHorsemanStatus(), clientDTO.getClientToken());

        return ResponseEntity.ok(clientService.saveClient(newClient));
    }
}
