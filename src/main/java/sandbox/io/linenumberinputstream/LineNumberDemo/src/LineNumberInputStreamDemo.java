package sandbox.io.linenumberinputstream.LineNumberDemo.src;

import java.io.*;

public class LineNumberInputStreamDemo {

    public static void main(String[] args) {
        // Load from classpath resource
        InputStream stream1 = LineNumberInputStreamDemo.class
                .getClassLoader()
                .getResourceAsStream("io/input.txt");

        if (stream1 == null) {
            System.err.println("Resource not found: io/input.txt");
            return;
        }

        try (LineNumberInputStream lnis = new LineNumberInputStream(stream1)) {

            System.out.println("LineNumberInputStream Demonstration\n");

            // 1. getLineNumber() - Gets current line number (starts at 0)
            System.out.println("Initial Line Number: " + lnis.getLineNumber());

            // 2. read() - Read byte by byte, line number updates on line breaks
            System.out.println("\nReading bytes one by one:");
            int byteData;
            while ((byteData = lnis.read()) != -1) {
                char ch = (char) byteData;
                System.out.print(ch);
                if (ch == '\n') {
                    System.out.println("Line Number Now: " + lnis.getLineNumber());
                }
            }

            System.out.println("\nFinal Line Number after read(): " + lnis.getLineNumber());

            // 3. setLineNumber(int) - Reset or manually set the line number
            lnis.setLineNumber(100);
            System.out.println("Line number manually set to: " + lnis.getLineNumber());

        } catch (IOException e) {
            e.printStackTrace();
        }


        // 🚨 DO NOT reuse stream1 — it's closed now!
        InputStream stream2 = LineNumberInputStreamDemo.class
                .getClassLoader()
                .getResourceAsStream("io/input.txt");

        if (stream2 == null) {
            System.err.println("Resource not found: io/input.txt");
            return;
        }

        // Demonstrating other methods separately
        try (LineNumberInputStream lnis2 = new LineNumberInputStream(stream2)) {

            // 4. read(byte[] b, int off, int len) - Read chunks into array
            byte[] buffer = new byte[32];
            int bytesRead = lnis2.read(buffer, 0, buffer.length);
            System.out.println("\nRead using read(byte[], int, int):");
            System.out.println(new String(buffer, 0, bytesRead));
            System.out.println("Line Number After read(byte[]): " + lnis2.getLineNumber());

            // 5. mark(int readlimit) and reset()
            if (lnis2.markSupported()) {
                lnis2.mark(100); // mark current position
                System.out.println("\nMarked at line: " + lnis2.getLineNumber());

                // Read a few more lines
                lnis2.read(new byte[10]);
                System.out.println("Line after reading more: " + lnis2.getLineNumber());

                lnis2.reset(); // go back to mark
                System.out.println("After reset(), line number: " + lnis2.getLineNumber());
            }

            // 6. skip(long n)
            long skipped = lnis2.skip(5);
            System.out.println("\nSkipped 5 bytes: " + skipped);
            System.out.println("Line number after skip: " + lnis2.getLineNumber());

            // 7. available()
            int available = lnis2.available();
            System.out.println("Bytes available (estimate): " + available);

            // 8. read(byte[] b)
            byte[] arr = new byte[10];
            int len = lnis2.read(arr);
            System.out.println("\nRead using read(byte[]): " + new String(arr, 0, len));
            System.out.println("Line number after bulk read: " + lnis2.getLineNumber());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
