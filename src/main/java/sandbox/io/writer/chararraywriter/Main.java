package sandbox.io.writer.chararraywriter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. Create a CharArrayWriter with default initial size
        CharArrayWriter writer = new CharArrayWriter(); // Default 32-char buffer

        // 2. Write a single character
        writer.write('A'); // Writes one character

        // 3. Write a portion of a char array
        char[] name = {'J', 'a', 'v', 'a', ' ', '2', '1'};
        writer.write(name, 0, 4); // Writes "Java"

        // 4. Write a portion of a string
        String str = " - Lightweight Memory Writer";
        writer.write(str, 3, 11); // Writes "Lightweight"

        // 5. Convert content to a char array
        char[] resultChars = writer.toCharArray();
        System.out.println("ToCharArray Output: " + new String(resultChars));
        // Outputs: "AJavaLightweight"

        // 6. Convert content to a String
        String resultString = writer.toString();
        System.out.println("ToString Output: " + resultString);

        // 7. Write contents to another Writer (e.g., a StringBuilder-backed writer)
        Writer target = new CharArrayWriter(); // Could be FileWriter or PrintWriter
        writer.writeTo(target); // Copies internal buffer to another Writer

        // 8. Query the current size
        System.out.println("Size (number of characters written): " + writer.size());

        // 9. Reset the writer for reuse (clears content but keeps buffer)
        writer.reset();
        System.out.println("After reset, size: " + writer.size()); // Should be 0

        // 10. Write again after reset
        writer.write("Reused!");

        // 11. Flush the writer (does nothing, safe no-op)
        writer.flush(); // No-op, but included for compatibility

        // 12. Close the writer (does nothing, safe no-op)
        writer.close(); // Also a no-op

        // 13. Show final output
        System.out.println("Final content after reuse: " + writer.toString());
    }
}

