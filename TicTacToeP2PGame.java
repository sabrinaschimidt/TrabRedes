import java.util.Scanner;

public class TicTacToeP2PGame {
    private TicTacToeGame game;
    private User playerX;
    private User playerO;
    private SAIServer saiServer;

    public TicTacToeP2PGame(User playerX, User playerO, SAIServer saiServer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.saiServer = saiServer;
        game = new TicTacToeGame(playerX, playerO, saiServer);
    }

    // Inicia o jogo e interage com os jogadores.
    public void startGame() {
        saiServer.startGame(playerX, playerO);
        boolean playerXTurn = true;

        while (!game.isGameOver()) {
            User currentPlayer = playerXTurn ? playerX : playerO;
            displayBoard();

            int row, col;
            do {
                System.out.println(currentPlayer.getName() + ", faça sua jogada (linha e coluna): ");
                row = getPlayerMove("Linha");
                col = getPlayerMove("Coluna");
            } while (!game.makeMove(currentPlayer, row, col));

            playerXTurn = !playerXTurn;
        }

        displayBoard();
        endGame();
    }

    // Solicita ao jogador uma jogada (linha ou coluna).
    private int getPlayerMove(String coordinate) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(coordinate + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                System.out.print(coordinate + ": ");
                scanner.next();
            }
            return scanner.nextInt() - 1;
        }
    }

    // Exibe o estado atual do tabuleiro.
    private void displayBoard() {
        char[][] board = game.getBoard();
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    // Encerra o jogo e exibe o vencedor ou empate.
    private void endGame() {
        displayBoard();
        User winner = game.getWinner();
        saiServer.endGame(playerX, playerO, winner);

        if (winner != null) {
            System.out.println(winner.getName() + " venceu!");
        } else {
            System.out.println("O jogo terminou em empate.");
        }
    }
}
