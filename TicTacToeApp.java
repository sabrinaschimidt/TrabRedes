import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SAIServer saiServer = new SAIServer();

            System.out.println("Bem-vindo ao Jogo da Velha P2P!");

            // Solicitar informações do jogador X
            User authenticatedX = authenticateOrCreateUser(saiServer, scanner, "X");

            // Solicitar informações do jogador O
            User authenticatedO = authenticateOrCreateUser(saiServer, scanner, "O");

            if (authenticatedX != null && authenticatedO != null) {
                TicTacToeGame game = new TicTacToeGame(authenticatedO, authenticatedX, saiServer);

                while (!game.isGameOver()) {
                    User currentPlayer = game.getCurrentPlayer();
                    System.out.println("Jogador " + currentPlayer + ", é sua vez.");
                    printBoard(game.getBoard());

                    int row, col;
                    do {
                        System.out.print("Informe a linha (0, 1, 2): ");
                        row = scanner.nextInt();
                        System.out.print("Informe a coluna (0, 1, 2): ");
                        col = scanner.nextInt();
                    } while (!game.makeMove(currentPlayer, row, col));

                    System.out.println();
                }

                printBoard(game.getBoard());
                char winner = (game.hasWinner()) ? game.getCurrentPlayer().getUsername().charAt(0) : ' ';
                if (winner != ' ') {
                    System.out.println("Jogador " + winner + " venceu!");
                } else {
                    System.out.println("O jogo terminou em empate.");
                }
            } else {
                System.out.println("Erro durante o processo de autenticação/criação de usuários.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro durante a execução.");
        }

        System.out.println("Obrigado por jogar!");
    }

    private static User authenticateOrCreateUser(SAIServer saiServer, Scanner scanner, String playerLabel) {
        User authenticatedUser = null;
    
        while (authenticatedUser == null) {
            System.out.print("Jogador " + playerLabel + ", informe seu nome: "); // Solicitar o nome do jogador
            String name = scanner.nextLine();
            System.out.print("Informe seu nome de usuário: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Informe sua senha: ");
            String inputPassword = scanner.nextLine();
    
            // Tenta autenticar o jogador
            authenticatedUser = saiServer.authenticateUser(inputUsername, inputPassword);
    
            if (authenticatedUser == null) {
                // Se a autenticação falhar, verifica se o nome de usuário já existe.
                if (saiServer.isUsernameTaken(inputUsername)) {
                    System.out.println("Autenticação falhou. Tente novamente.");
                } else {
                    // Se o nome de usuário não existir, cria um novo jogador.
                    System.out.print("Nome de usuário não registrado. Criando um novo usuário...");
                    saiServer.registerUser(new User(name, inputUsername, inputPassword));
                    System.out.println("Novo usuário criado com sucesso.");
                    authenticatedUser = saiServer.authenticateUser(inputUsername, inputPassword);
                }
            }
        }
    
        return authenticatedUser;
    }
    
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
