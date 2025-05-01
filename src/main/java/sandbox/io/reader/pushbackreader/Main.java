package sandbox.io.reader.pushbackreader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Prepare the input source
        try (PushbackReader reader = new PushbackReader(new BufferedReader(new FileReader("data/input.txt")), 10)) {

            System.out.println("=== Start Parsing Input ===");

            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch == '/') {
                    // Look ahead to see if this is a comment (e.g., // or / )
                    int next = reader.read(); // read() - Essential
                    if (next == ' ') {
                        System.out.println("Comment detected. Skipping line...");
                        skipLine(reader); // Continue to skip rest of line
                        continue;
                    } else {
                        // unread(int c) - Essential
                        reader.unread(next); // Put back if not part of a comment
                        System.out.println("Found '/', but not a comment.");
                    }
                } else if (Character.isDigit(ch)) {
                    char[] number = new char[3];
                    number[0] = (char) ch;
                    // read(char[], off, len) - Advanced
                    int readCount = reader.read(number, 1, 2); // read 2 more characters
                    System.out.println("Read digits: " + new String(number, 0, 1 + readCount));

                    // unread(char[], off, len) - Advanced
                    reader.unread(number, 1, readCount); // Push back last 2 digits
                    System.out.println("Unreading digits: " + new String(number, 1, readCount));
                } else {
                    System.out.println("Char: " + (char) ch);
                }

                // ready() - Rarely Used
                if (reader.ready()) {
                    System.out.println("Reader is ready for more.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void skipLine(PushbackReader reader) throws IOException {
        int c;
        while ((c = reader.read()) != -1) {
            if (c == '\n') break;
        }
    }
}

