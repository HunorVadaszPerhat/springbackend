package sandbox.io.experiments.parser.simpletokenparser;

import java.io.*;

public class SimpleTokenParser {
    public static void main(String[] args) {
        try (PushbackInputStream input = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream("data/input.txt")))) {

            ByteArrayOutputStream tokenBuffer = new ByteArrayOutputStream();
            int data;
            while ((data = input.read()) != -1) {
                char ch = (char) data;
                if (Character.isLetterOrDigit(ch)) {
                    tokenBuffer.write(ch);
                } else {
                    if (tokenBuffer.size() > 0) {
                        System.out.println(tokenBuffer.toString());
                        tokenBuffer.reset();
                    }
                    if (!Character.isWhitespace(ch)) {
                        // Push back separator to treat as its own token
                        input.unread(ch);
                        data = input.read(); // Read again
                        System.out.println((char) data);
                    }
                }
            }
            if (tokenBuffer.size() > 0) {
                System.out.println(tokenBuffer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

