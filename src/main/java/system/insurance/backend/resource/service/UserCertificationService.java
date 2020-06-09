package system.insurance.backend.resource.service;

import org.springframework.stereotype.Service;
import system.insurance.backend.employee.Authority;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.ResponseEmployee;

@Service
public interface UserCertificationService {
    ResponseEmployee login(String uid, String password) throws NoEmployeeException;
    boolean authCheck(int id, Authority authority) throws NoEmployeeException;
}
