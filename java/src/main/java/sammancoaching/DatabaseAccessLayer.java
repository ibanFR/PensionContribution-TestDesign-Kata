package sammancoaching;

public interface DatabaseAccessLayer {

    Employee getEmployeeById(int employeeId);

    void saveEmployee(int employeeId, Employee juniorEmployee);

    double lookupValue(String namedConstant);

    void saveValue(String namedConstant, double value);


}
