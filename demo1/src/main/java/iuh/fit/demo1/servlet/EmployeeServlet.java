package iuh.fit.demo1.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.fit.demo1.dao.DepartmentDAO;
import iuh.fit.demo1.dao.EmployeeDAO;
import iuh.fit.demo1.model.Department;
import iuh.fit.demo1.model.Employee;

import java.io.IOException;

/**
 * Admin 9/16/2025
 **/
@WebServlet("/employees")
public class
EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            req.setAttribute("departments", departmentDAO.findAll());


            if (action.equals("EDIT")) {
                Long id = Long.parseLong(req.getParameter("id"));
                req.setAttribute("employee", employeeDAO.findById(id));
            }


            req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
        } else {
            req.setAttribute("employees", employeeDAO.findAll());
            req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {

                case "DELETE" -> {
                    Long id = Long.parseLong(req.getParameter("id"));
                    employeeDAO.delete(id);
                    resp.sendRedirect("employees");
                }

                case "SAVE" -> {
                    String name = req.getParameter("name");
                    Long id = Long.parseLong(req.getParameter("id"));

                    double salary = Double.parseDouble(req.getParameter("salary"));
                    String departmentId = req.getParameter("departmentId");
                    Department department = departmentDAO.findById(Long.parseLong(departmentId));
                    Employee employee = new Employee(null, name, salary, department);

                    if (id != null) {
                        employeeDAO.update(id, employee);
                    } else {
                        employeeDAO.save(employee);
                    }


                    resp.sendRedirect("employees");
                }

            }
        }
    }
}
