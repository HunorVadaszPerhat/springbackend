package sandbox.io.reader.readerdemo;

import java.io.*;
import java.nio.CharBuffer;

public class Main {
    public static void main(String[] args) {
        File file = new File("data/sample.txt");

        // Try-with-resources ensures stream is closed properly
        try (Reader reader = new FileReader(file)) {

            // Demonstrate read(char[] cbuf)
            char[] buffer = new char[32];
            int charsRead = reader.read(buffer); // Reads characters into buffer
            System.out.println("Read with buffer (read(char[] cbuf)):");
            System.out.println(new String(buffer, 0, charsRead));
            System.out.println();

            // Demonstrate skip(long n)
            long skipped = reader.skip(10); // Skip 10 characters
            System.out.println("Skipped characters: " + skipped);

            // Demonstrate read(char[] cbuf, int off, int len)
            char[] partialBuffer = new char[10];
            int readCount = reader.read(partialBuffer, 2, 6); // Offset + length
            System.out.println("Read into partial buffer (read(char[], off, len)):");
            System.out.println(new String(partialBuffer));
            System.out.println();

            // Demonstrate mark() and reset()
            if (reader.markSupported()) {
                reader.mark(50); // Mark current position
                reader.read(buffer, 0, 10); // Read more
                System.out.println("After read post-mark:");
                System.out.println(new String(buffer, 0, 10));

                reader.reset(); // Go back to mark
                reader.read(buffer, 0, 10);
                System.out.println("After reset to mark:");
                System.out.println(new String(buffer, 0, 10));
            } else {
                System.out.println("mark/reset not supported by FileReader");
            }

            // Demonstrate read(CharBuffer target)
            CharBuffer charBuffer = CharBuffer.allocate(20);
            reader.read(charBuffer); // Fill NIO-style buffer
            charBuffer.flip(); // Prepare to read from buffer
            System.out.println("Read into CharBuffer:");
            while (charBuffer.hasRemaining()) {
                System.out.print(charBuffer.get());
            }
            System.out.println("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Demonstrate ready(), close() using BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if (bufferedReader.ready()) {
                System.out.println("BufferedReader is ready for reading.");
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("Line: " + line);
                }
            }
            // close() is auto-called by try-with-resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

