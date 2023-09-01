package rockpaperscissors;

public abstract class Player {
    private int wins;
    private int losses;
    private int points;
    private String choice;

    public Player(int wins, int losses, int points, String choice) {
        this.wins = wins;
        this.losses = losses;
        this.points = points;
        this.choice = choice;
    }


    public int getWins() {
        return this.wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return this.points;
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
