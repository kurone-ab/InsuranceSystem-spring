package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.FileUploadProperties;
import system.insurance.backend.exception.FileDownloadException;
import system.insurance.backend.exception.FileUploadException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStreamServiceImpl implements FileStreamService {
    private final Path fileLocation;

    @Autowired
    public FileStreamServiceImpl(FileUploadProperties prop) {
        this.fileLocation = Paths.get(prop.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    @Override
    public boolean upload(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if(fileName.contains(".."))
            throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
        Path targetLocation = this.fileLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    @Override
    public File download(String fileName) {
        Path filePath = this.fileLocation.resolve(fileName).normalize();
        File file = new File(filePath.toAbsolutePath().toString());

        if(file.exists()) {
            return file;
        }else {
            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
        }
    }
}
