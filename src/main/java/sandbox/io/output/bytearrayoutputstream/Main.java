package sandbox.io.output.bytearrayoutputstream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Create a ByteArrayOutputStream with default capacity (32 bytes)
        ByteArrayOutputStream baosDefault = new ByteArrayOutputStream();
        System.out.println("Initialized with default capacity.");

        // 2. Create with custom initial size to avoid resizing
        ByteArrayOutputStream baosCustom = new ByteArrayOutputStream(64);
        System.out.println("Initialized with custom capacity.");

        // 3. Write a single byte
        baosDefault.write(65); // 'A'
        System.out.println("write(int b): Wrote a single byte 'A'.");

        // 4. Write a full byte array
        byte[] data = "BCDE".getBytes(StandardCharsets.UTF_8);
        baosDefault.write(data);
        System.out.println("write(byte[] b): Wrote 'BCDE'.");

        // 5. Write a subset of a byte array
        byte[] moreData = "FGHIJKLMNOP".getBytes(StandardCharsets.UTF_8);
        baosDefault.write(moreData, 0, 4); // Writes "FGHI"
        System.out.println("write(byte[], off, len): Wrote first 4 bytes 'FGHI'.");

        // 6. Check the current size
        int currentSize = baosDefault.size();
        System.out.println("size(): Current size = " + currentSize + " bytes.");

        // 7. Convert to byte array (copy)
        byte[] byteArray = baosDefault.toByteArray();
        System.out.println("toByteArray(): Created copy of internal data.");
        System.out.println("Contents as bytes: " + new String(byteArray, StandardCharsets.UTF_8));

        // 8. Convert to string with charset
        String contentString = baosDefault.toString(StandardCharsets.UTF_8);
        System.out.println("toString(Charset): Content = '" + contentString + "'");

        // 9. Convert to string with charset name
        String contentStringName = baosDefault.toString("UTF-8");
        System.out.println("toString(String charsetName): Content = '" + contentStringName + "'");

        // 10. Write content to another OutputStream
        ByteArrayOutputStream baosTarget = new ByteArrayOutputStream();
        baosDefault.writeTo(baosTarget);
        System.out.println("writeTo(OutputStream): Copied data to another stream.");
        System.out.println("Copied content: " + baosTarget.toString(StandardCharsets.UTF_8));

        // 11. Reset the stream for reuse
        baosDefault.reset();
        System.out.println("reset(): Stream reset. Current size = " + baosDefault.size());

        // 12. flush() - does nothing but must be supported
        baosDefault.flush(); // No-op
        System.out.println("flush(): Called (no effect for ByteArrayOutputStream).");

        // 13. close() - also does nothing
        baosDefault.close(); // No-op
        System.out.println("close(): Called (no effect for ByteArrayOutputStream).");
    }
}

