package sandbox.io.reader.linenumberreader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Main {
    public static void main(String[] args) {
        try (LineNumberReader reader = new LineNumberReader(new FileReader("data/input.txt"))) {

            // 🔹 readLine(): Reads one line at a time and moves line number forward
            System.out.println("Reading lines:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.printf("Line %d: %s%n", reader.getLineNumber(), line);
            }

            // 🔹 reset and mark(): Let's demonstrate this from a fresh reader
            try (LineNumberReader markedReader = new LineNumberReader(new FileReader("data/input.txt"))) {
                System.out.println("\nUsing mark() and reset():");

                // mark(): Save current position + line number
                markedReader.mark(100); // 100 chars lookahead limit
                markedReader.readLine(); // Reads "First line"
                markedReader.readLine(); // Reads "Second line"

                System.out.printf("After 2 lines, line number: %d%n", markedReader.getLineNumber());

                // reset(): Go back to where mark() was
                markedReader.reset();
                System.out.printf("After reset, line number: %d%n", markedReader.getLineNumber());

                String lineAfterReset = markedReader.readLine();
                System.out.printf("Line after reset: %s%n", lineAfterReset);
            }

            // 🔹 getLineNumber(): Already used above, gives current line position

            // 🔹 setLineNumber(): You can change the internal line number counter
            try (LineNumberReader fakeCounter = new LineNumberReader(new FileReader("data/input.txt"))) {
                fakeCounter.setLineNumber(100); // Pretend we're starting from line 100
                fakeCounter.readLine(); // Will still read from the beginning of file
                System.out.printf("\nsetLineNumber() to 100: Now at line %d%n", fakeCounter.getLineNumber());
            }

            // 🔹 read(char[], int, int): Read into buffer directly
            try (LineNumberReader bufferedRead = new LineNumberReader(new FileReader("data/input.txt"))) {
                char[] buffer = new char[50];
                int readChars = bufferedRead.read(buffer, 0, buffer.length);
                System.out.println("\nRead using read(char[], int, int):");
                System.out.println("Content: " + new String(buffer, 0, readChars));
                System.out.println("Line number after buffered read: " + bufferedRead.getLineNumber());
            }

            // 🔹 read(): Read a single character (and update line number if a newline is read)
            try (LineNumberReader charReader = new LineNumberReader(new FileReader("data/input.txt"))) {
                int ch;
                System.out.println("\nReading character-by-character:");
                while ((ch = charReader.read()) != -1) {
                    System.out.print((char) ch);
                    if (charReader.getLineNumber() > 2) break; // stop after 2 lines
                }
                System.out.println("\nLine number at stop: " + charReader.getLineNumber());
            }

            // 🔹 skip(): Skip characters (be cautious; may not count lines correctly)
            try (LineNumberReader skipReader = new LineNumberReader(new FileReader("data/input.txt"))) {
                System.out.println("\nSkipping 15 characters:");
                skipReader.skip(15);
                System.out.println("Line number after skip: " + skipReader.getLineNumber());
                String skippedLine = skipReader.readLine();
                System.out.println("Line after skip: " + skippedLine);
            }

            // 🔹 markSupported(): Always true for LineNumberReader
            try (LineNumberReader checkMark = new LineNumberReader(new FileReader("data/input.txt"))) {
                System.out.println("\nmarkSupported(): " + checkMark.markSupported());
            }

            // 🔹 close(): Automatically called by try-with-resources
            // Ensures resource cleanup

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
