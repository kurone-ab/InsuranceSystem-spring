package system.insurance.backend.employee;

import system.insurance.backend.exception.NoEmployeeException;

public interface EmployeeList {

    boolean createEmp(Employee emp);

    boolean deleteById(int id) throws NoEmployeeException;

    Employee retrieveById(int id) throws NoEmployeeException;

    Employee retrieveByUid(String uid) throws NoEmployeeException;

    EmployeeListImpl retrieveByName(String name) throws NoEmployeeException;

    EmployeeListImpl retrieveByPhoneNum(String phoneNum) throws NoEmployeeException;
}
