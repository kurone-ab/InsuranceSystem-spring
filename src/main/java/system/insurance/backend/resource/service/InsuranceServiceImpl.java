package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.FileUploadProperties;
import system.insurance.backend.exception.FileUploadException;
import system.insurance.backend.insurance.*;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDetailsDTO;
import system.insurance.backend.resource.repository.GuaranteeInfoRepository;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.repository.SalesTargetRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final Path fileLocation;

    private final InsuranceRepository insuranceRepository;
    private final GuaranteeInfoRepository guaranteeRepository;
    private final SalesTargetRepository salesTargetRepository;

    @Autowired
    public InsuranceServiceImpl(FileUploadProperties prop, InsuranceRepository insuranceRepository, GuaranteeInfoRepository guaranteeRepository, SalesTargetRepository salesTargetRepository) {
        this.insuranceRepository = insuranceRepository;
        this.guaranteeRepository = guaranteeRepository;
        this.salesTargetRepository = salesTargetRepository;
        this.fileLocation = Paths.get(prop.getInsuranceAuthorizationDoc())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileLocation);
        }catch(Exception e) {
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
    public Optional<InsuranceDetailsDTO> getInsuranceDetails(int id) {
        Optional<Insurance> insurance = this.insuranceRepository.findById(id);
        if (insurance.isPresent()) {
            Insurance i = insurance.get();
            List<GuaranteeInfo> guaranteeInfoList = this.guaranteeRepository.findAllByInsurance(i);
            List<SalesTarget> salesTargetList = this.salesTargetRepository.findAllByInsurance(i);
            List<String> salesTargetStringList = new ArrayList<>();
            Map<String, Long> guaranteeInfoStringList = new HashMap<>();
            guaranteeInfoList.forEach(guaranteeInfo -> guaranteeInfoStringList.put(guaranteeInfo.getGuaranteeCondition(), guaranteeInfo.getGuaranteeLimit()));
            salesTargetList.forEach(salesTarget -> salesTargetStringList.add(salesTarget.getTarget()));
            return Optional.of(InsuranceDetailsDTO.builder()
                    .id(i.getId())
                    .name(i.getName())
                    .type(i.getType())
                    .status(i.getStatus())
                    .guaranteeInfoList(guaranteeInfoStringList)
                    .salesTargetList(salesTargetStringList)
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> uploadAuthorizationDoc(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if(fileName.contains(".."))
            throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
        Path targetLocation = this.fileLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return Optional.of(true);
    }
}
