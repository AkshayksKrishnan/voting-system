package com.example.votingsystem;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class VotingServices {

    static List<Candidate> candidatesList = new ArrayList<>();
    static int id = 1;

    @PostConstruct
    public void intCandidates(){
        candidatesList= new ArrayList<>();
        enterCandidate(new Candidate("Rahul"));
        enterCandidate(new Candidate("Akshay"));
        enterCandidate(new Candidate("Anna"));

    }

    public Candidate enterCandidate(Candidate candidate) {
        if (checkCandidate(candidate.getName())) {
            candidate.setId(id);
            id++;
            candidate.setVotes(0);
            candidatesList.add(candidate);
        }
        return candidate;
    }

    public boolean checkCandidate(String name){
        for (Candidate candidate : candidatesList) {
            if (candidate.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
    
    public String castVote(String name){
        for (Candidate candidate:candidatesList) {
            if (candidate.getName().equals(name)){
                int votes = candidate.getVotes();
                votes++;
                candidate.setVotes(votes);
                return "One vote added for : "+candidate.getName();
            }
        }
        return "Candidate not Found!!!";
    }

    public String countVote(String name){
        for (Candidate candidate: candidatesList) {
            if (candidate.getName().equals(name)){
                return String.valueOf(candidate.getVotes());
            }
        }
        return "Candidate not found!!!";
    }

    public ArrayList<CandidateDTO> listVote(){
        ArrayList<CandidateDTO> candidateDTOList=  new ArrayList<>();
        for (Candidate candidates: candidatesList) {
            CandidateDTO candidateDTO = new CandidateDTO();
            candidateDTO.setName(candidates.getName());
            candidateDTO.setVote(candidates.getVotes());
            candidateDTOList.add(candidateDTO);
        }
        return candidateDTOList;
    }

    public ArrayList<CandidateDTO> getWinner(){
        CandidateDTO winner = new CandidateDTO();
        winner.setName(candidatesList.get(0).getName());
        winner.setVote(candidatesList.get(0).getVotes());
        for (Candidate candidate:candidatesList) {
            if(winner.getVote()<candidate.getVotes()){
                winner.setName(candidate.getName());
                winner.setVote(candidate.getVotes());
            }
        }
        ArrayList<CandidateDTO> winnerList = new ArrayList<>();
        winnerList.add(winner);
        for (Candidate candidate:candidatesList) {
            if(winner.getVote()==candidate.getVotes() && !winner.getName().equals(candidate.getName())){
                CandidateDTO nextWinner = new CandidateDTO();
                nextWinner.setName(candidate.getName());
                nextWinner.setVote(candidate.getVotes());
                winnerList.add(nextWinner);
            }
        }
        return winnerList;
    }
}
