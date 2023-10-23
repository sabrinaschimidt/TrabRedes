import java.io.*;
import java.net.Socket;

public class TicTacToePlayer {
    private char symbol;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public TicTacToePlayer(Socket socket, char symbol) throws IOException {
        this.socket = socket;
        this.symbol = symbol;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public char getSymbol() {
        return symbol;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
