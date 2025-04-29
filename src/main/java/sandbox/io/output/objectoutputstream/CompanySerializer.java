package sandbox.io.output.objectoutputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


/*
* ✅ Covers:
    writeObject
    flush
    reset
    writeUnshared
    close (via try-with-resources)
* */
public class CompanySerializer {
    public static void serializeCompany(Company company, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {

            // Basic writing
            oos.writeObject(company);
            // Writes the entire company object (graph of employees too)

            // Flush the stream to make sure all bytes are pushed out
            oos.flush();

            // Reset the stream's memory of written objects
            oos.reset();
            // If you write the same object later, it will be treated as new.

            // Write an "unshared" object (different reference even if logically same)
            oos.writeUnshared(company);

            // Flush again before close
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

