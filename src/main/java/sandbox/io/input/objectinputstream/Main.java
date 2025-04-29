package sandbox.io.input.objectinputstream;

/*
* ✅ Explanation:
    Saves (serialize) a Person.
    Loads (deserialize) a Person.
    Shows how the transient field is not restored.
* */
public class Main {
    public static void main(String[] args) {
        String filename = "person.ser";

        // Create a person
        Person person = new Person("Alice", 30, "superSecretPassword");

        // Save the person
        Serializer.saveObject(filename, person);

        // Load the person
        Person loadedPerson = (Person) Deserializer.loadObject(filename);

        // Show the deserialized person
        System.out.println("👤 Deserialized Person: " + loadedPerson);
    }
}
