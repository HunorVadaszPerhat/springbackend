package sandbox.io.inputstream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Core Reading Methods
            try (InputStream input = new FileInputStream("data/sample.txt")) {
                System.out.println("Reading one byte: " + (char) input.read());

                byte[] buffer = new byte[10];
                int bytesRead = input.read(buffer);
                System.out.println("Read buffer: " + new String(buffer, 0, bytesRead));

                buffer = new byte[20];
                bytesRead = input.read(buffer, 5, 10);
                System.out.println("Read with offset: " + new String(buffer, 5, bytesRead));
            }

            // 2. transferTo demonstration
            try (InputStream input = new FileInputStream("data/sample.txt");
                 OutputStream output = new FileOutputStream("data/output.txt")) {
                long transferred = input.transferTo(output);
                System.out.println("Bytes transferred: " + transferred);
            }

            // 3. available
            try (InputStream input = new FileInputStream("data/sample.txt")) {
                System.out.println("Bytes available (approx.): " + input.available());
            }

            // 4. skip
            try (InputStream input = new FileInputStream("data/sample.txt")) {
                input.skip(5);
                System.out.println("After skip(5): " + (char) input.read());
            }

            // 5. mark/reset
            ByteArrayInputStream markableStream = CustomInputStream.getMarkedStream();
            if (markableStream.markSupported()) {
                markableStream.mark(10);
                System.out.print("First read: ");
                for (int i = 0; i < 5; i++) System.out.print((char) markableStream.read());
                System.out.println();

                markableStream.reset();
                System.out.print("After reset: ");
                for (int i = 0; i < 5; i++) System.out.print((char) markableStream.read());
                System.out.println();
            }

            // 6. nullInputStream
            try (InputStream nullIn = InputStream.nullInputStream()) {
                System.out.println("Read from nullInputStream: " + nullIn.read()); // Should be -1
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
