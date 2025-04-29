package sandbox.io.input.datainputstream;

import java.io.*;

public class BinaryProfileReader {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("data/sample_profiles.dat")))) {

            int profileCount = 2;

            for (int i = 0; i < profileCount; i++) {
                System.out.println("=== Profile " + (i + 1) + " ===");

                // ESSENTIAL PRIMITIVES
                int id = in.readInt(); // 4 bytes
                String username = in.readUTF(); // modified UTF
                boolean isActive = in.readBoolean(); // 1 byte
                byte age = in.readByte(); // 1 byte
                short shortId = in.readShort(); // 2 bytes
                char initial = in.readChar(); // 2 bytes
                float weight = in.readFloat(); // 4 bytes
                double height = in.readDouble(); // 8 bytes
                long timestamp = in.readLong(); // 8 bytes

                // BULK READ
                byte[] rawBlock = new byte[4];
                in.readFully(rawBlock); // 4 bytes

                // OUTPUT
                System.out.printf("ID: %d, Username: %s, Active: %b\n", id, username, isActive);
                System.out.printf("Age: %d, ShortID: %d, Initial: %c\n", age, shortId, initial);
                System.out.printf("Weight: %.2f, Height: %.2f, Timestamp: %d\n", weight, height, timestamp);
                System.out.print("Raw Block: ");
                for (byte b : rawBlock) System.out.print(b + " ");
                System.out.println("\n");

                // ADVANCED USAGE
                // Demonstrate skipBytes and available
                int skipped = in.skipBytes(0); // skipping nothing (can be used in real parsing logic)
                System.out.println("Bytes skipped: " + skipped);
                System.out.println("Available bytes (approx): " + in.available());
            }

        } catch (EOFException eof) {
            System.out.println("Reached end of file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
