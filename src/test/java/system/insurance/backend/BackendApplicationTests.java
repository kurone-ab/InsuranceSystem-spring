package system.insurance.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.service.InsuranceService;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class BackendApplicationTests {

    private final InsuranceService insuranceService;

    @Autowired
    public BackendApplicationTests(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest() {


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
        List<InsuranceDTO> dto = this.insuranceService.getInsuranceProductList();
        log.warn(dto.get(0).toString());
    }
}
