// Nomes: Níkolas Cavalheiro Gonçalves da Silva,
// Sabrina Renata Gonçalves Schimidt
// Cláudia Magno Pereira de Brito

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Essa classe cria e escrete o arquivo de logs com as informações necessárias solicitadas
public class LogWriter {
    private String logFileName;

    public LogWriter(String logFileName) {
        this.logFileName = logFileName;
    }

     // Método para escrever um evento no arquivo de log
    public void writeEvent(String event) {
        // Obtem a data e hora atual no formato específico
        String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        // Combina a data e hora com o evento
        String logEntry = timestamp + ": " + event;
        // Escreve o log no arquivo de log e na saída padrão
        writeToLogFile(logEntry);
        writeToStandardOutput(logEntry);
    }

    // Método para escrever no arquivo de log
    private void writeToLogFile(String logEntry) {
        try (FileWriter fileWriter = new FileWriter(logFileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(logEntry);
            bufferedWriter.newLine();
        } catch (IOException e) {
            // Exibi uma mensagem de erro em caso de erro
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }

    // Método para escrever o log na saída
    private void writeToStandardOutput(String logEntry) {
        System.out.println(logEntry);
    }
}
