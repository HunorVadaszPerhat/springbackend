package sandbox.io.output.objectoutputstream;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 1001, "secret123");
        Employee e2 = new Employee("Bob", 1002, "hidden456");

        Company company = new Company("OpenAI Corp", Arrays.asList(e1, e2));

        String filename = "company.ser";

        // Serialize
        CompanySerializer.serializeCompany(company, filename);

        // Deserialize
        CompanyDeserializer.deserializeCompany(filename);
    }
}

