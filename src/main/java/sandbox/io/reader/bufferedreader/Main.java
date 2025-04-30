package sandbox.io.reader.bufferedreader;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("data/sample.txt");

        // Essential: readLine()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            System.out.println("Reading lines one by one (readLine):");
            while ((line = reader.readLine()) != null) {
                System.out.println("  > " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Essential: lines()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\nReading lines using stream (lines):");
            Stream<String> lines = reader.lines();
            lines.map(String::toUpperCase).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Advanced: read(char[], int, int)
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\nReading into buffer (read(char[], off, len)):");
            char[] buffer = new char[20];
            int charsRead;
            while ((charsRead = reader.read(buffer, 0, buffer.length)) != -1) {
                System.out.print(new String(buffer, 0, charsRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Advanced: read()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\n\nReading character by character (read()):");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rarely Used: skip(long n)
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\n\nSkipping first 10 characters (skip):");
            reader.skip(10);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rarely Used: ready()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\n\nChecking if reader is ready:");
            System.out.println("  Is ready? " + reader.ready());
            System.out.println("  First line: " + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Advanced: mark(int readAheadLimit), reset()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\nUsing mark() and reset():");
            System.out.println("  Reading first line: " + reader.readLine());

            if (reader.markSupported()) {
                reader.mark(100); // mark current position
                System.out.println("  Reading second line: " + reader.readLine());
                reader.reset();   // rewind to mark
                System.out.println("  After reset, reading again: " + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rarely Used: markSupported()
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("\nChecking if mark/reset supported:");
            System.out.println("  Supported? " + reader.markSupported());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Essential: close() - handled via try-with-resources
        // Explanation: Stream is automatically closed at the end of each try block.
        System.out.println("\nResources auto-closed using try-with-resources.");
    }
}

