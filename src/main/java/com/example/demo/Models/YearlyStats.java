package com.example.demo.Models;

public class YearlyStats {
    int year;
    int rushingYard;
    int receivingYard;
    int kickoffReturnYard;
    float sack;
    int interception;
    int attPAT;
    int madePAT;
    int attFG;
    int madeFG;


    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public int getRushingYard() { return rushingYard; }

    public void setRushingYard(int rushingYard) { this.rushingYard = rushingYard; }

    public int getReceivingYard() { return receivingYard; }

    public void setReceivingYard(int receivingYard) { this.receivingYard = receivingYard; }

    public int getKickoffReturnYard() { return kickoffReturnYard; }

    public void setKickoffReturnYard(int kickoffReturnYard) { this.kickoffReturnYard = kickoffReturnYard; }

    public float getSack() { return sack; }

    public void setSack(float sack) { this.sack = sack; }

    public int getInterception() { return interception; }

    public void setInterception(int interception) { this.interception = interception; }

    public int getAttPAT() { return attPAT; }

    public void setAttPAT(int attPAT) { this.attPAT = attPAT; }

    public int getMadePAT() { return madePAT; }

    public void setMadePAT(int madePAT) { this.madePAT = madePAT; }

    public int getAttFG() { return attFG; }

    public void setAttFG(int attFG) { this.attFG = attFG; }

    public int getMadeFG() { return madeFG; }

    public void setMadeFG(int madeFG) { this.madeFG = madeFG; }

    @Override
    public String toString() {
        return "YearlyStats{" +
                "year=" + year +
                ", rushingYard=" + rushingYard +
                ", receivingYard=" + receivingYard +
                ", kickoffReturnYard=" + kickoffReturnYard +
                ", sack=" + sack +
                ", interception=" + interception +
                ", attPAT=" + attPAT +
                ", madePAT=" + madePAT +
                ", attFG=" + attFG +
                ", madeFG=" + madeFG +
                '}';
    }

    public YearlyStats(int year, int rushingYard,
                       int receivingYard, int kickoffReturnYard,
                       float sack, int interception, int attPAT,
                       int madePAT, int attFG, int madeFG) {
        this.year = year;
        this.rushingYard = rushingYard;
        this.receivingYard = receivingYard;
        this.kickoffReturnYard = kickoffReturnYard;
        this.sack = sack;
        this.interception = interception;
        this.attPAT = attPAT;
        this.madePAT = madePAT;
        this.attFG = attFG;
        this.madeFG = madeFG;
    }
}
