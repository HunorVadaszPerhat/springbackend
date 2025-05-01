package sandbox.io.writer.filewriter;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        writeStringToFile();
        writeWithAppend();
        writeWithCharArray();
        writePartialCharArray();
        writePartialString();
        writeSingleChar();
        useFileDescriptor();
        flushExample();
    }

    // ✅ Essential: Basic use of FileWriter with a String
    static void writeStringToFile() {
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write("Hello from write(String)!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Essential: Append mode (e.g., logging)
    static void writeWithAppend() {
        try (FileWriter writer = new FileWriter("data/output.txt", true)) {
            writer.write("Appending this line.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ⚙️ Advanced: Writing full char array
    static void writeWithCharArray() {
        char[] data = "Char array example".toCharArray();
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ⚙️ Advanced: Writing part of a char array
    static void writePartialCharArray() {
        char[] data = "Only part of this".toCharArray();
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write(data, 5, 4); // writes "part"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ⚙️ Advanced: Writing part of a String
    static void writePartialString() {
        String text = "This is a partial string write.";
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write(text, 10, 7); // writes "partial"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ❗ Rarely Used: Writing a single character (inefficient in loops)
    static void writeSingleChar() {
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write('A');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ⚙️ Advanced: Using FileDescriptor to write to a known open file
    static void useFileDescriptor() {
        try (FileOutputStream fos = new FileOutputStream("data/output.txt")) {
            FileDescriptor fd = fos.getFD();
            try (FileWriter writer = new FileWriter(fd)) {
                writer.write("Written using FileDescriptor.");
                writer.flush(); // needed since FileWriter won't close the descriptor
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Essential: Manual flush for real-time output
    static void flushExample() {
        try (FileWriter writer = new FileWriter("data/output.txt")) {
            writer.write("This is written.");
            writer.flush(); // forces immediate write
            System.out.println("Flush complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
