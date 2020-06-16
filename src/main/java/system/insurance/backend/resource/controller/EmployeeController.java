package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    public EmployeeController(){
        
    }
}