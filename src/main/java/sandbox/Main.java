package sandbox;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // TODO: write a method that makes a deeply nested path according to alphabet

        File directory = new File("file/file");
        try {
            if(!directory.exists()) {
                System.out.println("cherry");
                boolean isCreated = directory.mkdirs();
                System.out.println(isCreated);
                if(isCreated) {
                    System.out.println(directory.getAbsolutePath());
                    System.out.println(directory.exists());
                    System.out.println(directory.canRead());
                    System.out.println(directory.canWrite());
                    System.out.println(directory.getAbsoluteFile());
                    System.out.println(directory.getCanonicalFile());
                    System.out.println(directory.isDirectory());
                    throw new IOException("Could not create directory: " + directory);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
