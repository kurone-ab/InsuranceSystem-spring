package system.insurance.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.service.InsuranceService;
import system.insurance.backend.resource.service.SalesService;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class BackendApplicationTests {

    private final SalesService salesService;

    @Autowired
    public BackendApplicationTests(SalesService salesService) {
        this.salesService = salesService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest() {
//        this.salesService.instructionRegister("예시 지침 1", "예시 지침1 입니다.");;
        Assert.assertEquals(this.salesService.getSalesInstructionList().get(0).getAuthor(), "");


//        List<Employee> employeeList = this.employeeRepository.findAll();
//        Optional<Employee> employeeOptional = this.employeeRepository.findByUidAndPassword("sj99@pheonix.com", "psj");
//
//        Employee employee = employeeList.get(1);
//        assertEquals(employee.getName(), "박성제");
//        assertTrue(employeeOptional.isPresent());
    }

    @Test
    void announcementTest() {
//        Optional<Announcement> announcement = this.announcementRepository.findById(2);
//        assertTrue(announcement.isPresent());
    }

    @Test
    void insuranceTest() {
//        List<InsuranceDTO> dto = this.insuranceService.getInsuranceProductList();
//        log.warn(dto.get(0).toString());
    }
}
