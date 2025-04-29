package sandbox.io.output.filteroutputstream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Main class to demonstrate the usage of DemoFilterOutputStream.
 */
public class Main {
    public static void main(String[] args) {
        String filename = "output.txt";

        try (DemoFilterOutputStream demoStream =
                     new DemoFilterOutputStream(new FileOutputStream(filename))) {

            // 1. Write a single byte
            demoStream.write('H'); // Single character 'H'

            // 2. Write a full byte array
            byte[] wordBytes = "ello".getBytes(StandardCharsets.UTF_8);
            demoStream.write(wordBytes); // Writes "ello"

            // 3. Write a subset of a byte array
            byte[] longBytes = " World! ExtraData".getBytes(StandardCharsets.UTF_8);
            demoStream.write(longBytes, 0, 7); // Writes " World"

            // 4. Flush the data manually
            demoStream.flush();

            // 5. Close the stream (automatically called by try-with-resources)
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Demo completed. Check file: " + filename);
    }
}

