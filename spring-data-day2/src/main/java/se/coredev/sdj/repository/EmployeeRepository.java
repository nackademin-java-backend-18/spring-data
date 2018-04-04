package se.coredev.sdj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import se.coredev.sdj.data.Employee;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    @Query("SELECT e FROM #{#entityName} e WHERE e.address.zip = :zip")
    List<Employee> getAllEmployees(@Param("zip") String zip);

    @Query("SELECT e FROM #{#entityName} e WHERE e.address.zip like :zip%")
    Page<Employee> searchEmployeeByZip(@Param("zip") String zip, Pageable pageable);

}
