package rockpaperscissors;

import java.util.Optional;

public abstract class Player {
    private String name;
    private int wins;
    private int losses;
    private int points;
    private String choice;

    public Player(String name, int wins, int losses, int points, String choice) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
        this.choice = choice;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    public String getChoice() {
        return this.choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }



}
