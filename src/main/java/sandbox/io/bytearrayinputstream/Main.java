package sandbox.io.bytearrayinputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = "Hello, bytearrayinputstream!".getBytes();

        System.out.println("=== Constructor: Full Buffer ===");
        ByteArrayInputStream fullStream = new ByteArrayInputStream(data);
        demoStream(fullStream);

        System.out.println("\n=== Constructor: Subrange (7–18) ===");
        ByteArrayInputStream subStream = new ByteArrayInputStream(data, 7, 12);
        demoStream(subStream);
    }

    static void demoStream(ByteArrayInputStream stream) throws IOException {
        System.out.println("Available bytes: " + stream.available());

        // Mark and reset example
        System.out.println("\nMarking and reading...");
        if (stream.markSupported()) {
            stream.mark(0); // mark is effectively unlimited here
        }

        System.out.println("Reading byte-by-byte:");
        int b;
        while ((b = stream.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println("\nAfter read, available: " + stream.available());

        // Reset to marked position
        if (stream.markSupported()) {
            stream.reset();
            System.out.println("Reset done. Re-read first 5 bytes:");
            for (int i = 0; i < 5; i++) {
                System.out.print((char) stream.read());
            }
            System.out.println();
        }

        // Skip bytes
        stream.reset();
        System.out.println("\nSkipping 6 bytes...");
        stream.skip(6);
        System.out.println("Next byte after skip: " + (char) stream.read());

        // Read with buffer
        stream.reset();
        byte[] buffer = new byte[10];
        System.out.println("\nBuffered read (10 bytes):");
        int readCount = stream.read(buffer);
        System.out.println("Bytes read: " + readCount);
        System.out.println("As String: " + new String(buffer, 0, readCount));

        // Partial buffer read
        stream.reset();
        byte[] smallBuffer = new byte[20];
        System.out.println("\nPartial buffer read (5 bytes into offset 3):");
        int count = stream.read(smallBuffer, 3, 5);
        System.out.println("Bytes read: " + count);
        System.out.print("Buffer content at offset 3: ");
        for (int i = 3; i < 3 + count; i++) {
            System.out.print((char) smallBuffer[i]);
        }
        System.out.println();

        // Read all bytes
        stream.reset();
        System.out.println("\nUsing readAllBytes():");
        byte[] all = stream.readAllBytes();
        System.out.println("Full string: " + new String(all));

        // Transfer to OutputStream
        stream.reset();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        long transferred = stream.transferTo(out);
        System.out.println("\nTransferred bytes to ByteArrayOutputStream: " + transferred);
        System.out.println("Output stream content: " + out.toString());

        // Closing stream
        stream.close();
        System.out.println("\nStream closed (no effect for bytearrayinputstream).");
    }
}
