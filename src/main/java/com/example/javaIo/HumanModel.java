package com.example.javaIo;

public class HumanModel {
    private String humanAbbreviation;
    private String humanName;
    private String humanTeam;

    public HumanModel() {
    }

    public HumanModel(String racerAbbreviation, String racerName, String racerTeam) {
        this.humanAbbreviation = racerAbbreviation;
        this.humanName = racerName;
        this.humanTeam = racerTeam;
    }

    public String getHumanAbbreviation() {
        return humanAbbreviation;
    }

    public String getHumanName() {
        return humanName;
    }

    public String getHumanTeam() {
        return humanTeam;
    }

    public void setHumanAbbreviation(String humanAbbreviation) {
        this.humanAbbreviation = humanAbbreviation;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public void setHumanTeam(String humanTeam) {
        this.humanTeam = humanTeam;
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanAbbreviation='" + humanAbbreviation + '\'' +
                ", humanName='" + humanName + '\'' +
                ", humanTeam='" + humanTeam + '\'' +
                '}';
    }
}
