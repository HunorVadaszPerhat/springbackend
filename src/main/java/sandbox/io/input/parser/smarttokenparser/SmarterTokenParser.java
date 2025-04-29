package sandbox.io.input.parser.smarttokenparser;

import java.io.*;

public class SmarterTokenParser {
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
                        classifyAndPrint(tokenBuffer.toString());
                        tokenBuffer.reset();
                    }
                    if (!Character.isWhitespace(ch)) {
                        // Push back separator
                        input.unread(ch);
                        data = input.read(); // Read again
                        classifyAndPrint(Character.toString((char) data));
                    }
                }
            }
            if (tokenBuffer.size() > 0) {
                classifyAndPrint(tokenBuffer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void classifyAndPrint(String token) {
        if (token.chars().allMatch(Character::isDigit)) {
            System.out.println("Number: " + token);
        } else if (token.chars().allMatch(Character::isLetter)) {
            System.out.println("Word: " + token);
        } else {
            System.out.println("Symbol: " + token);
        }
    }
}

