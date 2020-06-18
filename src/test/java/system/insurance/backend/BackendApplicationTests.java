package system.insurance.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system.insurance.backend.announcement.Announcement;
import system.insurance.backend.resource.repository.AnnouncementRepository;
import system.insurance.backend.resource.repository.ClientRepository;
import system.insurance.backend.resource.repository.GuaranteeInfoRepository;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
class BackendApplicationTests {
//    private final AnnouncementRepository announcementRepository;
//    private final ClientRepository clientRepository;
//    private final GuaranteeInfoRepository guaranteeInfoRepository;


    @Autowired
    public BackendApplicationTests(AnnouncementRepository announcementRepository, ClientRepository clientRepository, GuaranteeInfoRepository guaranteeInfoRepository) {
//        this.announcementRepository = announcementRepository;
//        this.clientRepository = clientRepository;
//        this.guaranteeInfoRepository = guaranteeInfoRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest() {

//        this.salesService.instructionRegister("예시 지침 1", "예시 지침1 입니다.");;
//        Assert.assertEquals(this.salesService.getSalesInstructionList().get(0).getAuthor(), "");


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

    @Test
    void fakeDataGeneration() {
//        for (int i = 0; i < 10; i++) {
//            this.announcementRepository.save(
//                    Announcement.builder()
//                            .title("예시 공지 "+i)
//                            .content("예시 공지 "+i)
//                            .date(Date.valueOf(LocalDate.now()))
//                            .build()
//            );
//        }
    }
}
