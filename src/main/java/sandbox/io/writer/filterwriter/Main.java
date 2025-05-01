package sandbox.io.writer.filterwriter;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Demonstrates the usage of each FilterWriter method in a real example.
 */
public class Main {
    public static void main(String[] args) {
        try (Writer fw = new FileWriter("data/output.txt");
             CustomFilterWriter writer = new CustomFilterWriter(fw)) {

            // 1. write(int c) — single char, uppercased
            writer.write('a'); // Output: 'A'

            // 2. write(char[], off, len) — filters "secret" from buffer
            char[] text = "This is a secret message.".toCharArray();
            writer.write(text, 0, text.length); // Output: REDACTED

            // 3. write(String, off, len) — substring & uppercase
            writer.write("confidential data here", 0, 12); // Output: CONFIDENTIAL

            // 4. flush()
            writer.flush();

            // 5. append(char)
            writer.append('x');

            // 6. append(CharSequence)
            writer.append("appended text");

            // 7. append(CharSequence, start, end)
            writer.append("slice-this", 0, 5); // Output: SLICE

            // 8. close()
            writer.close();

            System.out.println("Finished writing to output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
