package sandbox.io.output.dataoutputstream;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "output_data.bin";

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            // 1. write(int b) - Write a single byte (only lowest 8 bits kept)
            dos.write(0x7F); // 127 decimal

            // 2. write(byte[] b) - Write entire byte array
            byte[] fullArray = {1, 2, 3, 4, 5};
            dos.write(fullArray);

            // 3. write(byte[] b, int off, int len) - Write part of a byte array
            byte[] partialArray = {10, 20, 30, 40, 50};
            dos.write(partialArray, 1, 3); // Writes {20, 30, 40}

            // 4. flush() - Force buffered output to be written
            dos.flush();

            // 5. writeBoolean(boolean v) - Write boolean as single byte (1 or 0)
            dos.writeBoolean(true);
            dos.writeBoolean(false);

            // 6. writeByte(int v) - Write single byte
            dos.writeByte(100); // 0x64

            // 7. writeShort(int v) - Write 2 bytes (short)
            dos.writeShort(32000);

            // 8. writeChar(int v) - Write 2 bytes representing a Unicode character
            dos.writeChar('A'); // Unicode for 'A' = 0x0041

            // 9. writeInt(int v) - Write 4 bytes (int)
            dos.writeInt(123456789);

            // 10. writeLong(long v) - Write 8 bytes (long)
            dos.writeLong(9876543210L);

            // 11. writeFloat(float v) - Write 4 bytes (float IEEE 754)
            dos.writeFloat(3.14f);

            // 12. writeDouble(double v) - Write 8 bytes (double IEEE 754)
            dos.writeDouble(2.718281828459045);

            // 13. writeBytes(String s) - Write raw bytes (low byte only of each char)
            dos.writeBytes("Hello"); // 'H', 'e', 'l', 'l', 'o'

            // 14. writeChars(String s) - Write each char as two bytes (UTF-16)
            dos.writeChars("Hi"); // H -> 0x0048, i -> 0x0069

            // 15. writeUTF(String s) - Write String with modified UTF-8 encoding
            dos.writeUTF("Hello, world!");

            // 16. size() - Get the total number of bytes written so far
            int totalBytesWritten = dos.size();
            System.out.println("Total bytes written: " + totalBytesWritten);

            // No explicit close needed because of try-with-resources.

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading back would use DataInputStream — not required here per instructions.
    }
}

