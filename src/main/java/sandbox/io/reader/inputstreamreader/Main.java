package sandbox.io.reader.inputstreamreader;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.CharBuffer;


public class Main {

    public static void main(String[] args) {
        File file = new File("data/sample.txt");

        // 1. Using Charset (Recommended)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {

            // 2. getEncoding()
            System.out.println("Encoding used: " + reader.getEncoding()); // → UTF8 or equivalent alias

            // 3. read() – single character read
            System.out.print("Reading characters one-by-one: ");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. read(char[] buffer)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            char[] buffer = new char[64];
            int numRead = reader.read(buffer); // read as much as fits
            System.out.println("\nBuffered read into char[]:");
            System.out.println(new String(buffer, 0, numRead));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. read(char[] buffer, offset, length)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            char[] buffer = new char[100];
            int numRead = reader.read(buffer, 10, 20); // read into slice
            System.out.println("\nRead with offset and length:");
            System.out.println(new String(buffer, 10, numRead));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 6. read(CharBuffer target)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            CharBuffer charBuffer = CharBuffer.allocate(100);
            int charsRead = reader.read(charBuffer); // fills CharBuffer
            charBuffer.flip(); // prepare to read
            System.out.println("\nRead into CharBuffer:");
            while (charBuffer.hasRemaining()) {
                System.out.print(charBuffer.get());
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 7. ready()
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            if (reader.ready()) {
                System.out.println("\nStream is ready for reading (non-blocking check).");
            } else {
                System.out.println("\nStream not ready.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 8. skip(long n)
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            reader.skip(7); // skip "Hello, "
            System.out.print("\nAfter skipping 7 characters: ");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 9. markSupported() → always false
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            System.out.println("\nmarkSupported(): " + reader.markSupported()); // always false
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 10. close() is already demonstrated by try-with-resources
        System.out.println("\nAll streams were closed automatically using try-with-resources.");
    }
}

