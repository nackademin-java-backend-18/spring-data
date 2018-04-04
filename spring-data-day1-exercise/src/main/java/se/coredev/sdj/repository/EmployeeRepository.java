package se.coredev.sdj.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import se.coredev.sdj.repository.data.Employee;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String name);

    @Query("SELECT e FROM #{#entityName} e WHERE e.firstName = :fname AND e.lastName = :lname")
    List<Employee> getEmployees(@Param("fname") String firstName, @Param("lname") String lastName);



}
