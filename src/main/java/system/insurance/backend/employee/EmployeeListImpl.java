package system.insurance.backend.employee;

import system.insurance.backend.client.Sex;
import system.insurance.backend.exception.NoEmployeeException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeListImpl extends ArrayList<Employee> implements EmployeeList {
	private static final long serialVersionUID = 1L;

	public EmployeeListImpl() {
	}

	public boolean createEmp(Employee emp) {
		if (emp != null) return this.add(emp);
		return false;
	}

	public boolean deleteById(int id) throws NoEmployeeException {
		for (Employee employee : this) {
			if (employee.getId() == id) {
				return this.remove(employee);
			}
		}
		throw new NoEmployeeException();
	}

	public Employee retrieveById(int id) throws NoEmployeeException {
		for (Employee employee : this) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		throw new NoEmployeeException();
	}

	@Override
	public Employee retrieveByUid(String uid) throws NoEmployeeException {
		for (Employee employee : this) {
			if (Objects.equals(employee.getUid(), uid)) {
				return employee;
			}
		}
		throw new NoEmployeeException();
	}

	public EmployeeListImpl retrieveByName(String name) {
		EmployeeListImpl temp = new EmployeeListImpl();

		for (Employee employee : this) {
			if (Objects.equals(employee.getName(), name)) {
				temp.add(employee);
			}
		}

		return temp;
	}

	public EmployeeListImpl retrieveByPhoneNum(String phoneNum) {
		EmployeeListImpl temp = new EmployeeListImpl();

		for (Employee employee : this) {
			if (Objects.equals(employee.getPhoneNum(), phoneNum)) {
				temp.add(employee);
			}
		}

		return temp;
	}
}
