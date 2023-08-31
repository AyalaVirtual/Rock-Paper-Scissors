package rockpaperscissors;

// import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class Game implements PlayGame {
    public static void main(String[] args) {

        Game game1 = new Game();


        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter name of Player 1.");

        Scanner scanner = new Scanner(System.in);

        // Make player names optionals
        String player1Name = scanner.nextLine();
        User player1 = new User(player1Name, 0, 0, 0, "");

        System.out.println("Hi " + player1.getName() + "!");



        /* System.out.println("Choose your opponent. Type 'Computer' or 'Player 2'.");
        String opponentChoice = scanner.nextLine();

        if (opponentChoice.equalsIgnoreCase("Computer")) {
            System.out.println("You've chosen to play against the computer. Let's play!");

         */



        // Make this a separate function or implement from interface and try to turn this into a try/catch

            /*

            Computer computer = new Computer("Computer", 0, 0, 0, "");

            ArrayList<String> possibleChoices = new ArrayList<>();
            possibleChoices.add("Rock");
            possibleChoices.add("Paper");
            possibleChoices.add("Scissors");


            System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
            String player1Choice = scanner.nextLine();


            if (player1Choice.equalsIgnoreCase(possibleChoices.get(0)) || player1Choice.equalsIgnoreCase(possibleChoices.get(1)) || player1Choice.equalsIgnoreCase(possibleChoices.get(2))) {
                player1.setChoice(player1Choice);
                System.out.println("You chose " + player1Choice + "! Computer's turn.");
                // int randomNum = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

                Random random = new Random();
                // Sets the upper bound to generate random numbers in specific range
                int upperbound = 3;
                // Generates random values from 0 - 2 using nextInt()
                int randomNum = random.nextInt(upperbound);

                String computerChoice = possibleChoices.get(randomNum);
                System.out.println("Computer chose " + computerChoice);

                ArrayList<String> winningCombos = new ArrayList<>();
                winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Scissors"))));
                winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Paper"))));
                winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Rock"))));

                System.out.println(winningCombos);


                ArrayList<String> losingCombos = new ArrayList<>();
                losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Paper"))));
                losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Scissors"))));
                losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Rock"))));

                System.out.println(losingCombos);


                // if (player1Choice)


            } else {
                System.out.println("You must enter 'Rock', 'Paper', or 'Scissors'. Please enter your choice.");

                // Make this entire if/else statement a function outside main method or in interface to call again after above line.
            }

            */

        /*

        } else if (opponentChoice.equalsIgnoreCase("Player 2")) {
            System.out.println("Enter name of Player 2.");
            String player2Name = scanner.nextLine();
            User player2 = new User(player2Name, 0, 0, 0, "");
            System.out.println("You've chosen to play against a friend. Let's play!");
            // game1.play2PlayerGame();
        }

         */

    }




    /* public void playSoloGame() {
        System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
        String Player1Choice = User :: getChoice;
    } */


    public void play2PlayerGame() {
        System.out.println("Player 1, what do you choose? Type 'Rock', 'Paper', or 'Scissors'.");
        // String Player1Choice = player1.getMove();
    }


    @Override
    public void getOpponentChoice() {
        System.out.println("Choose your opponent. Type 'Computer' or 'Player 2'.");
        Scanner scanner = new Scanner(System.in);
        String opponentChoice = scanner.nextLine();

        if (opponentChoice.equalsIgnoreCase("Computer")) {
            System.out.println("You've chosen to play against the computer. Let's play!");


        } else if (opponentChoice.equalsIgnoreCase("Player 2")) {
            System.out.println("Enter name of Player 2.");

            // Make player names optionals
            String player2Name = scanner.nextLine();
            User player2 = new User(player2Name, 0, 0, 0, "");
            System.out.println("You've chosen to play against a friend. Let's play!");
            // game1.play2PlayerGame();


        }
    }


    @Override
    public void getUserChoice() {

        ArrayList<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("Rock");
        possibleChoices.add("Paper");
        possibleChoices.add("Scissors");

        Scanner playerChoiceScanner = new Scanner(System.in);
        String player1Choice = playerChoiceScanner.nextLine();


        if (player1Choice.equalsIgnoreCase(possibleChoices.get(0)) || player1Choice.equalsIgnoreCase(possibleChoices.get(1)) || player1Choice.equalsIgnoreCase(possibleChoices.get(2))) {
            player1.setChoice(player1Choice);
            System.out.println("You chose " + player1Choice + "! Computer's turn.");
            // int randomNum = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

            Random random = new Random();
            // Sets the upper bound to generate random numbers in specific range
            int upperbound = 3;
            // Generates random values from 0 - 2 using nextInt()
            int randomNum = random.nextInt(upperbound);

            String computerChoice = possibleChoices.get(randomNum);
            System.out.println("Computer chose " + computerChoice);

            ArrayList<String> winningCombos = new ArrayList<>();
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Scissors"))));
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Paper"))));
            winningCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Rock"))));

            System.out.println(winningCombos);


            ArrayList<String> losingCombos = new ArrayList<>();
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Rock", "Paper"))));
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Paper", "Scissors"))));
            losingCombos.add(String.valueOf(new ArrayList<String>(Arrays.asList("Scissors", "Rock"))));

            System.out.println(losingCombos);


            // if (player1Choice)


        } else {
            System.out.println("You must enter 'Rock', 'Paper', or 'Scissors'. Please enter your choice.");
            getUserChoice();
        }
    }



}