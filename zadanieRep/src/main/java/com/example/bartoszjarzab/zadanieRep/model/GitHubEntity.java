package com.example.bartoszjarzab.zadanieRep.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubEntity {

    @JsonProperty("name")
    private String nameOfRepository;

    @Override
    public String toString() {
        return
                "Name Of Repository='" + nameOfRepository +
                ", Number Of Stargazers='" + numberOfStargazers
                ;
    }

    @JsonProperty("stargazers_count")
    private String numberOfStargazers;

    public String getNameOfRepository() {
        return nameOfRepository;
    }

    public void setNameOfRepository(String nameOfRepository) {
        this.nameOfRepository = nameOfRepository;
    }

    public String getNumberOfStargazers() {
        return numberOfStargazers;
    }

    public void setNumberOfStargazers(String numberOfStargazers) {
        this.numberOfStargazers = numberOfStargazers;
    }
}
