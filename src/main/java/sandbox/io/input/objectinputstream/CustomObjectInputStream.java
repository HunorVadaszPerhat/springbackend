package sandbox.io.input.objectinputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class CustomObjectInputStream extends ObjectInputStream {

    public CustomObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        System.out.println("🔎 Resolving class: " + desc.getName());
        return super.resolveClass(desc); // Default behavior for now
    }
}
