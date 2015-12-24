package myproject.dao3;

public interface EmployeeDao extends GenericDao<Employee, Long> {

    boolean removeEmployee(Employee employee);

}
