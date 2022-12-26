package com.example.votingsystem;

public class Candidate {

    private int id;
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;

    }

    public Candidate() {

    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
