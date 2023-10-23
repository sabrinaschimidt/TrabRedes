import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {
    private String logFileName;

    public LogWriter(String logFileName) {
        this.logFileName = logFileName;
    }

    public void writeEvent(String event) {
        String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String logEntry = timestamp + ": " + event;
        writeToLogFile(logEntry);
        writeToStandardOutput(logEntry);
    }

    private void writeToLogFile(String logEntry) {
        try (FileWriter fileWriter = new FileWriter(logFileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(logEntry);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }

    private void writeToStandardOutput(String logEntry) {
        System.out.println(logEntry);
    }
}
