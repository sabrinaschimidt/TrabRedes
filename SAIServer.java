import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SAIServer {
    private List<User> registeredUsers;    // Lista de usuários registrados
    private List<User> onlineUsers;        // Lista de usuários online
    private Map<User, User> gameSessions;  // Mapeamento de sessões de jogo

    public SAIServer() {
        registeredUsers = new ArrayList<>();
        onlineUsers = new ArrayList<>();
        gameSessions = new HashMap<>();
    }

    // Método para registrar um novo usuário no servidor.
    public void registerUser(User newUser) {
        if (!isUsernameTaken(newUser.getUsername())) {
            registeredUsers.add(newUser);
            System.out.println("Novo usuário registrado com sucesso: " + newUser.getName());
            // Salvar as informações do novo usuário em um arquivo aqui.
        } else {
            System.out.println("Nome de usuário já está em uso. Escolha outro nome de usuário.");
        }
    }

    // Método para verificar se um nome de usuário já está em uso.
    public boolean isUsernameTaken(String username) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Método para autenticar um usuário com nome de usuário e senha.
    public User authenticateUser(String username, String password) {
        for (User user : registeredUsers) {
            if (user.authenticate(username, password)) {
                return user;
            }
        }
        return null;
    }

    // Define um usuário como online.
    public void setUserOnline(User user) {
        if (!onlineUsers.contains(user)) {
            onlineUsers.add(user);
        }
    }

    // Define um usuário como offline.
    public void setUserOffline(User user) {
        onlineUsers.remove(user);
    }

    // Método para listar usuários online.
    public List<User> listOnlineUsers(User requestingUser) {
        List<User> usersOnline = new ArrayList<>();
        for (User user : onlineUsers) {
            if (!user.equals(requestingUser)) {
                usersOnline.add(user);
            }
        }
        return usersOnline;
    }

    // Método para listar usuários jogando.
    public List<User> listUsersPlaying(User requestingUser) {
        List<User> usersPlaying = new ArrayList<>();
        for (User playerA : gameSessions.keySet()) {
            User playerB = gameSessions.get(playerA);
            if (playerA.equals(requestingUser) || playerB.equals(requestingUser)) {
                usersPlaying.add(playerA);
                usersPlaying.add(playerB);
            }
        }
        return usersPlaying;
    }

    // Método para iniciar um jogo.
    public boolean startGame(User playerA, User playerB) {
        if (playerA != null && playerB != null) {
            if (!gameSessions.containsKey(playerA) && !gameSessions.containsValue(playerB)) {
                gameSessions.put(playerA, playerB);
                System.out.println("Jogadores " + playerA.getName() + " e " + playerB.getName() + " estão jogando.");
                playerA.setPlaying(true);
                playerB.setPlaying(true);
                return true;
            }
        }
        return false;
    }

    // Método para encerrar um jogo.
    public void endGame(User playerA, User playerB, User winner) {
        if (gameSessions.containsKey(playerA) && gameSessions.get(playerA).equals(playerB)) {
            gameSessions.remove(playerA);
            playerA.setPlaying(false);
            playerB.setPlaying(false);
            System.out.println("O jogo entre " + playerA.getName() + " e " + playerB.getName() + " terminou.");
            if (winner != null) {
                System.out.println(winner.getName() + " é o vencedor!");
            }
        }
    }
}
