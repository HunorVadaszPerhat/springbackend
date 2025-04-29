package sandbox.io.output.filteroutputstream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Custom FilterOutputStream that logs each method usage for demonstration.
 */
public class DemoFilterOutputStream extends FilterOutputStream {

    public DemoFilterOutputStream(OutputStream out) {
        super(out);
        System.out.println("[Constructor] Wrapped OutputStream created.");
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println("[write(int)] Writing one byte: " + b);
        out.write(b); // Forward the byte to the underlying stream
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("[write(byte[])] Writing full byte array. Length: " + b.length);
        write(b, 0, b.length); // Delegate to write(byte[], int, int)
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println("[write(byte[], int, int)] Writing partial byte array from offset " + off + " length " + len);
        for (int i = off; i < off + len; i++) {
            write(b[i]); // Could be optimized for bulk writes
        }
    }

    @Override
    public void flush() throws IOException {
        System.out.println("[flush()] Flushing stream.");
        out.flush();
    }

    @Override
    public void close() throws IOException {
        System.out.println("[close()] Flushing and closing stream.");
        flush();  // Optional (already called by many OutputStream implementations)
        out.close();
    }
}
