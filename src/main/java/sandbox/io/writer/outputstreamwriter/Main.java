package sandbox.io.writer.outputstreamwriter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Set up output file
        File file = new File("data/output.txt");

        // Charset example: Always prefer StandardCharsets (type-safe and clear)
        Charset utf8 = StandardCharsets.UTF_8;

        // Using try-with-resources ensures proper closing of writer
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), utf8)) {

            // --- WRITE METHODS ---

            // 1. write(int c) - Writes a single character (code point)
            // Not recommended for loops or large data; inefficient
            writer.write('A'); // writes: A

            // 2. write(char[] cbuf) - Writes an entire character array
            char[] chars = { 'H', 'e', 'l', 'l', 'o' };
            writer.write(chars); // writes: Hello

            // 3. write(char[] cbuf, int off, int len) - Writes a portion of a character array
            writer.write(chars, 1, 3); // writes: ell

            // 4. write(String str) - Writes an entire string
            writer.write(" World"); // writes:  World

            // 5. write(String str, int off, int len) - Writes a substring from a string
            writer.write("Greetings!", 0, 5); // writes: Greet

            // --- APPEND METHODS (fluent style) ---

            // 6. append(char c) - Appends a single character
            writer.append('\n'); // writes: newline

            // 7. append(CharSequence csq) - Appends a sequence (String, StringBuilder, etc.)
            writer.append("Appended line"); // writes: Appended line

            // 8. append(CharSequence csq, int start, int end) - Appends a portion of a sequence
            writer.append("SubstringAppend", 0, 9); // writes: Substrin

            // --- STREAM CONTROL METHODS ---

            // 9. flush() - Forces any buffered output to be written immediately
            writer.flush(); // Good for sending data in chunks (e.g., network streams)

            // 10. getEncoding() - Returns the encoding used (not commonly used)
            System.out.println("Writer encoding: " + writer.getEncoding());

            // 11. close() - Automatically called at the end of try-with-resources block
            // Closes the writer and underlying stream, flushing any remaining data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

