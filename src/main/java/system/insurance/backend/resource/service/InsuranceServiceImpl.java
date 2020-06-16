package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.FileUploadProperties;
import system.insurance.backend.exception.FileUploadException;
import system.insurance.backend.exception.InvalidIdentifierException;
import system.insurance.backend.insurance.*;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.repository.EvaluationReportRepository;
import system.insurance.backend.resource.repository.GuaranteeInfoRepository;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.repository.SalesTargetRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final Path authorizationDocPath;
    private final Path evaluationReportPath;

    private final InsuranceRepository insuranceRepository;
    private final GuaranteeInfoRepository guaranteeRepository;
    private final SalesTargetRepository salesTargetRepository;
    private final EvaluationReportRepository evaluationReportRepository;

    @Autowired
    public InsuranceServiceImpl(FileUploadProperties prop, InsuranceRepository insuranceRepository, GuaranteeInfoRepository guaranteeRepository, SalesTargetRepository salesTargetRepository, EvaluationReportRepository evaluationReportRepository) {
        this.insuranceRepository = insuranceRepository;
        this.guaranteeRepository = guaranteeRepository;
        this.salesTargetRepository = salesTargetRepository;
        this.evaluationReportRepository = evaluationReportRepository;
        this.authorizationDocPath = Paths.get(prop.getInsuranceAuthorizationDoc())
                .toAbsolutePath().normalize();
        this.evaluationReportPath = Paths.get(prop.getInsuranceEvaluationReport())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.authorizationDocPath);
            Files.createDirectories(this.evaluationReportPath);
        } catch (Exception e) {
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    @Override
    public Map<String, String> getInsuranceCompanyList() {
        Map<String, String> companyList = new HashMap<>();
        for (InsuranceCompany value : InsuranceCompany.values()) {
            companyList.put(value.name(), value.getDescription());
        }
        return companyList;
    }

    @Override
    public Map<String, String> getInsuranceTypeList() {
        Map<String, String> typeList = new HashMap<>();
        for (InsuranceType value : InsuranceType.values()) {
            typeList.put(value.name(), value.getDescription());
        }
        return typeList;
    }

    @Override
    public List<InsuranceDTO> getProductList() {
        List<InsuranceDTO> productList = new ArrayList<>();
        List<Insurance> insuranceList = this.insuranceRepository.findAll();
        insuranceList.forEach(insurance -> productList.add(InsuranceDTO.builder()
                .id(insurance.getId())
                .company(insurance.getCompany())
                .status(insurance.getStatus())
                .type(insurance.getType())
                .name(insurance.getName())
                .build()));
        return productList;
    }

    @Override
    public List<DevelopingInsuranceDTO> getDevelopingInsuranceList() {
        List<Insurance> list = this.insuranceRepository.findAllByStatus(InsuranceStatus.DEVELOPING);
        List<DevelopingInsuranceDTO> dtoList = new ArrayList<>();
        list.forEach(insurance -> dtoList.add(DevelopingInsuranceDTO.builder()
                .id(insurance.getId())
                .author(insurance.getAuthor().getName())
                .date(insurance.getDate())
                .name(insurance.getName())
                .build()));
        return dtoList;
    }

    @Override
    public Optional<InsuranceDTO> getInsuranceDetails(int id) {
        Optional<Insurance> insurance = this.insuranceRepository.findById(id);
        if (insurance.isPresent()) {
            Insurance i = insurance.get();
            List<GuaranteeInfo> guaranteeInfoList = this.guaranteeRepository.findAllByInsurance(i);
            List<SalesTarget> salesTargetList = this.salesTargetRepository.findAllByInsurance(i);
            List<EvaluationReport> evaluationReportList = this.evaluationReportRepository.findAllByInsurance(insurance.get());
            List<String> salesTargetStringList = new ArrayList<>();
            Map<String, Long> guaranteeInfoStringList = new HashMap<>();
            Map<Integer, String> evaluationInfo = new HashMap<>();

            guaranteeInfoList.forEach(guaranteeInfo -> guaranteeInfoStringList.put(guaranteeInfo.getGuaranteeCondition(), guaranteeInfo.getGuaranteeLimit()));
            salesTargetList.forEach(salesTarget -> salesTargetStringList.add(salesTarget.getTarget()));
            evaluationReportList.forEach(evaluationReport-> evaluationInfo.put(evaluationReport.getId(), evaluationReport.getDate() +
                    new File(evaluationReport.getPath()).getName()));
            return Optional.of(InsuranceDTO.builder()
                    .id(i.getId())
                    .guaranteeInfoList(guaranteeInfoStringList)
                    .salesTargetList(salesTargetStringList)
                    .evaluationReportList(evaluationInfo)
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public boolean uploadAuthorizationDoc(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains(".."))
            throw new FileUploadException("파일명에 부적절한 문자가 포함되어 있습니다. " + fileName);
        Path targetLocation = this.authorizationDocPath.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    @Override
    public boolean uploadEvaluationReport(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains(".."))
            throw new FileUploadException("파일명에 부적절한 문자가 포함되어 있습니다. " + fileName);
        Path targetLocation = this.evaluationReportPath.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    @Override
    public File downloadEvaluationReport(int id) throws InvalidIdentifierException {
        Optional<EvaluationReport> evaluationReport = this.evaluationReportRepository.findById(id);
        if (evaluationReport.isPresent()) return new File(evaluationReport.get().getPath());
        throw new InvalidIdentifierException();
    }


}
