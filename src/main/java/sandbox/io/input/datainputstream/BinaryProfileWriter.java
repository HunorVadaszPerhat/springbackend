package sandbox.io.input.datainputstream;

import java.io.*;

public class BinaryProfileWriter {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("data/sample_profiles.dat")))) {

            // Write sample data for two user profiles
            for (int i = 1; i <= 2; i++) {
                out.writeInt(i);                   // ID
                out.writeUTF("User" + i);          // Username
                out.writeBoolean(i % 2 == 0);      // Active flag
                out.writeByte(i * 10);             // Age as byte
                out.writeShort(i * 100);           // Short ID
                out.writeChar('A' + i);            // Initial
                out.writeFloat(65.5f + i);         // Weight
                out.writeDouble(170.2 + i);        // Height
                out.writeLong(System.currentTimeMillis()); // Timestamp
                out.write(new byte[] {1, 2, 3, 4}); // Raw byte block
            }

            System.out.println("Binary data written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

