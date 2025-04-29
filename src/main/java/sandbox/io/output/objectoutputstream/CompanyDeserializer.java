package sandbox.io.output.objectoutputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CompanyDeserializer {
    public static void deserializeCompany(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            // Reading back the first Company object
            Company company1 = (Company) ois.readObject();
            System.out.println("First Company Loaded:");
            System.out.println(company1);

            // Reading the unshared Company object
            Company company2 = (Company) ois.readUnshared();
            System.out.println("Unshared Company Loaded:");
            System.out.println(company2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
