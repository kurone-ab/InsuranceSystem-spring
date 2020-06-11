package system.insurance.backend.resource.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseBody;
import system.insurance.backend.contract.InsuranceCo;

import java.util.List;
import java.util.Map;

@Getter
public class InsuranceInfoDTO {
    private final Map<String, String> companyList;
    private final List<String> productList;
    private final Map<String, String> typeList;

    @Builder
    public InsuranceInfoDTO(Map<String, String> companyList, List<String> productList, Map<String, String> typeList){
        this.companyList = companyList;
        this.productList = productList;
        this.typeList = typeList;
    }
}
