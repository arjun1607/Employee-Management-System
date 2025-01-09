package project.ems_backend.service;

import project.ems_backend.dto.EmployeeDto;
import project.ems_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void deleteEmployee(Long employeeId);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long employeeId);

}
