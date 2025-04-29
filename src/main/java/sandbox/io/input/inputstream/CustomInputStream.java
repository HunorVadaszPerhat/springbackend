package sandbox.io.input.inputstream;

import java.io.ByteArrayInputStream;

public class CustomInputStream {

    public static ByteArrayInputStream getMarkedStream() {
        String content = "MarkTestStream";
        return new ByteArrayInputStream(content.getBytes());
    }
}