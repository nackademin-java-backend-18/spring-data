package se.coredev.sdj.service;

import org.springframework.stereotype.Component;
import se.coredev.sdj.data.Employee;
import se.coredev.sdj.repository.EmployeeRepository;

@Component
public final class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        // Check if... the store...
        return repository.save(employee);
    }

}
