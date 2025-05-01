package sandbox.io.reader.filereader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Example 1: FileReader with String filename
        try (FileReader reader = new FileReader("data/input.txt")) {
            System.out.println("1️⃣ read() - One character at a time:");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch); // prints char by char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n----------------------------");

        // Example 2: read(char[] buffer)
        try (FileReader reader = new FileReader("data/input.txt")) {
            System.out.println("2️⃣ read(char[]) - Reading into buffer:");
            char[] buffer = new char[20];
            int count = reader.read(buffer); // returns number of characters read
            System.out.println("Read characters: " + count);
            System.out.println(new String(buffer, 0, count));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n----------------------------");

        // Example 3: read(char[], off, len)
        try (FileReader reader = new FileReader("data/input.txt")) {
            System.out.println("3️⃣ read(char[], offset, length):");
            char[] buffer = new char[50];
            int count = reader.read(buffer, 5, 15); // read into offset 5
            System.out.println("Read characters: " + count);
            System.out.println("Buffer content: " + new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n----------------------------");

        // Example 4: ready()
        try (FileReader reader = new FileReader("data/input.txt")) {
            System.out.println("4️⃣ ready():");
            if (reader.ready()) {
                System.out.println("The reader is ready to read!");
            } else {
                System.out.println("The reader is not ready.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n----------------------------");

        // Example 5: skip(long n)
        try (FileReader reader = new FileReader("data/input.txt")) {
            System.out.println("5️⃣ skip(n): Skip first 10 characters");
            reader.skip(10); // skips 10 characters
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n----------------------------");

        // Example 6: getEncoding() from InputStreamReader
        try (FileReader reader = new FileReader("data/input.txt")) {
            InputStreamReader isr = reader; // FileReader extends InputStreamReader
            System.out.println("6️⃣ getEncoding(): " + isr.getEncoding());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n----------------------------");

        // Example 7: close() demonstration (manual - discouraged, just for show)
        FileReader manualReader = null;
        try {
            manualReader = new FileReader("data/input.txt");
            System.out.println("7️⃣ close(): Manually closing reader");
            manualReader.close(); // Always do this in try-with-resources in real code!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
