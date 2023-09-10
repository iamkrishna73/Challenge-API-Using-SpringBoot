package com.codewithme.ChallengeApp.Controller;

import com.codewithme.ChallengeApp.Model.Challenge;
import com.codewithme.ChallengeApp.Service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {
    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>>  getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK) ;
    }
    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
       boolean isChallengeAdded = challengeService.addChallenge(challenge);
       if(isChallengeAdded){
           return new ResponseEntity<>("Challenge Added Successfully", HttpStatus.OK);
       } else  {
           return new ResponseEntity<>("Challenge not Added Successfully", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updateChallenge){
        boolean isChallengeUpdate = challengeService.updateChallenge(id, updateChallenge);
        if(isChallengeUpdate){
            return new ResponseEntity<>("Challenge Updated Successfully", HttpStatus.OK);
        } else  {
            return new ResponseEntity<>("Challenge not Updated Successfully", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge deleted Successfully", HttpStatus.NOT_FOUND);
        }
    }

}

