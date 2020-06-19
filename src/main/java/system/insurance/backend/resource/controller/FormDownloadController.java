package system.insurance.backend.resource.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import system.insurance.backend.resource.service.FormDownloadService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/document")
public class FormDownloadController {
    private final FormDownloadService formDownloadService;

    public FormDownloadController(FormDownloadService formDownloadService) {
        this.formDownloadService = formDownloadService;
    }

    @GetMapping("/download")
    public FileSystemResource downloadForm(@RequestParam(name = "fileName")String fileName, HttpServletResponse res){
        res.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment");
        try {
            return new FileSystemResource(this.formDownloadService.downloadForm(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
