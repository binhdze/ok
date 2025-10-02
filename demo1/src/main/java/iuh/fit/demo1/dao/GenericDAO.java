package iuh.fit.demo1.dao;


import iuh.fit.demo1.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 * Admin 9/16/2025
 **/
public class GenericDAO<T> {

    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public void save(T entity) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(entity);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            T entity = em.find(type, id);
            if (entity != null) em.remove(entity);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public T findById(Long id) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();

        try {
            return em.find(type, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }
}
