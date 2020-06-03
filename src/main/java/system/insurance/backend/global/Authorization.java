package system.insurance.backend.global;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authorization extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authority = req.getParameter("auth");
        String requirements = req.getParameter("req");
        if (authority.contains(requirements) || authority.equals("admin")) resp.setHeader("auth", "permission");
        else resp.setHeader("auth", "denied");
    }
}
