public class Game {
    private User player1;
    private User player2;

    public Game(User player1, User player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public User getPlayer1() {
        return player1;
    }

    public User getPlayer2() {
        return player2;
    }

}