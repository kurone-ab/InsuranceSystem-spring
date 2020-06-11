package system.insurance.backend.resource.service;

import system.insurance.backend.employee.Authority;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.response.EmployeeDTO;

public interface UserCertificationService {
    EmployeeDTO login(String uid, String password) throws NoEmployeeException;
    boolean authCheck(int id, Authority authority) throws NoEmployeeException;
}
