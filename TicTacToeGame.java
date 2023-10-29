// Nomes: Níkolas Cavalheiro Gonçalves da Silva,
// Sabrina Renata Gonçalves Schimidt
// Cláudia Magno Pereira de Brito

import java.util.Arrays;

public class TicTacToeGame {
    private char[][] board;
    private User currentPlayer;
    private boolean gameOver;
    private User playerX; // Representa o jogador X
    private User playerO; // Representa o jogador O

    public TicTacToeGame(User playerX, User playerO, SAIServer saiServer) {
        this.playerX = playerX; // Inicializa o jogador X
        this.playerO = playerO; // Inicializa o jogador O
        board = new char[3][3];
        currentPlayer = playerX; // Começa com o jogador X
        gameOver = false;
        initializeBoard();
    }

    // Inicializa o tabuleiro com espaços em branco (vazio).
    public void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            Arrays.fill(board[row], ' ');
        }
    }

    // Realiza a jogada de um jogador na posição (row, col).
    public boolean makeMove(User player, int row, int col) {
        if (!gameOver && isValidMove(row, col) && player.equals(currentPlayer)) {
            board[row][col] = (currentPlayer == playerX) ? 'X' : 'O'; // Registra a jogada no tabuleiro.
            togglePlayer(); // Alterna para o próximo jogador.
            return true;
        }
        return false;
    }

    // Verifica se a jogada está dentro dos limites do tabuleiro e se a célula está vazia.
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Alterna o jogador atual entre X e O.
    private void togglePlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    // Verifica se o jogo acabou (vencedor, empate ou tabuleiro cheio).
    public boolean isGameOver() {
        return gameOver || isBoardFull() || hasWinner();
    }

    // Verifica se o tabuleiro está completamente preenchido.
    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se há um vencedor nas linhas, colunas e diagonais.
    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                gameOver = true;
                return true; // Uma linha com todas as marcas iguais.
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                gameOver = true;
                return true; // Uma coluna com todas as marcas iguais.
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            gameOver = true;
            return true; // Diagonal principal com todas as marcas iguais.
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            gameOver = true;
            return true; // Diagonal secundária com todas as marcas iguais.
        }
        return false; // Não há vencedor.
    }

    // Retorna o jogador atual (X ou O).
    public User getCurrentPlayer() {
        return currentPlayer;
    }

    // Retorna o estado atual do tabuleiro.
    public char[][] getBoard() {
        return board;
    }

    // Retorna o vencedor, se houver.
    public User getWinner() {
        User winner = (hasWinner()) ? ((currentPlayer == playerX) ? playerO : playerX) : null;
        return winner;
    }
    
    
    
    
}
