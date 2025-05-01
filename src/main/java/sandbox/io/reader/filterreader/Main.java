package sandbox.io.reader.filterreader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String input = "This is a test file.\nIt contains a password.\nHandle it carefully.";
        Reader baseReader = new StringReader(input);
        BufferedReader reader = new BufferedReader(new CensoringReader(baseReader));

        try {
            // ready()
            if (reader.ready()) {
                System.out.println("Reader is ready.\n");
            }

            // mark() and reset()
            if (reader.markSupported()) {
                reader.mark(100); // mark first position
            }

            // read(char[], int, int)
            char[] buffer = new char[30];
            int numChars = reader.read(buffer, 0, buffer.length);
            System.out.println("First read:\n" + new String(buffer, 0, numChars));

            // reset() to go back and read again
            if (reader.markSupported()) {
                reader.reset();
                char[] buffer2 = new char[30];
                int numChars2 = reader.read(buffer2, 0, buffer2.length);
                System.out.println("\nAfter reset:\n" + new String(buffer2, 0, numChars2));
            }

            // skip()
            reader.skip(10);
            System.out.println("\nAfter skipping 10 characters:");
            char[] buffer3 = new char[50];
            int numChars3 = reader.read(buffer3, 0, buffer3.length);
            System.out.println(new String(buffer3, 0, numChars3));

            // close()
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
