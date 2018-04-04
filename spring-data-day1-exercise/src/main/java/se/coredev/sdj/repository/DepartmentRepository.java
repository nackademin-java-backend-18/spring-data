package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;
import se.coredev.sdj.repository.data.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
