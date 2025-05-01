package sandbox.io.reader.filterreader;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CensoringReader extends FilterReader {
    private final String censoredWord = "password";

    public CensoringReader(Reader in) {
        super(in);
    }

    // Essential: overrides single-character read to filter content
    @Override
    public int read() throws IOException {
        int ch = super.read();
        if (ch == -1) return -1;

        // Convert to uppercase for demo
        return Character.toUpperCase(ch);
    }

    // Essential: override buffered read to demonstrate filtering
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numRead = super.read(cbuf, off, len);
        if (numRead == -1) return -1;

        String chunk = new String(cbuf, off, numRead);
        String filtered = chunk.replaceAll(censoredWord, "********");
        char[] updated = filtered.toCharArray();

        System.arraycopy(updated, 0, cbuf, off, Math.min(updated.length, len));
        return updated.length;
    }

    // Advanced: demonstrates skipping characters
    @Override
    public long skip(long n) throws IOException {
        System.out.println("Skipping " + n + " characters...");
        return super.skip(n);
    }

    // Advanced: indicates whether ready to read without blocking
    @Override
    public boolean ready() throws IOException {
        return super.ready();
    }

    // Legacy: mark support is passed through
    @Override
    public boolean markSupported() {
        return super.markSupported();
    }

    // Rarely Used: mark stream position
    @Override
    public void mark(int readAheadLimit) throws IOException {
        System.out.println("Marking position...");
        super.mark(readAheadLimit);
    }

    // Rarely Used: reset to marked position
    @Override
    public void reset() throws IOException {
        System.out.println("Resetting to mark...");
        super.reset();
    }

    // Essential: ensure resource is released
    @Override
    public void close() throws IOException {
        System.out.println("Closing stream...");
        super.close();
    }
}

