package iuh.fit.demo1.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

/**
 * Admin 9/16/2025
 **/
public class JPAUtil {

    @Getter
    private static EntityManagerFactory emf;

    public static void init() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("default");
    }

    public static void destroy() {
        if (emf.isOpen())
            emf.close();
    }

}
