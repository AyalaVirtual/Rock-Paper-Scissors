package rockpaperscissors;

import java.util.Scanner;

public class User extends Player {
    private String name;


    public User(int wins, int losses, int points, int ties, String choice, String name) {
        super(wins, losses, points, ties, choice);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void validateChoice() {
        Scanner validChoiceScanner = new Scanner(System.in);
        String playerChoice = validChoiceScanner.nextLine();

        if ( playerChoice.equalsIgnoreCase("Rock") || playerChoice.equalsIgnoreCase("Paper") || playerChoice.equalsIgnoreCase("Scissors") ) {

            setChoice(playerChoice);

        } else {

            System.out.println("Invalid input. You must enter 'Rock', 'Paper', or 'Scissors'. Please try again.");
            validateChoice();
        }
    }


}