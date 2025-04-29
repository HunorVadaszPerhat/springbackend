package sandbox.io.output.pipedoutputstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // Create a PipedInputStream and a PipedOutputStream
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        try {
            // === connect(PipedInputStream) ===
            // Connect the output stream to the input stream.
            outputStream.connect(inputStream);
            System.out.println("Streams connected.");

            // Using ExecutorService to simulate two separate threads
            ExecutorService executor = Executors.newFixedThreadPool(2);

            executor.submit(() -> {
                try {
                    // === write(int b) ===
                    // Writing a single byte
                    outputStream.write(65); // ASCII 'A'
                    System.out.println("Wrote single byte: 65 (A)");

                    // === write(byte[] b, int off, int len) ===
                    // Writing an array of bytes with offset and length
                    byte[] data = "Hello, World!".getBytes();
                    outputStream.write(data, 0, data.length);
                    System.out.println("Wrote byte array: Hello, World!");

                    // === flush() ===
                    // Flushing output stream (has no effect here, but good form)
                    outputStream.flush();
                    System.out.println("Flushed the output stream.");

                    // === close() ===
                    // Closing the output stream to signal end-of-stream to the reader
                    outputStream.close();
                    System.out.println("Output stream closed.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            executor.submit(() -> {
                try {
                    int byteData;
                    // Read until end-of-stream
                    while ((byteData = inputStream.read()) != -1) {
                        System.out.print((char) byteData);
                    }
                    System.out.println("\nReader finished.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

