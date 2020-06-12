package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.resource.service.FileStreamService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileStreamController {
    private FileStreamService fileStreamService;

    @Autowired
    public FileStreamController(FileStreamService fileStreamService) {
        this.fileStreamService = fileStreamService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Boolean> upload(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(this.fileStreamService.upload(file));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

}
