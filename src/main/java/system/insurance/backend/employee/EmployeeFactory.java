package system.insurance.backend.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EmployeeFactory {

    @Bean("Employee")
    @Scope("prototype")
    public Employee Employee(){
        return new Employee() {
        };
    }

    @Bean("SalesManager")
    @Scope("prototype")
    public Employee SalesManager(){
        return new SalesManager();
    }

    @Bean("SalesPerson")
    @Scope("prototype")
    public Employee SalesPerson(){
        return new SalesPerson();
    }
}
