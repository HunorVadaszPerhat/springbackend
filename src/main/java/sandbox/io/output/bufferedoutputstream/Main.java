package sandbox.io.output.bufferedoutputstream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        String filePath = "output_demo.txt";

        // Sample data
        byte[] dataBlock = "BufferedOutputStream in Java 21\n".getBytes();
        int singleByte = 65; // ASCII for 'A'

        try (
                // Essential: Constructing with custom buffer size
                FileOutputStream fos = new FileOutputStream(filePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos, 16) // Advanced use: small buffer to force frequent flush
        ) {
            // 1. write(int b) - write single byte
            bos.write(singleByte);  // Writes 'A'

            // 2. write(byte[] b, int off, int len) - partial array
            bos.write(dataBlock, 0, 10);  // Writes "BufferedOu"

            // 3. write(byte[] b) - full array (inherited from FilterOutputStream)
            bos.write(dataBlock); // Writes full line again

            // 4. flush() - forces any buffered data to be written out
            bos.flush();  // Especially important before reading or checking file output

            // 5. close() - closes stream after flushing it
            // Automatically handled by try-with-resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display file contents to confirm
        try {
            System.out.println("\n--- File Contents ---");
            Files.readAllLines(Path.of(filePath)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading the output file.");
        }
    }
}

