package rockpaperscissors;

public class User extends Player /* implements HumanPlayer */ {


    public User(String name, int wins, int losses, int points, String choice) {
        super(name, wins, losses, points, choice);


    }



    /*

    @Override
    public void chooseRock() {
        User.setChoice("Rock");
    }

    @Override
    public void choosePaper() {
        User.setChoice("Paper");
    }

    @Override
    public void chooseScissors() {
        User.setChoice("Scissors");
    }

    */



}
