package sandbox.io.input.objectinputstream;

import org.apache.catalina.util.CustomObjectInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
* ✅ Explanation:
    writeObject() saves the object into a file.
* */
public class Serializer {

    public static void saveObject(String filename, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj); // Serializes the object
            System.out.println("Object saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
