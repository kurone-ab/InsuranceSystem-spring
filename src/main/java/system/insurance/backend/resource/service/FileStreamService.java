package system.insurance.backend.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public interface FileStreamService {
    boolean upload(MultipartFile file) throws IOException;
    File download(String fileName);
}
