package sandbox.io.output.objectoutputstream;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int id;
    private transient String password; // This won't be serialized automatically!

    public Employee(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + ", password='" + password + "'}";
    }
}
