package system.insurance.backend.employee;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import system.insurance.backend.client.Sex;

@Configuration
public class EmployeeListConf {

    @Bean("EmployeeList")
    @Scope("prototype")
    public EmployeeList EmployeeList() {
        return new EmployeeListImpl();
    }

    @Bean("SampleEmployeeList")
    @Qualifier("Employee")
    public EmployeeList SampleEmployeeList(){
        EmployeeList employeeList = new EmployeeListImpl();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConf.class);
        Employee employee;
        employee = ctx.getBean("Employee", Employee.class);
        employee.setSex(Sex.male);
        employee.setName("김만수");
        employee.setAge(22);
        employee.setAuthority(Authority.admin);
        employee.setUid("ms99@pheonix.com");
        employee.setPassword("kms");
        employeeList.createEmp(employee);
        employee = ctx.getBean("Employee", Employee.class);
        employee.setSex(Sex.male);
        employee.setName("박성제");
        employee.setAge(22);
        employee.setAuthority(Authority.admin);
        employee.setUid("sj99@pheonix.com");
        employee.setPassword("psj");
        employeeList.createEmp(employee);
        employee = ctx.getBean("Employee", Employee.class);
        employee.setSex(Sex.male);
        employee.setName("박정욱");
        employee.setAge(22);
        employee.setAuthority(Authority.admin);
        employee.setUid("jw98@pheonix.com");
        employee.setPassword("pjw");
        employeeList.createEmp(employee);
        return employeeList;
    }
}
