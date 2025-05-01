package sandbox.io.reader.stringreader;

import java.io.*;
import java.nio.CharBuffer;

public class Main {

    public static void main(String[] args) throws IOException {
        String sample = "Hello\nJava 21\nStringReader Demo";

        // 1. Create a StringReader with sample string
        StringReader reader = new StringReader(sample);

        // 2. read() – read one character at a time
        System.out.println("== read() ==");
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
        System.out.println("\n");

        // Reset for next examples
        reader = new StringReader(sample);

        // 3. read(char[] cbuf, int off, int len) – read into part of a char array
        System.out.println("== read(char[], off, len) ==");
        char[] buffer = new char[10];
        int readCount = reader.read(buffer, 2, 5); // write starting at index 2
        System.out.println("Chars read: " + readCount);
        System.out.println("Buffer contents: " + new String(buffer));
        System.out.println();

        // Reset again
        reader = new StringReader(sample);

        // 4. read(CharBuffer target) – read into a CharBuffer (rarely used)
        System.out.println("== read(CharBuffer) ==");
        CharBuffer charBuffer = CharBuffer.allocate(20);
        reader.read(charBuffer);
        charBuffer.flip(); // prepare for reading
        System.out.println("CharBuffer: " + charBuffer.toString());
        System.out.println();

        // Reset
        reader = new StringReader(sample);

        // 5. skip(long n) – skip characters
        System.out.println("== skip() ==");
        reader.skip(6); // Skip "Hello\n"
        System.out.print("After skip: ");
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
        System.out.println("\n");

        // Reset
        reader = new StringReader(sample);

        // 6. mark(int readAheadLimit) and reset() – mark and rewind
        System.out.println("== mark() and reset() ==");
        System.out.print((char) reader.read()); // H
        reader.mark(100); // mark after 'H'
        System.out.print((char) reader.read()); // e
        System.out.print((char) reader.read()); // l
        reader.reset(); // go back to mark
        System.out.print("\nAfter reset: ");
        System.out.print((char) reader.read()); // e (again)
        System.out.print((char) reader.read()); // l
        System.out.println("\n");

        // 7. markSupported() – always true for StringReader
        System.out.println("== markSupported() ==");
        System.out.println("Mark supported? " + reader.markSupported());
        System.out.println();

        // 8. ready() – check if ready to read (always true unless closed)
        System.out.println("== ready() ==");
        System.out.println("Reader ready? " + reader.ready());
        System.out.println();

        // 9. close() – close the reader (safe to call even though it's in-memory)
        System.out.println("== close() ==");
        reader.close();
        System.out.println("Reader closed. Further reading will fail.");
        try {
            reader.read();
        } catch (IOException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
