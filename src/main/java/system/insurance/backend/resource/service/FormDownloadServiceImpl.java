package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.insurance.backend.FileUploadProperties;
import system.insurance.backend.exception.FileDownloadException;
import system.insurance.backend.exception.FileUploadException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FormDownloadServiceImpl implements FormDownloadService{
    private final Path fileLocation;

    @Autowired
    public FormDownloadServiceImpl(FileUploadProperties prop) {
        this.fileLocation = Paths.get(prop.getCompanyReportTemplate())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    @Override
    public File downloadForm(String fileName) throws IOException {
        Path filePath = this.fileLocation.resolve(fileName).normalize();
        System.out.println();
        File file = new File(filePath.toAbsolutePath().toString());
        if(file.exists()) {
            return file;
        }else {
            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
        }
    }
}
