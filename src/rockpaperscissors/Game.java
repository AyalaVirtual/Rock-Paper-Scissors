package rockpaperscissors;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class Game {
    public static void main(String[] args) {

        Game game1 = new Game();

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter name of Player 1.");

        Scanner scanner = new Scanner(System.in);
        String player1Name = scanner.nextLine();
        User player1 = new User(player1Name, 0, 0, 0, "");

        System.out.println("Hi " + player1.getName() + "! Choose your opponent. Type 'Computer' or 'Player 2'.");
        String opponentChoice = scanner.nextLine();

        if (opponentChoice.equalsIgnoreCase("Computer")) {
            System.out.println("You've chosen to play against the computer. Let's play!");

            Computer computer = new Computer("Computer", 0, 0, 0, "");

            // game1.playSoloGame();

            System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
            String player1Choice = scanner.nextLine();

            player1.setChoice(player1Choice);
            System.out.println("You chose " + player1Choice);




            /* if (player1Choice.equalsIgnoreCase("Rock")) {
                player1.setChoice("Rock");
                System.out.println("You chose 'Rock'.");
            } */


        } else if (opponentChoice.equalsIgnoreCase("Player 2")) {
            System.out.println("Enter name of Player 2.");
            String player2Name = scanner.nextLine();
            User player2 = new User(player2Name, 0, 0, 0, "");
            System.out.println("You've chosen to play against a friend. Let's play!");
            // game1.play2PlayerGame();
        }

    }




    /* public void playSoloGame() {
        System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
        String Player1Choice = User :: getChoice;
    } */


    public void play2PlayerGame() {
        System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
        // String Player1Choice = player1.getMove();


    }

}