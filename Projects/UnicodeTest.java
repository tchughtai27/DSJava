import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeTest {
    public static void main(String[] args) {
        try {
            // Use "python" or "python3" as appropriate
            ProcessBuilder processBuilder = new ProcessBuilder("python", "print_unicode.py");

            // Set environment variables to ensure UTF-8 encoding
            processBuilder.environment().put("PYTHONIOENCODING", "utf-8");
            processBuilder.environment().put("PYTHONUTF8", "1");

            // Start the process
            Process process = processBuilder.start();

            // Capture the output and print directly to console
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Python output: " + line);
            }

            // Capture and print any errors from the Python script
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println("Error output: " + errorLine);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
