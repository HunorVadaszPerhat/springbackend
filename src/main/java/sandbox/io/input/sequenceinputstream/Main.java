package sandbox.io.input.sequenceinputstream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // Create two InputStreams from two files
        try (InputStream file1 = new FileInputStream("data/input1.txt");
             InputStream file2 = new FileInputStream("data/input2.txt")) {

            // --- 1. Combine two streams using two-argument constructor (Essential) ---
            try (SequenceInputStream sisTwoStreams = new SequenceInputStream(file1, file2)) {
                System.out.println("Reading two streams combined:");
                readAndPrintStream(sisTwoStreams);
            }

            // Now create multiple streams dynamically
            InputStream file3 = new ByteArrayInputStream("And Hello from Memory Stream.".getBytes());

            Vector<InputStream> inputStreams = new Vector<>();
            inputStreams.add(new FileInputStream("data/input1.txt"));
            inputStreams.add(new FileInputStream("data/input2.txt"));
            inputStreams.add(file3);

            Enumeration<InputStream> enumeration = inputStreams.elements();

            // --- 2. Combine using Enumeration constructor (Advanced) ---
            try (SequenceInputStream sisEnumeration = new SequenceInputStream(enumeration)) {
                System.out.println("\nReading multiple streams from Enumeration:");
                readAndPrintStream(sisEnumeration);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to demonstrate reading behavior
    private static void readAndPrintStream(SequenceInputStream sis) throws IOException {
        byte[] buffer = new byte[10]; // Small buffer to demonstrate read(byte[], off, len)

        int bytesRead;
        while ((bytesRead = sis.read(buffer, 0, buffer.length)) != -1) {
            // --- 3. read(byte[], int, int) (Essential) ---
            // Read a chunk into buffer and print
            System.out.print(new String(buffer, 0, bytesRead));
        }

        // --- 4. available() (Rarely Used) ---
        System.out.println("\nAvailable bytes after reading everything: " + sis.available());

        // --- 5. markSupported() (Rarely Used) ---
        System.out.println("Is mark/reset supported? " + sis.markSupported());

        // --- 6. skip(long n) (Rarely Used) ---
        // Not effective here (already at end), but shows syntax:
        long skipped = sis.skip(5);
        System.out.println("Bytes skipped: " + skipped);

        // --- 7. close() (Essential) ---
        // Already handled by try-with-resources, but important: closes all streams properly.
    }
}
