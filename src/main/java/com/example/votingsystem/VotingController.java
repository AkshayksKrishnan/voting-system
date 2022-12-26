package com.example.votingsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class VotingController {

    @Autowired
    private VotingServices votingServices;

    @PostMapping("/enterCandidate")
    public String createCandidate(@RequestParam String name){
        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate = votingServices.enterCandidate(candidate);
        if (candidate.getId()>0){
            return "Candidate entered Successfully";
        }else {
            return "Candidate Already exist!!!";
        }
    }

    @PostMapping("/castvote")
    public String castVote(@RequestParam String name){
        return votingServices.castVote(name);
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name){
        return votingServices.countVote(name);
    }

    @GetMapping("/listvote")
    public ArrayList<CandidateDTO> listVote(){
        return votingServices.listVote();
    }

    @GetMapping("getwinner")
    public ArrayList<CandidateDTO> getWinner(){
        return votingServices.getWinner();
    }

}
