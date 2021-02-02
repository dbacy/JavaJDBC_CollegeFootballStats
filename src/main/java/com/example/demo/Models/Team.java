package com.example.demo.Models;

public class Team {
    String name;
    int firstPlayed;
    String nickname;
    String conference;



    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getFirstPlayed() { return firstPlayed; }

    public void setFirstPlayed(int firstPlayed) { this.firstPlayed = firstPlayed; }

    public String getNickName() { return nickname; }

    public void setNickName(String nickname) { this.nickname = nickname; }

    public String getConference() { return conference; }

    public void setConference(String conference) { this.conference = conference; }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", firstPlayed=" + firstPlayed +
                ", nickname='" + nickname + '\'' +
                ", conference='" + conference + '\'' +
                '}';
    }

    public Team(String name, int firstPlayed, String nickname, String conference) {
        this.name = name;
        this.firstPlayed = firstPlayed;
        this.nickname = nickname;
        this.conference = conference;
    }

}
