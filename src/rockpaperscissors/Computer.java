package rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {
    private static final String name = "Computer";

    public Computer(int wins, int losses, int points, String choice, String name) {
        super(wins, losses, points, choice);

    }

    public String makeRandomChoice() {

        ArrayList<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("Rock");
        possibleChoices.add("Paper");
        possibleChoices.add("Scissors");

        Random random = new Random();
        // Sets the upper bound to generate random numbers in specific range
        int upperbound = 3;
        // Generates random values from 0 - 2 using nextInt()
        int randomNum = random.nextInt(upperbound);

        String computerChoice = possibleChoices.get(randomNum);

        return computerChoice;
    }



}
