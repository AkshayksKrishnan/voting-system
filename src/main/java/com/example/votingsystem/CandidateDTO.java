package com.example.votingsystem;

public class CandidateDTO {
    private String name;
    private int vote;

    public CandidateDTO() {

    }

    public String getName() {
        return name;
    }

    public int getVote() {
        return vote;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public CandidateDTO(String name, int vote) {
        this.name = name;
        this.vote = vote;
    }
}
