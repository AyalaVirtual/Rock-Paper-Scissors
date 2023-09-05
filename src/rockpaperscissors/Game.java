package rockpaperscissors;

import java.util.*;
import java.util.stream.Collectors;

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

        Computer computer = new Computer(0, 0, 0,0, "", "Computer");
        User player1 = new User(0, 0, 0, 0, "", "Player 1");
        User player2 = new User(0, 0, 0, 0, "", "Player 2");

        game.startIntro(computer, player1, player2, winningCombos, losingCombos);
    }


    /**
     *
     * @param winningCombos ArrayList of all possible winning combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @param losingCombos ArrayList of all possible losing combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     *
     * Prints intro message and prompts user/player1 for their name before calling the next method, getOpponentChoice() to determine 1-player or 2-player mode
     */
    @Override
    public void startIntro(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        System.out.println("Welcome to Rock, Paper, Scissors!");

        System.out.println("MAIN MENU");
        System.out.println("==========");
        System.out.println("1. Type 'Computer' to play in 1-player mode.");
        System.out.println("2. Type 'Player 2' to play in 2-player mode.");

        getOpponentChoice(computer, player1, player2, winningCombos, losingCombos);
    }


    /**
     *
     * @param player1 object instance of User Class representing player1
     * @param player2 object instance of User Class representing player2
     * @param winningCombos ArrayList of all possible winning combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @param losingCombos ArrayList of all possible losing combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @throws NoSuchElementException Exception thrown by different accessor methods to indicate that the requested element does not exist
     *
     * Prompts player1 and checks for invalid input before determining if they want to play in 1-player or 2-player mode before calling the corresponding method ( startGame() or start2PlayerGame() )
     */
    @Override
    public void getOpponentChoice(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) throws NoSuchElementException {

        try (Scanner opponentChoiceScanner = new Scanner(System.in)) {

            String opponentChoice = opponentChoiceScanner.nextLine();

            if (opponentChoice.equalsIgnoreCase("Computer")) {

                System.out.println("You've chosen to play against the computer.");
                startGame(computer, player1, player2, winningCombos, losingCombos);

            } else if (opponentChoice.equalsIgnoreCase("Player 2")) {

                System.out.println("You've chosen to play against a friend.");
                start2PlayerGame(computer, player1, player2, winningCombos, losingCombos);

            } else {

                System.out.println("You must choose between 'Computer' and 'Player2'. Please enter your choice.");
                getOpponentChoice(computer, player1, player2, winningCombos, losingCombos);

            }

        } catch (NoSuchElementException noSuchElementException) {

            System.err.println("Caught NoSuchElementException: " + noSuchElementException.getMessage());
        }
    }


    /**
     *
     * @param player1 object instance of User Class representing player1
     * @param player2 object instance of User Class representing player2
     * @param winningCombos ArrayList of all possible winning combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @param losingCombos ArrayList of all possible losing combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     *
     * Starts 1-player mode gameplay, checking that player1's input is valid before adding it to an ArrayList (currentGameStats) and comparing that ArrayList to the ArrayLists of all possible winning and losing combos to determine game outcome, announce winner, and award points before calling another method ( playAgain() ) to determine if players want to continue playing
     */
    public void startGame(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        List<String> gameHistory;

        System.out.println("Enter name of Player 1.");

        Scanner startGameScanner = new Scanner(System.in);
        String player1Name = startGameScanner.nextLine();

        player1.setName(player1Name);
        System.out.println("Hi " + player1.getName() + "! Let's play!");

        System.out.println(player1.getName() + ", you're up first! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

        player1.validateChoice();

        System.out.println("You chose " + player1.getChoice() + "! Computer's turn.");

        String computerChoice = computer.makeRandomChoice();

        computer.setChoice(computerChoice);
        System.out.println("Computer chose " + computerChoice);

        ArrayList<String> currentGameStats = new ArrayList<>();
        currentGameStats.add(String.valueOf(new ArrayList<String>(Arrays.asList(player1.getChoice(), computer.getChoice()))));


        if (currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(2))) {

            int player1Wins = player1.getWins() + 1;
            player1.setWins(player1Wins);

            int player1Points = player1.getPoints() + 1;
            player1.setPoints(player1Points);

            int computerLosses = computer.getLosses() + 1;
            computer.setLosses(computerLosses);

            System.out.println(player1.getName() + " wins! Congratulations!");

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));

            String player1WinMsg = player1.getName() + "'s Wins: " + player1.getWins() + " | Points: " + player1.getPoints();
            Optional<String> optionalPlayer1WinMsg = Optional.ofNullable(player1WinMsg);

            optionalPlayer1WinMsg.ifPresent(System.out::println);

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);

        } else if (currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(2))){

            System.out.println("Sorry, Computer wins! You lose!");

            int computerWins = computer.getWins() + 1;
            computer.setWins(computerWins);

            int computerPoints = computer.getPoints() + 1;
            computer.setPoints(computerPoints);

            int player1Losses = player1.getLosses() + 1;
            player1.setLosses(player1Losses);

            String computerWinMsg = "Computer Wins: " + computer.getWins() + " | Computer Points: " + computer.getPoints();
            Optional<String> optionalComputerWinMsg = Optional.ofNullable(computerWinMsg);

            optionalComputerWinMsg.ifPresent(System.out::println);

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);

        } else if (player1.getChoice().equalsIgnoreCase(computerChoice)) {

            int player1Ties = player1.getTies() + 1;
            player1.setTies(player1Ties);

            int computerTies = computer.getTies() + 1;
            computer.setTies(computerTies);

            System.out.println("It's a tie!");

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));
            currentGameStats.clear();

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);
        }
    }


    /**
     *
     * @param winningCombos ArrayList of all possible winning combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @param losingCombos ArrayList of all possible losing combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     *
     * Prompts player1 and checks for invalid input to determine if they want to continue playing
     */
    @Override
    public void playAgain(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        System.out.println("Would you like to play again? Enter 'Yes' or 'No'.");

        Scanner playAgainScanner = new Scanner(System.in);
        String playAgainInput = playAgainScanner.nextLine();

        if (playAgainInput.equalsIgnoreCase("Yes")) {
            startIntro(computer, player1, player2, winningCombos, losingCombos);

        } else if (playAgainInput.equalsIgnoreCase("No")) {
            System.out.println("Ok, thanks for playing!");

        } else {
            System.out.println("Invalid input. You must enter 'Yes' or 'No'.");
            playAgain(computer, player1, player2, winningCombos, losingCombos);
        }
    }


    /**
     *
     * @param player1 object instance of User Class representing player1
     * @param player2 object instance of User Class representing player2
     * @param winningCombos ArrayList of all possible winning combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     * @param losingCombos ArrayList of all possible losing combinations, with first index of each inner List representing player1's move, and the second index representing the opponent (either computer or player2)
     *
     * Starts 2-player mode gameplay, prompting player2 for their name before prompting players and checking their input is valid before adding it to an ArrayList (currentGameStats) and comparing that ArrayList to the ArrayLists of all possible winning and losing combos to determine game outcome, announce winner, and award points before calling another method ( playAgain() ) to determine if players want to continue playing
     */
    @Override
    public void start2PlayerGame(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos) {

        List<String> gameHistory;

        System.out.println("Enter name of Player 1.");

        Scanner twoPlayerScanner = new Scanner(System.in);

        String player1Name = twoPlayerScanner.nextLine();
        player1.setName(player1Name);
        System.out.println("Hi " + player1.getName() + "! Let's play!");

        System.out.println("Enter name of Player 2.");

        String player2Name = twoPlayerScanner.nextLine();
        player2.setName(player2Name);
        System.out.println("Hi " + player2.getName() + ", Let's play!");

        System.out.println(player1.getName() + ", you're up first! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

        player1.validateChoice();

        System.out.println("You chose " + player1.getChoice() + "! " + player2.getName() + "'s turn.");
        System.out.println(player2.getName() + ", you're up! Enter your choice: 'Rock', 'Paper', or 'Scissors'.");

        player2.validateChoice();

        System.out.println(player2.getName() + " chose " + player2.getChoice() + "!");

        ArrayList<String> currentGameStats = new ArrayList<>();
        currentGameStats.add(String.valueOf(new ArrayList<String>(Arrays.asList(player1.getChoice(), player2.getChoice()))));


        if (currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(winningCombos.get(2))) {

            int player1Wins = player1.getWins() + 1;
            player1.setWins(player1Wins);

            int player1Points = player1.getPoints() + 1;
            player1.setPoints(player1Points);

            int player2Losses = player2.getLosses() + 1;
            player2.setLosses(player2Losses);

            System.out.println(player1.getName() + " wins! Congratulations!");

            String player1WinMsg = player1.getName() + "'s Wins: " + player1.getWins() + " | Points: " + player1.getPoints();
            Optional<String> optionalPlayer1WinMsg = Optional.ofNullable(player1WinMsg);

            optionalPlayer1WinMsg.ifPresent(System.out::println);

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));
            currentGameStats.clear();

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);

        } else if (currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(0)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(1)) || currentGameStats.get(0).equalsIgnoreCase(losingCombos.get(2))){

            System.out.println(player2.getName() + " wins!");

            int player2Wins = player2.getWins() + 1;
            player2.setWins(player2Wins);

            int player2Points = player2.getPoints() + 1;
            player2.setPoints(player2Points);

            int player1Losses = player1.getLosses() + 1;
            player1.setLosses(player1Losses);

            String player2WinMsg = player2.getName() + "'s Game Stats: Wins: " + player2.getWins() + " | Points: " + player2.getPoints();
            Optional<String> optionalPlayer2WinMsg = Optional.ofNullable(player2WinMsg);

            optionalPlayer2WinMsg.ifPresent(System.out::println);

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));
            currentGameStats.clear();

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);

        } else if (player1.getChoice().equalsIgnoreCase(player2.getChoice())) {

            int player1Ties = player1.getTies() + 1;
            player1.setTies(player1Ties);

            int player2Ties = player2.getTies() + 1;
            player2.setTies(player2Ties);

            System.out.println("It's a tie!");

            System.out.println("Player 1 Ties: " + player1.getTies());
            System.out.println("Player 2 Ties: " + player2.getTies());

            gameHistory = currentGameStats.stream().collect(Collectors.toCollection(ArrayList :: new));
            currentGameStats.clear();

            String gameHistoryMsg = "Game History: " + gameHistory;
            System.out.println(gameHistoryMsg);

            playAgain(computer, player1, player2, winningCombos, losingCombos);
        }
    }


}