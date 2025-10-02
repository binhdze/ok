package iuh.fit.demo1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import iuh.fit.demo1.model.Department;
import iuh.fit.demo1.model.Employee;
import iuh.fit.demo1.util.JPAUtil;

import java.util.List;

/**
 * Admin 9/16/2025
 **/
public class EmployeeDAO extends GenericDAO<Employee> {

    public EmployeeDAO() {
        super(Employee.class);
    }

    public List<Employee> findAll() {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM Employee e
                    """;

            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public void update(Long id, Employee newEmployee) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, id);
            if (employee != null) {
                employee.setName(newEmployee.getName());
                employee.setSalary(newEmployee.getSalary());
                employee.setDepartment(newEmployee.getDepartment());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}