package sandbox.io.writer.pipedwriter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (PipedReader reader = new PipedReader();
             PipedWriter writer = new PipedWriter()) {

            // 1️⃣ connect(PipedReader sink): Connects writer to a reader.
            writer.connect(reader);
            System.out.println("Connected writer to reader.");

            // Start a reader thread
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader received: ");
                    // Reads characters one-by-one until pipe closes
                    while ((data = reader.read()) != -1) {
                        System.out.print((char) data);
                    }
                    System.out.println("\nReader finished reading.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readerThread.start();

            // 2️⃣ write(int c): Writes a single character.
            writer.write('H');
            writer.write('i');

            // 3️⃣ write(char[] cbuf, int off, int len): Writes characters from an array.
            char[] messageChars = {' ', 'f', 'r', 'o', 'm', ' ', 'P', 'i', 'p', 'e', '!'};
            writer.write(messageChars, 0, messageChars.length);

            // 4️⃣ write(String str, int off, int len): Writes characters from a string.
            String extraMessage = " [Java 21]";
            writer.write(extraMessage, 0, extraMessage.length());

            // 5️⃣ flush(): Forces all data to the connected reader immediately.
            writer.flush();
            System.out.println("Flushed data to reader.");

            // Demonstrating inherited convenience methods from Writer (Rarely used directly)
            // 6️⃣ append(CharSequence csq): Appends a character sequence.
            writer.append(" Appended text.");

            // Flush again after appending.
            writer.flush();
            System.out.println("Flushed appended data.");

            // Close the writer when finished (signals end of data).
            // 7️⃣ close(): Closes the pipe, reader gets -1 indicating end.
            writer.close();
            System.out.println("Writer closed.");

            readerThread.join(); // Wait for reader thread to finish

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

