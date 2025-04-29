package sandbox.io.input.parser.advancedtokenparser;

import java.io.*;
import java.util.Set;

public class AdvancedTokenParser {

    private static final Set<String> MULTI_CHAR_SYMBOLS = Set.of(
            "==", "!=", ">=", "<=", "++", "--", "&&", "||", "::"
    );

    public static void main(String[] args) {
        try (PushbackInputStream input = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream("data/input.txt")), 2)) { // buffer size 2 for pushback

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
                        handleSymbol(input, ch);
                    }
                }
            }

            // Handle leftover token at end of file
            if (tokenBuffer.size() > 0) {
                classifyAndPrint(tokenBuffer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleSymbol(PushbackInputStream input, char first) throws IOException {
        int secondData = input.read();
        if (secondData != -1) {
            char second = (char) secondData;
            String combined = "" + first + second;

            if (MULTI_CHAR_SYMBOLS.contains(combined)) {
                System.out.println("Symbol: " + combined);
            } else {
                input.unread(second); // Push back second character
                System.out.println("Symbol: " + first);
            }
        } else {
            System.out.println("Symbol: " + first);
        }
    }

    private static void classifyAndPrint(String token) {
        if (token.chars().allMatch(Character::isDigit)) {
            System.out.println("Number: " + token);
        } else if (token.chars().allMatch(Character::isLetter)) {
            System.out.println("Word: " + token);
        } else {
            System.out.println("Mixed/Unknown: " + token);
        }
    }
}

