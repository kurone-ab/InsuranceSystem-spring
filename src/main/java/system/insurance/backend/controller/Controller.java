package system.insurance.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("test")
    public void Test(@RequestBody String s) {
        System.out.println(s);
    }
}
