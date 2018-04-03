package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;
import se.coredev.sdj.data.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);
    List<Employee> findByAddressZip(String zip);
}
