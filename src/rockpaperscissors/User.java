package rockpaperscissors;

public class User extends Player {
    private String name;


    public User(/* String name, */ int wins, int losses, int points, String choice, String name) {
        super(/* name, */ wins, losses, points, choice);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
