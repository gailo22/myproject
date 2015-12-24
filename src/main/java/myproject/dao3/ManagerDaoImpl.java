package myproject.dao3;

import org.springframework.stereotype.Repository;

@Repository("managerDao")
public class ManagerDaoImpl extends HibernateDao<Manager, Long> implements ManagerDao {

    @Override
    public boolean removeManager(Manager manager) {

        return true;
    }
}
