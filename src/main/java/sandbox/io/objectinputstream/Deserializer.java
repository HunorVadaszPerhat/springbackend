package sandbox.io.objectinputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/*
* ✅ Explanation of used methods:
    readObject() — restores object from file.
    available() — shows bytes that can be read (only an estimate, not exact!).
    close() — releases resources.
    readUnshared() — not used here fully because it’s meaningful when multiple objects are serialized.
* */
public class Deserializer {

    public static Object loadObject(String filename) {
        try (CustomObjectInputStream ois = new CustomObjectInputStream(new FileInputStream(filename))) {
            System.out.println("🔄 Available bytes: " + ois.available());

            Object obj = ois.readObject(); // Deserialize object — internally uses resolveClass()
            System.out.println("✅ Object loaded successfully from " + filename);

            return obj;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Error loading object: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Example for closing stream
    public static void closeStream(ObjectInputStream ois) {
        try {
            if (ois != null) {
                ois.close(); // Always close streams
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
