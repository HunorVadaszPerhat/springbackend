package sandbox.io.output.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Create a PrintStream writing to a file
            PrintStream ps = new PrintStream(new FileOutputStream("output.txt"), true, "UTF-8");
            // Short explanation: Create a PrintStream with auto-flush and UTF-8 encoding.

            // 2. Basic print() methods
            ps.print("Hello ");
            ps.print(123);
            ps.print(' ');
            ps.print(45.67);
            ps.print(true);
            ps.print('\n');
            // Short explanation: print() writes data without adding a new line.

            // 3. Basic println() methods
            ps.println();
            ps.println("This is a line.");
            ps.println(789);
            ps.println(3.1415);
            ps.println(false);
            // Short explanation: println() writes data **and** adds a platform-specific newline.

            // 4. printf() and format() with formatted output
            ps.printf("Name: %s, Age: %d%n", "Alice", 30);
            ps.format("Formatted number: %.2f%n", 12.34567);
            // Short explanation: printf() and format() allow formatted output similar to C's printf.

            // 5. append() methods (CharSequence, CharSequence with range, char)
            ps.append("Appended text!");
            ps.append('\n');
            ps.append("Only part of this sentence", 5, 15).append('\n');
            // Short explanation: append() allows chaining and fine control over what's added.

            // 6. write() methods
            byte[] byteArray = "Raw bytes output\n".getBytes();
            ps.write(byteArray);
            ps.write(byteArray, 0, 4); // Writes "Raw "
            ps.println();
            // Short explanation: write() sends raw bytes — use carefully, typically for binary or low-level text output.

            // 7. flush() to force output
            ps.flush();
            // Short explanation: flush() pushes any buffered content to the output immediately.

            // 8. checkError() to detect any issues
            if (ps.checkError()) {
                System.err.println("An error occurred while writing to the PrintStream.");
            }
            // Short explanation: checkError() returns true if any writing errors have happened.

            // 9. close() when done (NOT recommended for System.out/System.err)
            ps.close();
            // Short explanation: close() releases system resources. Never close System.out/System.err manually.

            // -- Additional: Standard System.out usage (good practice)
            System.out.println("Demonstrated PrintStream successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
