package sandbox.io.bufferedinputstream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO: refactor -> absolute PathDemoProject is tied to machine and not generic for enterprise level
/*        File file = new File("C:\\toy-projects\\springbackend\\src\\main\\java\\sandbox\\io\\bufferedinputstream\\input.txt");
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());
        System.out.println("Readable: " + file.canRead());

        String filePath = file.getAbsolutePath();*/

        /* Best Practices for File Access in Enterprise Java
        * Move your file to: src/main/resources/input.txt
        * Then access it like this: InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("input.txt");
        */
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("io/input.txt");

        if (inputStream == null) {
            throw new FileNotFoundException("input.txt not found in resources!");
        }

        try (BufferedInputStream bis = new BufferedInputStream(inputStream, 16);) {
            // 1. available()
            int availableBytes = bis.available();
            System.out.println("Available bytes before reading: " + availableBytes);

            // 2. read()
            int firstByte = bis.read();
            System.out.println("First byte read (as char): " + (char) firstByte);

            // 3. mark(int readlimit)
            if (bis.markSupported()) {
                bis.mark(32); // mark the position before reading more
                System.out.println("Marked stream at current position.");
            }

            // 4. read(byte[] b)
            byte[] buffer = new byte[10];
            int bytesRead = bis.read(buffer);
            System.out.println("Next 10 bytes read: " + new String(buffer, 0, bytesRead));

            // 5. skip(long n)
            long skipped = bis.skip(5);
            System.out.println("Skipped " + skipped + " bytes.");

            // 6. read(byte[], int, int)
            byte[] buffer2 = new byte[20];
            bytesRead = bis.read(buffer2, 5, 10); // read into offset 5
            System.out.println("Read into buffer2[5..15]: " + new String(buffer2, 5, bytesRead));

            // 7. reset()
            bis.reset();
            System.out.println("Reset to marked position.");

            byte[] postReset = new byte[10];
            bytesRead = bis.read(postReset);
            System.out.println("Read again after reset: " + new String(postReset, 0, bytesRead));

            // 8. close() - handled by try-with-resources

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
