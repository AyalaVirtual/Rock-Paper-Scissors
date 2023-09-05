package rockpaperscissors;

import java.util.ArrayList;

public interface PlayGame {

    void startIntro(ArrayList<String> winningCombos, ArrayList<String> losingCombos, User player1, User player2);
    void getOpponentChoice(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void startGame(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void playAgain(ArrayList<String> winningCombos, ArrayList<String> losingCombos);
    void start2PlayerGame(User player1, User player2, ArrayList<String> winningCombos, ArrayList<String> losingCombos);

}