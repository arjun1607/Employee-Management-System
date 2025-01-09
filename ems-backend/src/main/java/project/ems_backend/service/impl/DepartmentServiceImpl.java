package project.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.ems_backend.Mapper.DepartmentMapper;
import project.ems_backend.dto.DepartmentDto;
import project.ems_backend.entity.Department;
import project.ems_backend.exception.ResourceNotFoundException;
import project.ems_backend.repository.DepartmentRepository;
import project.ems_backend.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartment(Long departmentId){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()->new ResourceNotFoundException("no dept exist for given id"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment(){
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()->new ResourceNotFoundException("department does not exist for given id"));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId){
        departmentRepository.findById(departmentId)
                        .orElseThrow(()-> new ResourceNotFoundException("department does not exist for given id"));

        departmentRepository.deleteById(departmentId);
    }
}
