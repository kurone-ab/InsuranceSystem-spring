package system.insurance.backend;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Getter
@Setter
public class FileUploadProperties {
    private String uploadDir;
    private String insuranceAuthorizationDoc;
    private String insuranceEvaluationReport;
    private String companyReportTemplate;
}

