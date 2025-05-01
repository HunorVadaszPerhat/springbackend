package sandbox.io.reader.pipedreader;

import java.io.*;
import java.nio.CharBuffer;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create the pipe ends
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        // Connect the reader and writer
        reader.connect(writer); // connect(PipedWriter) - links the two ends of the pipe

        // Start a thread to simulate writing data
        Thread writerThread = new Thread(() -> {
            try {
                writer.write("Hello, Enterprise Java 21!\n");
                writer.write("Here's a second line.\n");
                writer.flush(); // Not strictly needed for PipedWriter, but safe
                writer.close(); // Always close after done writing
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Start a reader thread
        Thread readerThread = new Thread(() -> {
            try {
                // read(char[] cbuf, int off, int len) - efficient way to read chunks
                char[] buffer = new char[32];
                int numRead;

                while ((numRead = reader.read(buffer, 0, buffer.length)) != -1) {
                    System.out.print("[Chunk Read] " + new String(buffer, 0, numRead));
                }

                // Simulate checking ready()
                if (reader.ready()) {
                    System.out.println("Reader is ready (has buffered characters).");
                }

                // Demonstrate skip() - although no more chars here
                long skipped = reader.skip(5); // Skips up to 5 chars (no effect if stream is empty)
                System.out.println("Skipped " + skipped + " characters.");

                // Try reading into CharBuffer (rare but allowed)
                CharBuffer charBuffer = CharBuffer.allocate(10);
                int cbRead = reader.read(charBuffer);
                System.out.println("Read into CharBuffer (not common): " + cbRead);

                // Check mark support (always false)
                System.out.println("markSupported(): " + reader.markSupported());

                // Attempt mark/reset (unsupported, will throw exception)
                try {
                    reader.mark(10);
                    reader.reset();
                } catch (IOException e) {
                    System.out.println("mark/reset not supported: " + e.getMessage());
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close(); // Always close reader
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start threads
        writerThread.start();
        readerThread.start();

        // Wait for both to finish
        writerThread.join();
        readerThread.join();

        System.out.println("\nCommunication complete.");
    }
}
