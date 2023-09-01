package rockpaperscissors;

public interface PlayGame {
    void startIntro();
    void getOpponentChoice(User player1, User player2);
    void startGame(User player1);
    void playAgain();
    void start2PlayerGame(User player1, User player2);

}