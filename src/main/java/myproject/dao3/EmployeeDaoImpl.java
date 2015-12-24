package myproject.dao3;

import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends HibernateDao<Employee, Long> implements EmployeeDao {

    @Override
    public boolean removeEmployee(Employee employee) {
        
        return true;

    }
}
