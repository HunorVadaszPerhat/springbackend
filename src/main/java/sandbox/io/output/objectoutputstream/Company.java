package sandbox.io.output.objectoutputstream;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private String companyName;
    private List<Employee> employees;

    public Company(String companyName, List<Employee> employees) {
        this.companyName = companyName;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{companyName='" + companyName + "', employees=" + employees + "}";
    }
}

