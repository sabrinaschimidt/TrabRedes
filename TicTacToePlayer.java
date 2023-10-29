// Nomes: Níkolas Cavalheiro Gonçalves da Silva,
// Sabrina Renata Gonçalves Schimidt
// Cláudia Magno Pereira de Brito

import java.io.*;
import java.net.Socket;

public class TicTacToePlayer {
    private char symbol;            // Símbolo do jogador (X ou O)
    private Socket socket;          // Soquete para comunicação com o jogador
    private BufferedReader in;      // Leitor para receber mensagens do jogador
    private PrintWriter out;        // Escritor para enviar mensagens ao jogador

    
    public TicTacToePlayer(Socket socket, char symbol) throws IOException {
        this.socket = socket;
        this.symbol = symbol;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Configura leitor de entrada
        out = new PrintWriter(socket.getOutputStream(), true); // Configura escritor de saída
    }

    // Método para obter o símbolo do jogador (X ou O).
    public char getSymbol() {
        return symbol;
    }

    // Método para enviar uma mensagem para o jogador.
    public void sendMessage(String message) {
        out.println(message);
    }

    // Método para receber uma mensagem do jogador.
    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    // Método para fechar os recursos de comunicação com o jogador.
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
