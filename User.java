// Nomes: Níkolas Cavalheiro Gonçalves da Silva,
// Sabrina Renata Gonçalves Schimidt
// Cláudia Magno Pereira de Brito

public class User {
    private String name;
    private String username;
    private String password;
    private boolean online;
    private boolean playing;


    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.online = false;
        playing = false; // Inicialmente, o usuário não está jogando.
    }

    // Método para autenticar o usuário com base no nome de usuário e senha.
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Método para verificar se o usuário está jogando.
    public boolean isPlaying() {
        return playing;
    }

    // Método para definir se o usuário está jogando.
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    // Método para obter o nome do usuário.
    public String getName() {
        return name;
    }

    // Método para obter o nome do usuário.
    public void setName(String name) {
        this.name = name;
    }

    // Método para obter o nome de usuário.
    public String getUsername() {
        return username;
    }

    // Método para definir o nome de usuário.
    public void setUsername(String username) {
        this.username = username;
    }

    // Método para obter a senha do usuário.
    public String getPassword() {
        return password;
    }

    // Método para definir a senha do usuário.
    public void setPassword(String password) {
        this.password = password;
    }

    // Método para verificar se o usuário está online.
    public boolean isOnline() {
        return online;
    }

    // Método para definir se o usuário está online.
    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return name; // Retorna o nome do usuário para representação de string.
    }

}

