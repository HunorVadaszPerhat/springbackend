package sandbox.io.filterinputstream;

import java.io.*;

public class StreamInspector {

    public static void main(String[] args) {
        File file = new File("input.dat");

        // Ensure file exists
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write("This is a test input for FilterInputStream demo.".getBytes());
            } catch (IOException e) {
                System.err.println("Failed to create input file.");
                return;
            }
        }

        try (InputStream fileStream = new FileInputStream(file);
             FilterInputStream filterStream = new CustomFilterInputStream(new BufferedInputStream(fileStream))) {

            System.out.println("Available bytes at start: " + filterStream.available()); // Advanced

            byte[] buffer = new byte[10];
            int bytesRead = filterStream.read(buffer); // Essential
            System.out.println("Read bytes: " + new String(buffer, 0, bytesRead));

            filterStream.mark(20); // Legacy
            System.out.println("Marked stream after reading 10 bytes.");

            bytesRead = filterStream.read(buffer); // Essential again
            System.out.println("Read more bytes: " + new String(buffer, 0, bytesRead));

            if (filterStream.markSupported()) { // Rarely Used
                filterStream.reset(); // Legacy
                System.out.println("Stream reset to marked position.");
                bytesRead = filterStream.read(buffer); // Re-read
                System.out.println("Re-read after reset: " + new String(buffer, 0, bytesRead));
            }

            long skipped = filterStream.skip(5); // Advanced
            System.out.println("Skipped bytes: " + skipped);

            bytesRead = filterStream.read(buffer); // Final read
            System.out.println("Final read: " + new String(buffer, 0, bytesRead));

            // `close()` will be called automatically due to try-with-resources

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Custom filter that logs byte count — shows how to extend FilterInputStream
    static class CustomFilterInputStream extends FilterInputStream {
        private int totalBytesRead = 0;

        protected CustomFilterInputStream(InputStream in) {
            super(in); // Essential constructor use
        }

        @Override
        public int read() throws IOException {
            int b = super.read();
            if (b != -1) totalBytesRead++;
            return b;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int result = super.read(b, off, len); // Essential 3-arg read
            if (result > 0) totalBytesRead += result;
            return result;
        }

        @Override
        public void close() throws IOException {
            super.close(); // Essential for cleanup
            System.out.println("Total bytes read: " + totalBytesRead);
        }
    }
}
