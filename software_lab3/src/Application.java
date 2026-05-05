import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Path inPath = Paths.get("studenti_in.txt");
            List<String> lines = Files.readAllLines(inPath);

            List<String> sortableLines = new ArrayList<>();
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    String nume = parts[2].trim();
                    String formatie = parts[3].trim();

                    String modifiedLine = formatie + "@" + nume + "@" + line;
                    sortableLines.add(modifiedLine);
                }
            }
            Collections.sort(sortableLines);

            Path outPath = Paths.get("studenti_out_sorted.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(outPath)) {
                for (String item : sortableLines) {
                    String[] finalParts = item.split("@");
                    String originalLine = finalParts[2];
                    writer.write(originalLine);
                    writer.newLine();
                }
            }
            System.out.println("gata");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}