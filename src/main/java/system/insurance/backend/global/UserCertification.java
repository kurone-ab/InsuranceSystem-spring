package system.insurance.backend.global;

import system.insurance.backend.employee.Employee;
import system.insurance.backend.employee.EmployeeListImpl;
import system.insurance.backend.exception.NoEmployeeException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class UserCertification extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        EmployeeListImpl employees = (EmployeeListImpl) session.getAttribute(SessionAttribute.list.name());
        session.removeAttribute(SessionAttribute.list.name());
        String id = req.getParameter("id"), pw = req.getParameter("password");
        try {
            Employee employee = employees.retrieveByUid(id);
            if (Objects.equals(employee.getPassword(), pw)) {
                session.setAttribute(SessionAttribute.id.name(), employee.getId());
                session.setAttribute(SessionAttribute.name.name(), employee.getName());
                session.setAttribute(SessionAttribute.auth.name(), employee.getAuthority());
                session.setAttribute(SessionAttribute.normal.name(), SessionAttribute.normal);
                resp.sendRedirect("index.jsp");
            } else {
                session.setAttribute("error", "Password Error");
                resp.sendRedirect("login.jsp");
            }
        } catch (NoEmployeeException e) {
            session.setAttribute("error", "No Employee");
            resp.sendRedirect("login.jsp");
        }
    }
}
