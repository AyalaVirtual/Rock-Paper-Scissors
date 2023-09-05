package rockpaperscissors;

import java.util.ArrayList;

public interface PlayGame {

    void startIntro(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void getOpponentChoice(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void startGame(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void playAgain(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void start2PlayerGame(Computer computer, User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
}