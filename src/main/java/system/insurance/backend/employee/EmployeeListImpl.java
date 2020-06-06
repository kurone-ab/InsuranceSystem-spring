package system.insurance.backend.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import system.insurance.backend.client.Sex;
import system.insurance.backend.exception.NoEmployeeException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class EmployeeListImpl implements EmployeeList {

	private final ArrayList<Employee> employees;
	private static final long serialVersionUID = 1L;

	public EmployeeListImpl() {
		employees = new ArrayList<>();
	}

	public boolean createEmp(Employee emp) {
		if (emp != null) return employees.add(emp);
		return false;
	}

	public boolean deleteById(int id) throws NoEmployeeException {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employees.remove(employee);
			}
		}
		throw new NoEmployeeException();
	}

	public Employee retrieveById(int id) throws NoEmployeeException {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		throw new NoEmployeeException();
	}

	@Override
	public Employee retrieveByUid(String uid) throws NoEmployeeException {
		for (Employee employee : employees) {
			if (Objects.equals(employee.getUid(), uid)) {
				return employee;
			}
		}
		throw new NoEmployeeException();
	}

	public EmployeeListImpl retrieveByName(String name) {
		EmployeeListImpl temp = new EmployeeListImpl();

		for (Employee employee : employees) {
			if (Objects.equals(employee.getName(), name)) {
				temp.createEmp(employee);
			}
		}

		return temp;
	}

	public EmployeeListImpl retrieveByPhoneNum(String phoneNum) {
		EmployeeListImpl temp = new EmployeeListImpl();

		for (Employee employee : employees) {
			if (Objects.equals(employee.getPhoneNum(), phoneNum)) {
				temp.createEmp(employee);
			}
		}

		return temp;
	}
}
