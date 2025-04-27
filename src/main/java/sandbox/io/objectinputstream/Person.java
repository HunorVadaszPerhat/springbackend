package sandbox.io.objectinputstream;

import java.io.Serializable;

/*
* ✅ Explanation:
    Serializable tells Java this class can be serialized.
    serialVersionUID protects against changes breaking deserialization.
    transient fields (like password) are not saved.
* */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Helps control class versioning

    private String name;
    private int age;
    private transient String password; // transient fields are NOT serialized

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}
