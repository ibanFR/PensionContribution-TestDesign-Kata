package sammancoaching;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabaseAccessLayer implements DatabaseAccessLayer {

    Map<String, Double> namedConstants = new HashMap<>();
    Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employees.get(employeeId);
    }

    @Override
    public void saveEmployee(int employeeId, Employee employee) {
        employees.put(employeeId, employee);
    }

    @Override
    public double lookupValue(String namedConstant) {
        return namedConstants.get(namedConstant);
    }

    @Override
    public void saveValue(String namedConstant, double value) {
        namedConstants.put(namedConstant, value);
    }
}
