package system.insurance.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import system.insurance.backend.announcement.Announcement;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.resource.repository.AnnouncementRepository;
import system.insurance.backend.resource.repository.EmployeeRepository;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
class BackendApplicationTests {

    private final EmployeeRepository employeeRepository;
    private final AnnouncementRepository announcementRepository;

    @Autowired
    public BackendApplicationTests(EmployeeRepository employeeRepository, AnnouncementRepository announcementRepository) {
        this.employeeRepository = employeeRepository;
        this.announcementRepository = announcementRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest() {


        List<Employee> employeeList = this.employeeRepository.findAll();
        Optional<Employee> employeeOptional = this.employeeRepository.findByUidAndPassword("sj99@pheonix.com", "psj");

        Employee employee = employeeList.get(1);
        assertEquals(employee.getName(), "박성제");
        assertTrue(employeeOptional.isPresent());
    }

    @Test
    void announcementTest() {
        Optional<Announcement> announcement = this.announcementRepository.findById(2);
        assertTrue(announcement.isPresent());
    }
}
