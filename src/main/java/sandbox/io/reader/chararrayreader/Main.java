package sandbox.io.reader.chararrayreader;

import java.io.CharArrayReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Sample char array - like loading config from memory
        char[] configData = "username=admin;password=secret".toCharArray();

        // 1. Create a CharArrayReader using full array
        try (CharArrayReader reader = new CharArrayReader(configData)) {

            // 2. Check if ready to read (always true unless closed)
            if (reader.ready()) {
                System.out.println("Reader is ready.");
            }

            // 3. Read a single character
            int ch = reader.read(); // reads 'u'
            System.out.println("First char read: " + (char) ch);

            // 4. Mark the current position (start of 's' in "sername")
            reader.mark(0); // readAheadLimit is ignored here
            System.out.println("Marked position after first read.");

            // 5. Read next few characters into buffer
            char[] buffer = new char[8];
            int numRead = reader.read(buffer, 0, 8); // reads 'sername='
            System.out.println("Read into buffer: " + new String(buffer, 0, numRead));

            // 6. Skip characters (skip the 'admin')
            long skipped = reader.skip(5);
            System.out.println("Skipped characters: " + skipped);

            // 7. Reset back to marked position (before 'sername=')
            reader.reset();
            System.out.println("Reset back to marked position.");

            // 8. Read again after reset (should be same as earlier)
            char[] againBuffer = new char[8];
            int againRead = reader.read(againBuffer);
            System.out.println("Read after reset: " + new String(againBuffer, 0, againRead));

            // 9. Read until end (single-char reads)
            System.out.print("Remaining characters: ");
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(); // line break

            // 10. Close the reader (makes internal buffer null)
            reader.close();
            System.out.println("Reader closed.");

            // Attempting to read after closing (will throw IOException)
            try {
                reader.read();
            } catch (IOException e) {
                System.out.println("Exception after close: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

