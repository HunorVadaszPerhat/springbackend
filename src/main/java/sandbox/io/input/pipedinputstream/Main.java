package sandbox.io.input.pipedinputstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create the piped streams
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();

        // 1. Connect the streams
        input.connect(output);
        // OR: Could have used constructor: new PipedInputStream(output);

        // Start writer thread
        Thread writer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    output.write(("Message " + i + "\n").getBytes());
                    Thread.sleep(500); // simulate delay
                }
                output.close(); // 5. Close the output when done
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start reader thread
        Thread reader = new Thread(() -> {
            try {
                byte[] buffer = new byte[32]; // small buffer for demo
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1) { // 2. Read from input stream
                    System.out.print("Reader got: " + new String(buffer, 0, bytesRead));

                    // 3. Check available() after reading
                    System.out.println("Available bytes: " + input.available());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        input.close(); // 5. Close the input
    }
}
