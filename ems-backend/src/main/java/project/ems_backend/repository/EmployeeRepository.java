package project.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ems_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
