package sandbox.io.output.fileoutputstream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "data/example.txt";
        File file = new File(filePath);

        // --- 1. Basic constructor: overwrite file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("Overwritten content.\n".getBytes());
            System.out.println("1. Wrote with constructor(File) — overwrites file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 2. Append mode: keep existing content
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write("Appended content.\n".getBytes());
            System.out.println("2. Wrote with constructor(File, true) — appends to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 3. Write single byte (inefficient, shown for demo)
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write('A');
            System.out.println("3. Wrote a single byte (char 'A').");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 4. Write entire byte array
        byte[] data = "Whole byte array write.\n".getBytes();
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(data);
            System.out.println("4. Wrote full byte array.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 5. Write part of byte array
        byte[] partialData = "PartialWriteData\n".getBytes();
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(partialData, 0, 7); // Writes "Partial"
            fos.write('\n');
            System.out.println("5. Wrote partial byte array (first 7 bytes).");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 6. Use flush (important when wrapping with buffer — shown here for awareness)
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))) {
            bos.write("Flushed content.\n".getBytes());
            bos.flush(); // forces data to be pushed from memory to OS buffer
            System.out.println("6. Flushed content manually.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 7. Use FileDescriptor
        try (FileOutputStream fos = new FileOutputStream(file)) {
            FileDescriptor fd = fos.getFD();
            fos.write("Accessed file descriptor.\n".getBytes());

            // Optionally force sync to disk
            fd.sync(); // ensure data is written to disk, not just to OS cache
            System.out.println("7. Used getFD() and called sync().");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 8. Use constructor with String path
        try (FileOutputStream fos = new FileOutputStream("data/string_constructor.txt")) {
            fos.write("Created using String path.\n".getBytes());
            System.out.println("8. Used constructor(String).");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 9. Use FileDescriptor constructor (rare)
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            FileDescriptor fd = raf.getFD();

            try (FileOutputStream fos = new FileOutputStream(fd)) {
                fos.write("Written via FileDescriptor constructor.\n".getBytes());
                System.out.println("9. Wrote using constructor(FileDescriptor).");
            }

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
