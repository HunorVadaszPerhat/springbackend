package sandbox.io.fileinputstream;

import java.io.*;

public class FileInputStreamDemo {

    public static void main(String[] args) {
        try {
            readTextFileUsingStringPath("io/input.txt");
            readTextFileUsingFileObject(new File("io/input.txt"));
            readBinaryData("binary.dat");
            useAvailableAndEOF("binary.dat");
            demonstrateGetFD("io/input.txt");
            demonstrateUnsupportedMarkReset("io/input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Use constructor FileInputStream(String name) and read() methods
    static void readTextFileUsingStringPath(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            System.out.println("Reading file with PathDemoProject string:");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // assume UTF-8
            }
            System.out.println("\n---");
        }
    }

    // Use constructor FileInputStream(File file) and read(byte[], off, len)
    static void readTextFileUsingFileObject(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[64];
            int bytesRead = fis.read(buffer, 0, buffer.length);
            System.out.println("Reading using File object:");
            System.out.println(new String(buffer, 0, bytesRead));
            System.out.println("---");
        }
    }

    // Use read(byte[]) with binary file
    static void readBinaryData(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[16];
            int bytesRead;
            System.out.println("Reading binary data:");
            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.printf("%02X ", buffer[i]);
                }
                System.out.println();
            }
            System.out.println("---");
        }
    }

    // Use available() and show handling of EOF
    static void useAvailableAndEOF(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            System.out.println("Bytes available without blocking: " + fis.available());
            int b;
            while ((b = fis.read()) != -1) {
                // do nothing
            }
            System.out.println("Reached EOF.");
            System.out.println("---");
        }
    }

    // Use getFD() to get the FileDescriptor
    static void demonstrateGetFD(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            FileDescriptor fd = fis.getFD();
            System.out.println("Got FileDescriptor: " + fd.valid());
            System.out.println("---");
        }
    }

    // Show behavior of mark(), reset(), and markSupported()
    static void demonstrateUnsupportedMarkReset(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            System.out.println("markSupported(): " + fis.markSupported());
            try {
                fis.mark(10); // does nothing
                fis.reset();  // throws IOException
            } catch (IOException e) {
                System.out.println("reset() not supported: " + e.getMessage());
            }
            System.out.println("---");
        }
    }
}
