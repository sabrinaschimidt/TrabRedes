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

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return name; // Retorna o nome do usuário para representação de string.
    }

}

