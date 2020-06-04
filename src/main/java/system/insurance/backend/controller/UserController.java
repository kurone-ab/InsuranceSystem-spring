package system.insurance.backend.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.employee.EmployeeList;
import system.insurance.backend.employee.EmployeeListConf;
import system.insurance.backend.employee.ResponseEmployee;
import system.insurance.backend.exception.NoEmployeeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeListConf.class);
    private final EmployeeList sampleEmployeeList = ctx.getBean("SampleEmployeeList", EmployeeList.class);

    @PostMapping("/login")
    public ResponseEmployee loginUserCertification(@RequestBody String json, HttpServletResponse res) {
        System.out.println(json);
        res.setHeader("Access-Control-Allow-Credentials", "true");
        JSONParser parser = new JSONParser(json);
        Map<String, Object> parsedJson;
        try {
            parsedJson = parser.object();
            String id = (String) parsedJson.get("id"), password = (String) parsedJson.get("password");
            Employee employee = sampleEmployeeList.retrieveByUid(id);
            if (employee.getPassword().equals(password)) {
                System.out.println("login complete");
                return new ResponseEmployee(employee.getId(), employee.getName(), employee.getAuthority().name());
            } else return new ResponseEmployee("비밀번호를 다시 확인해주세요!");
        } catch (ParseException | NoEmployeeException e) {
            e.printStackTrace();
            return new ResponseEmployee(e.getMessage());
        }
    }

    @PostMapping("/auth")
    public void accessUserAuthentication(@RequestBody String json, HttpServletResponse res, HttpServletRequest req) {
        System.out.println(json);
        res.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
