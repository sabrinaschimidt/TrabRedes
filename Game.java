// Nomes: Níkolas Cavalheiro Gonçalves da Silva,
// Sabrina Renata Gonçalves Schimidt
// Cláudia Magno Pereira de Brito

public class Game {
    private User player1;
    private User player2;

    public Game(User player1, User player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // obtem jogador 1
    public User getPlayer1() { 
        return player1;
    }

    // obtem jogador 2
    public User getPlayer2() {
        return player2;
    }

}