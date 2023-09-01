package rockpaperscissors;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Game implements PlayGame {
    public static void main(String[] args) {

        Game game1 = new Game();


        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter name of Player 1.");

        Scanner scanner = new Scanner(System.in);

        User player1 = new User("Player 1", 0, 0, 0, "");
        User player2 = new User("Player 2", 0, 0, 0, "");

        String player1Name = scanner.nextLine();

        player1.setName(player1Name);
        System.out.println("Hi " + player1.getName() + "! Let's play!");

        game1.getOpponentChoice(player1, player2);

    }



    @Override
    public void getOpponentChoice(User player1, User player2) {

        System.out.println("Choose your opponent. Type 'Computer' or 'Player 2'.");
        Scanner scanner = new Scanner(System.in);
        String opponentChoice = scanner.nextLine();

        if (opponentChoice.equalsIgnoreCase("Computer")) {

            System.out.println("You've chosen to play against the computer.");
            System.out.println("Player 1, you're up first! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

            startGame(player1);

        } else if (opponentChoice.equalsIgnoreCase("Player 2")) {

            System.out.println("You've chosen to play against a friend.");
            System.out.println("Enter name of Player 2.");

            String player2Name = scanner.nextLine();
            // User player2 = new User(player2Name, 0, 0, 0, "");

            start2PlayerGame(player1, player2);

        } else {

            System.out.println("You must choose between 'Computer' and 'Player2'. Please enter your choice.");
            getOpponentChoice(player1, player2);

        }

    }


    public void startGame(User player1) {

        Scanner playerChoiceScanner = new Scanner(System.in);
        String player1Choice = playerChoiceScanner.nextLine();

        if ( player1Choice.equalsIgnoreCase("Rock") || player1Choice.equalsIgnoreCase("Paper") || player1Choice.equalsIgnoreCase("Scissors") ) {

            player1.setChoice(player1Choice);
            System.out.println("You chose " + player1.getChoice() + "! Computer's turn.");

            // int randomNum = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

            Computer computer = new Computer("Computer", 0, 0, 0, "");

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
            computer.setChoice(computerChoice);
            System.out.println("Computer chose " + computerChoice);

            ArrayList<String> currentGameStats = new ArrayList<>();
            currentGameStats.add(String.valueOf(new ArrayList<String>(Arrays.asList(player1.getChoice(), computer.getChoice()))));

            /*
            String[] currentGameStats =  new String[2];
            currentGameStats[0] = player1.getChoice();
            currentGameStats[1] = computer.getChoice();
            */

            ArrayList<Object> gameHistory = new ArrayList<>();

            /*
            String[] winningCombos = new String[3];
            String[][] winningCombos = { {"Rock", "Scissors"}, {"Paper", "Rock"}, {"Scissors", "Paper"} };
            String[][] losingCombos = { {"Rock", "Paper"}, {"Paper", "Scissors"}, {"Scissors", "Rock"} };
            */

            ArrayList<String> winningCombos = new ArrayList<>();
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Scissors"))));
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Rock"))));
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Paper"))));

            // System.out.println(winningCombos);


            ArrayList<String> losingCombos = new ArrayList<>();
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Paper"))));
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Scissors"))));
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Rock"))));


            // System.out.println(losingCombos);


            // if ( currentGameStats.equalsIgnoreCase(winningCombos[0]) || currentGameStats.equalsIgnoreCase(winningCombos[1]) || currentGameStats.equalsIgnoreCase(winningCombos[2]) ) {


            if (currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(2))) {

                int player1Wins = player1.getWins() + 1;
                player1.setWins(player1Wins);

                int player1Points = player1.getPoints() + 1;
                player1.setPoints(player1Points);

                System.out.println(player1.getName() + " wins! Congratulations!");

                gameHistory.add(currentGameStats);
                currentGameStats.clear();

                // Move optional outside of if/else statement so it only displays (isPresent) if player1 wins, otherwise set to .Empty()
                String player1WinMsg = player1.getName() + " Wins: " + player1.getWins() + " | Points: " + player1.getPoints();
                Optional<String> optionalPlayer1WinMsg = Optional.ofNullable(player1WinMsg);

                if (optionalPlayer1WinMsg.isPresent()) {
                    System.out.println(optionalPlayer1WinMsg);
                }

            } else if (currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(2))){

                System.out.println("Sorry, Computer wins! You lose!");

                int computerWins = computer.getWins() + 1;
                computer.setWins(computerWins);

                int computerPoints = computer.getPoints() + 1;
                computer.setPoints(computerPoints);

                String computerWinMsg = "Computer Wins: " + computer.getWins() + " | Computer Points: " + computer.getPoints();
                System.out.println(computerWinMsg);

                gameHistory.add(currentGameStats);
                currentGameStats.clear();

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
                gameHistory.add(currentGameStats);
                currentGameStats.clear();
            }

        } else {

            System.out.println("You must enter 'Rock', 'Paper', or 'Scissors'. Please enter your choice.");
            startGame(player1);
        }
    }


    // Finish logic for this method
    @Override
    public void start2PlayerGame(User player1, User player2) {
        System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
        // String Player1Choice = player1.getMove();
    }



}