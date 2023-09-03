package rockpaperscissors;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Optional;

public class Game implements PlayGame {
    public static void main(String[] args) {

        Game game = new Game();

        ArrayList<String> winningCombos = new ArrayList<>();
        winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Scissors"))));
        winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Rock"))));
        winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Paper"))));

        ArrayList<String> losingCombos = new ArrayList<>();
        losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Paper"))));
        losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Scissors"))));
        losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Rock"))));


        game.startIntro(winningCombos, losingCombos);

    }



    @Override
    public void startIntro(ArrayList<String> winningCombos, ArrayList<String> losingCombos) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter name of Player 1.");

        Scanner startIntroScanner = new Scanner(System.in);

        User player1 = new User(0, 0, 0, "", "Player 1");
        User player2 = new User(0, 0, 0, "", "Player 2");

        String player1Name = startIntroScanner.nextLine();

        player1.setName(player1Name);
        System.out.println("Hi " + player1.getName() + "! Let's play!");

        getOpponentChoice(player1, player2, winningCombos, losingCombos);
    }


    @Override
    public void getOpponentChoice(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        System.out.println("Choose your opponent. Type 'Computer' or 'Player 2'.");
        Scanner opponentChoiceScanner = new Scanner(System.in);
        String opponentChoice = opponentChoiceScanner.nextLine();

        if (opponentChoice.equalsIgnoreCase("Computer")) {

            System.out.println("You've chosen to play against the computer.");
            System.out.println("Player 1, you're up first! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

            startGame(player1, player2, winningCombos, losingCombos);

        } else if (opponentChoice.equalsIgnoreCase("Player 2")) {

            System.out.println("You've chosen to play against a friend.");
            // start2PlayerGame(player1);
            start2PlayerGame(player1, player2, winningCombos, losingCombos);

        } else {

            System.out.println("You must choose between 'Computer' and 'Player2'. Please enter your choice.");
            getOpponentChoice(player1, player2, winningCombos, losingCombos);

        }
    }


    public void startGame(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        Scanner startGameScanner = new Scanner(System.in);
        String player1Choice = startGameScanner.nextLine();

        if ( player1Choice.equalsIgnoreCase("Rock") || player1Choice.equalsIgnoreCase("Paper") || player1Choice.equalsIgnoreCase("Scissors") ) {

            player1.setChoice(player1Choice);
            System.out.println("You chose " + player1.getChoice() + "! Computer's turn.");

            Computer computer = new Computer(0, 0, 0, "", "Computer");

            String computerChoice = computer.makeRandomChoice();

            computer.setChoice(computerChoice);
            System.out.println("Computer chose " + computerChoice);

            ArrayList<String> currentGameStats = new ArrayList<>();
            currentGameStats.add(String.valueOf(new ArrayList<String>(Arrays.asList(player1.getChoice(), computer.getChoice()))));

            // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
            ArrayList<Object> gameHistory = new ArrayList<>();


            if (currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(2))) {

                int player1Wins = player1.getWins() + 1;
                player1.setWins(player1Wins);

                int player1Points = player1.getPoints() + 1;
                player1.setPoints(player1Points);

                System.out.println(player1.getName() + " wins! Congratulations!");

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                // Move optional outside of if/else statement so it only displays (isPresent) if player1 wins, otherwise set to .Empty()
                String player1WinMsg = player1.getName() + " Wins: " + player1.getWins() + " | Points: " + player1.getPoints();
                Optional<String> optionalPlayer1WinMsg = Optional.ofNullable(player1WinMsg);

                if (optionalPlayer1WinMsg.isPresent()) {
                    System.out.println(optionalPlayer1WinMsg);
                }

                playAgain(winningCombos, losingCombos);

            } else if (currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(2))){

                System.out.println("Sorry, Computer wins! You lose!");

                int computerWins = computer.getWins() + 1;
                computer.setWins(computerWins);

                int computerPoints = computer.getPoints() + 1;
                computer.setPoints(computerPoints);

                String computerWinMsg = "Computer Wins: " + computer.getWins() + " | Computer Points: " + computer.getPoints();
                System.out.println(computerWinMsg);

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                playAgain(winningCombos, losingCombos);

            } else if (player1Choice.equalsIgnoreCase(computerChoice)) {

                System.out.println("It's a tie!");
                /*

                   int player1Ties = player1.getTies() + 1;
                   player1.setTies(player1Ties);
                   System.out.println(player1.getTie());

                   int computerTies = computer.getTies() + 1;
                   computer.setTies(computerTies);
                   System.out.println(computer.getTies());

                 */

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                playAgain(winningCombos, losingCombos);
            }

        } else {

            System.out.println("You must enter 'Rock', 'Paper', or 'Scissors'. Please enter your choice.");
            startGame(player1, player2, winningCombos, losingCombos);
        }
    }


    @Override
    public void playAgain(ArrayList<String> winningCombos, ArrayList<String> losingCombos) {
        System.out.println("Would you like to play again? Enter 'Yes' or 'No'.");

        Scanner playAgainScanner = new Scanner(System.in);
        String playAgainInput = playAgainScanner.nextLine();

        if (playAgainInput.equalsIgnoreCase("Yes")) {
            startIntro(winningCombos, losingCombos);

        } else if (playAgainInput.equalsIgnoreCase("No")) {
            System.out.println("Ok, thanks for playing!");

        } else {
            System.out.println("Invalid input. You must enter 'Yes' or 'No'.");
            playAgain(winningCombos, losingCombos);
        }
    }


    // Finish logic for this method
    @Override
    public void start2PlayerGame(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        System.out.println("Enter name of Player 2.");

        Scanner twoPlayerScanner = new Scanner(System.in);
        String player2Name = twoPlayerScanner.nextLine();

        player2.setName(player2Name);
        System.out.println("Hi " + player2.getName() + ", Let's play!");

        System.out.println(player1.getName() + ", you're up first! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");
        String player1Choice = twoPlayerScanner.nextLine();

        if ( player1Choice.equalsIgnoreCase("Rock") || player1Choice.equalsIgnoreCase("Paper") || player1Choice.equalsIgnoreCase("Scissors") ) {

            player1.setChoice(player1Choice);
            System.out.println("You chose " + player1.getChoice() + "! " + player2.getName() + "'s turn.");
            System.out.println(player2.getName() + ", you're up! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

            String player2Choice = twoPlayerScanner.nextLine();
            player2.setChoice(player2Choice);
            System.out.println(player2.getName() + " chose " + player2.getChoice() + "!");

            ArrayList<String> currentGameStats = new ArrayList<>();
            currentGameStats.add(String.valueOf(new ArrayList<String>(Arrays.asList(player1.getChoice(), player2.getChoice()))));


            // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
            ArrayList<Object> gameHistory = new ArrayList<>();


            if (currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(2))) {

                int player1Wins = player1.getWins() + 1;
                player1.setWins(player1Wins);

                int player1Points = player1.getPoints() + 1;
                player1.setPoints(player1Points);

                System.out.println(player1.getName() + " wins! Congratulations!");

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                String player1WinMsg = player1.getName() + "'s Game Stats: Wins: " + player1.getWins() + " | Points: " + player1.getPoints();
                System.out.println(player1WinMsg);

                playAgain(winningCombos, losingCombos);

            } else if (currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(2))){

                System.out.println("Sorry, " + player2.getName() + " wins! You lose!");

                int player2Wins = player2.getWins() + 1;
                player2.setWins(player2Wins);

                int player2Points = player2.getPoints() + 1;
                player2.setPoints(player2Points);

                String player2WinMsg = player2.getName() + "'s Game Stats: Wins: " + player2.getWins() + " | Points: " + player2.getPoints();
                System.out.println(player2WinMsg);

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                playAgain(winningCombos, losingCombos);

            } else if (player1Choice.equalsIgnoreCase(player2Choice)) {

                System.out.println("It's a tie!");
                    /*

                       int player1Ties = player1.getTies() + 1;
                       player1.setTies(player1Ties);
                       System.out.println(player1.getTie());

                       int computerTies = computer.getTies() + 1;
                       computer.setTies(computerTies);
                       System.out.println(computer.getTies());

                     */

                // Make currentGameStats a List/Collection and use a lambda expression to stream/map contents to gameHistory before clearing currentGameStats
                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                playAgain(winningCombos, losingCombos);
            }

        } else {

            System.out.println("You must enter 'Rock', 'Paper', or 'Scissors'. Please enter your choice.");
            startGame(player1, player2, winningCombos, losingCombos);
        }

    }



}