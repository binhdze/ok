package iuh.fit.demo1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import iuh.fit.demo1.model.Department;
import iuh.fit.demo1.util.JPAUtil;

import java.util.List;
public class DepartmentDAO extends GenericDAO<Department> {

    public DepartmentDAO() {
        super(Department.class);
    }

    public List<Department> findAll() {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                     SELECT d FROM Department d
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public List<Department> findByName(String deptName) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT d FROM Department d
                    WHERE d.name LIKE :name
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            query.setParameter("name", "%" + deptName + "%");

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public void update(Long id, Department newDepartment) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            Department department = em.find(Department.class, id);
            if (department != null)
                department.setName(newDepartment.getName());

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


}

