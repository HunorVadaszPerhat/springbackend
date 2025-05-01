package sandbox.io.writer.bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Try-with-resources ensures the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/output.txt"), 16)) {

            // ✅ write(String s)
            // Writes the full string into the buffer.
            writer.write("Hello, Java 21!");

            // ✅ newLine()
            // Adds a platform-independent line separator.
            writer.newLine();

            // ✅ write(char[] cbuf, int off, int len)
            // Writes part of a character array into the buffer.
            char[] nameChars = "BufferedWriterExample".toCharArray();
            writer.write(nameChars, 0, 9); // Writes "BufferedW"
            writer.newLine();

            // ✅ write(String s, int off, int len)
            // Writes part of a string into the buffer.
            String longText = "EnterpriseJavaDevelopment";
            writer.write(longText, 0, 10); // Writes "Enterprise"
            writer.newLine();

            // ✅ write(int c)
            // Writes a single character (as an int).
            writer.write(65); // Writes 'A'
            writer.newLine();

            // ✅ flush()
            // Forces all buffered content to be written immediately.
            writer.flush();

            // ✅ close()
            // Called automatically by try-with-resources, but also works manually.
            // It flushes remaining content and releases the resource.
            // writer.close(); // Not needed here because try-with-resources handles it

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

