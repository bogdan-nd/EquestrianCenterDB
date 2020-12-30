package com.db.coursework.api;

import com.db.coursework.entities.Club;
import com.db.coursework.services.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("club")
@AllArgsConstructor
public class ClubController {
    private final ClubService clubAccountService;

    @GetMapping
    public ResponseEntity<Club> getClub() {
        return ResponseEntity.ok(clubAccountService.getAccount());
    }
}
