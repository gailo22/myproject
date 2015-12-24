package myproject.dao3;

public interface ManagerDao extends GenericDao<Manager, Long> {

    boolean removeManager(Manager manager);
}
