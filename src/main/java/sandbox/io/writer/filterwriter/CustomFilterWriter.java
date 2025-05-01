package sandbox.io.writer.filterwriter;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * A simple FilterWriter that:
 * - Converts all text to uppercase
 * - Logs every write call to the console
 * - Replaces sensitive words like "secret" with "[REDACTED]"
 */
public class CustomFilterWriter extends FilterWriter {

    public CustomFilterWriter(Writer out) {
        super(out); // Initializes the underlying writer
    }

    @Override
    public void write(int c) throws IOException {
        // Convert a single character to uppercase
        super.write(Character.toUpperCase(c));
        System.out.println("[write(int)] Wrote char: " + (char) c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        // Replace "secret" in char buffer with "[REDACTED]" (just as an example)
        String input = new String(cbuf, off, len);
        input = input.replace("secret", "[REDACTED]");
        super.write(input.toCharArray(), 0, input.length());
        System.out.println("[write(char[], off, len)] Wrote buffer section.");
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        // Only write a portion of the string and log it
        String sliced = str.substring(off, off + len).toUpperCase();
        super.write(sliced, 0, sliced.length());
        System.out.println("[write(String, off, len)] Wrote substring: " + sliced);
    }

    @Override
    public void flush() throws IOException {
        // Flush the underlying writer
        super.flush();
        System.out.println("[flush()] Flushed writer.");
    }

    @Override
    public void close() throws IOException {
        // Close the underlying writer
        super.close();
        System.out.println("[close()] Closed writer.");
    }

    // Advanced (less often used) append methods:

    @Override
    public Writer append(char c) throws IOException {
        // Append a single character
        write(c);
        return this;
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
        // Append full CharSequence
        write(csq.toString(), 0, csq.length());
        return this;
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        // Append a portion of a CharSequence
        write(csq.subSequence(start, end).toString(), 0, end - start);
        return this;
    }
}

