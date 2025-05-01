package sandbox.io.writer.stringwriter;
import java.io.StringWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. StringWriter() - default constructor
        StringWriter writer1 = new StringWriter();
        writer1.write("Hello, ");
        writer1.write("World!");
        System.out.println("1. write(String): " + writer1.toString());
        // Output: Hello, World!

        // 2. StringWriter(int initialSize) - allocate buffer ahead
        StringWriter writer2 = new StringWriter(50);
        writer2.write("Buffered text with estimated size.");
        System.out.println("2. write(String with buffer): " + writer2.toString());

        // 3. write(int c) - write a single character
        StringWriter writer3 = new StringWriter();
        writer3.write(65); // ASCII for 'A'
        System.out.println("3. write(int): " + writer3.toString()); // Output: A

        // 4. write(char[] cbuf, int off, int len)
        char[] chars = "abcdefg".toCharArray();
        writer3.write(chars, 2, 3); // writes "cde"
        System.out.println("4. write(char[], off, len): " + writer3.toString());

        // 5. write(String str, int off, int len)
        writer3.write("HelloWorld", 5, 5); // writes "World"
        System.out.println("5. write(String, off, len): " + writer3.toString());

        // 6. append(CharSequence csq)
        StringWriter writer4 = new StringWriter();
        writer4.append("Report: ");
        writer4.append("Q1 Sales");
        System.out.println("6. append(CharSequence): " + writer4.toString());

        // 7. append(CharSequence csq, int start, int end)
        writer4.append(" - Complete Data", 3, 11); // appends "Complete"
        System.out.println("7. append(CharSequence, start, end): " + writer4.toString());

        // 8. append(char c)
        writer4.append(':');
        System.out.println("8. append(char): " + writer4.toString());

        // 9. toString()
        String finalOutput = writer4.toString();
        System.out.println("9. toString(): " + finalOutput);

        // 10. getBuffer() - access underlying StringBuffer
        StringBuffer buffer = writer4.getBuffer();
        buffer.append(" [Verified]");
        System.out.println("10. getBuffer(): " + writer4.toString());

        // 11. flush() - does nothing, but allowed
        writer4.flush(); // No effect, but safe to call

        // 12. close() - also a no-op
        writer4.close(); // Still usable after close
        writer4.append(" (Closed OK)");
        System.out.println("11-12. flush & close: " + writer4.toString());
    }
}

