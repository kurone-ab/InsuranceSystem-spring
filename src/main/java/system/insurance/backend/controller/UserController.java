package system.insurance.backend.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.employee.EmployeeList;
import system.insurance.backend.employee.EmployeeListConf;
import system.insurance.backend.employee.ResponseEmployee;
import system.insurance.backend.exception.NoEmployeeException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("login")
    public ResponseEmployee loginUserCertification(@RequestBody String json, HttpServletResponse res) {
        System.out.println(json);
        JSONParser parser = new JSONParser(json);
        Map<String, Object> parsedJson;
        try {
            parsedJson = parser.object();
            String id = (String) parsedJson.get("id"), password = (String) parsedJson.get("password");
            ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeListConf.class);
            EmployeeList employeeList = ctx.getBean("SampleEmployeeList", EmployeeList.class);
            Employee employee = employeeList.retrieveByUid(id);
            if (employee.getPassword().equals(password)) {
                System.out.println("login complete");
                res.setHeader("Access-Control-Allow-Credentials", "true");
                return new ResponseEmployee(employee.getId(), employee.getName(), employee.getAuthority().name());
            } else {
                return new ResponseEmployee("password error");
            }
        } catch (ParseException | NoEmployeeException e) {
            e.printStackTrace();
            return new ResponseEmployee(e.getMessage());
        }
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("auth")
    public void accessUserAuthentication(@RequestBody String json) {
        System.out.println(json);
    }
}
