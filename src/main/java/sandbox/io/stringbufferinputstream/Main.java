package sandbox.io.stringbufferinputstream;

import java.io.IOException;
import java.io.StringBufferInputStream;

@SuppressWarnings("deprecation") // Suppress warning because the class is deprecated
public class Main {

    public static void main(String[] args) {
        // 1. Create a StringBuffer with some text
        //StringBuffer buffer = new StringBuffer("Hello, World!");
        String buffer = "Hello, World!";

        // 2. Initialize StringBufferInputStream
        try (StringBufferInputStream inputStream = new StringBufferInputStream(buffer)) {
            // Short explanation:
            // -> Constructor: creates the input stream from the StringBuffer.
            System.out.println("Stream created.");

            // 3. Read bytes one by one
            System.out.println("\nReading bytes one by one:");
            int data;
            while ((data = inputStream.read()) != -1) {
                // read(): Reads the next byte (returns -1 when end of stream).
                System.out.print((char) data); // Cast back to char for display
            }
            System.out.println();

            // 4. Resetting stream
            inputStream.reset();
            // reset(): Resets the stream back to the beginning.

            // 5. Reading bytes into a byte array
            System.out.println("\nReading bytes into a byte array:");
            byte[] byteArray = new byte[5];
            int bytesRead = inputStream.read(byteArray, 0, byteArray.length);
            // read(byte[], off, len): Reads up to 'len' bytes into byteArray starting at 'off'.
            System.out.println("Bytes read: " + bytesRead);
            System.out.println("Data: " + new String(byteArray));

            // 6. Skipping characters
            long skipped = inputStream.skip(2);
            // skip(n): Skips 'n' characters in the stream.
            System.out.println("\nSkipped characters: " + skipped);

            // 7. Checking available bytes
            int available = inputStream.available();
            // available(): Returns the number of bytes that can still be read without blocking.
            System.out.println("Available bytes to read: " + available);

            // 8. Read remaining data
            System.out.println("\nReading remaining bytes:");
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();

            // 9. Closing stream (technically does nothing here)
            inputStream.close();
            // close(): A no-op for StringBufferInputStream but included for API consistency.

            System.out.println("\nStream closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}