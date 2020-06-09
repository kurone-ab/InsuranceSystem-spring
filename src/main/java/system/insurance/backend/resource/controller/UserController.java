package system.insurance.backend.resource.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.ResponseEmployee;
import system.insurance.backend.resource.service.UserCertificationService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserCertificationService userCertificationService;

    @Autowired
    public UserController(UserCertificationService userCertificationService) {
        this.userCertificationService = userCertificationService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEmployee loginUserCertification(@RequestBody String json, HttpServletResponse res) {
        System.out.println(json);
        res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        JSONParser parser = new JSONParser(json);
        Map<String, Object> parsedJson;
        try {
            parsedJson = parser.object();
            String id = (String) parsedJson.get("id"), password = (String) parsedJson.get("password");
            return this.userCertificationService.login(id, password);
        } catch (ParseException | NoEmployeeException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/file{id}")
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("id") String id, HttpServletResponse res){
        res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        res.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment");
        System.out.println(id);
        return new FileSystemResource(new File("E://오버로드+13.pdf"));
    }
}
