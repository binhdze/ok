package iuh.fit.demo1;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import  iuh.fit.demo1.util.JPAUtil;

/**
 * Admin 9/16/2025
 **/
@WebListener
public class Application implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JPAUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.destroy();
    }
}