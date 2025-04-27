package sandbox.io.pushbackinputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Main {
    public static void main(String[] args) {
        // Reading the file using PushbackInputStream
        try (PushbackInputStream pbis = new PushbackInputStream(new FileInputStream("data/sample.txt"), 4)) {

            int data;
            while ((data = pbis.read()) != -1) {
                char c = (char) data;
                System.out.println("Read: " + c);

                // Short Explanation: read() reads a single byte (either from pushback buffer or underlying stream)

                if (Character.isLetter(c)) {
                    System.out.println("Letter detected, pushing back: " + c);
                    pbis.unread(data);
                    // Short Explanation: unread(int b) pushes back a single byte for reprocessing

                    // Let's read again (now from the pushback buffer)
                    int pushedBackData = pbis.read();
                    System.out.println("After pushing back, read again: " + (char) pushedBackData);
                } else if (Character.isDigit(c)) {
                    byte[] buffer = new byte[3];
                    buffer[0] = (byte) c;

                    int availableBytes = pbis.available();
                    // Short Explanation: available() tells how many bytes are ready to read without blocking
                    System.out.println("Available bytes to read: " + availableBytes);

                    int bytesRead = pbis.read(buffer, 1, 2);
                    // Short Explanation: read(byte[], int, int) reads multiple bytes into the buffer

                    System.out.print("Batch read: ");
                    for (int i = 0; i < 1 + (bytesRead > 0 ? bytesRead : 0); i++) {
                        System.out.print((char) buffer[i]);
                    }
                    System.out.println();

                    // Now, let's push back all these bytes at once
                    pbis.unread(buffer, 0, 1 + (bytesRead > 0 ? bytesRead : 0));
                    // Short Explanation: unread(byte[], int, int) pushes multiple bytes back at once

                    System.out.println("Pushed back digits: " + new String(buffer));
                }
            }
            // Short Explanation: close() automatically called by try-with-resources; closes both PushbackInputStream and underlying FileInputStream.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
