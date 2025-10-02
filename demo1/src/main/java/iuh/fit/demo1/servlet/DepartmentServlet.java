package iuh.fit.demo1.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.fit.demo1.dao.DepartmentDAO;
import iuh.fit.demo1.model.Department;

import java.io.IOException;

/**
 * Admin 9/16/2025
 **/
@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {

    private DepartmentDAO departmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            Long id = Long.parseLong(req.getParameter("id"));
            Department department = departmentDAO.findById(id);
            req.setAttribute("department", department);

            req.getRequestDispatcher("department-form.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        if (name != null)
            req.setAttribute("departments", departmentDAO.findByName(name));
        else
            req.setAttribute("departments", departmentDAO.findAll());


        req.getRequestDispatcher("department-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    Long id = Long.parseLong(req.getParameter("id"));
                    departmentDAO.delete(id);
                    resp.sendRedirect("departments");
                }

                case "SAVE" -> {
                    String id = req.getParameter("id");
                    String name = req.getParameter("name");

                    if (id != null) {
                        Department newDepartment = new Department(null, name, null);
                        departmentDAO.update(Long.parseLong(id), newDepartment);
                    } else {
                        Department department = new Department(null, name, null);
                        departmentDAO.save(department);
                    }


                    resp.sendRedirect("departments");
                }

            }
        }

    }
}