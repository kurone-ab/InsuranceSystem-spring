package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.insurance.backend.employee.Authority;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.ResponseEmployee;
import system.insurance.backend.resource.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class UserCertificationServiceImpl implements UserCertificationService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserCertificationServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEmployee login(String uid, String password) throws NoEmployeeException {
        Optional<Employee> dbData = this.employeeRepository.findByUidAndPassword(uid, password);
        Employee employee = dbData.orElseThrow(NoEmployeeException::new);
        return ResponseEmployee.builder()
                .id(employee.getId())
                .name(employee.getName())
                .auth(employee.getAuthority().getAuth())
                .build();
    }

    @Override
    public boolean authCheck(int id, Authority authority) throws NoEmployeeException {
        Optional<Employee> dbData = this.employeeRepository.findById(id);
        return dbData.orElseThrow(NoEmployeeException::new).getAuthority() == authority;
    }
}
