package se.coredev.sdj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import se.coredev.sdj.data.Employee;

import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    @Query("SELECT e FROM #{#entityName} e WHERE e.address.zip = :zip")
    List<Employee> getAllEmployees(@Param("zip") String zip);

}
