package rockpaperscissors;

public interface PlayGame {

    void getOpponentChoice(User player1, User player2);
    void startGame(User player1);
    void start2PlayerGame(User player1, User player2);

}