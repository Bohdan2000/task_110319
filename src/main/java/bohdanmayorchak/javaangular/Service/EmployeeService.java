package bohdanmayorchak.javaangular.Service;

import bohdanmayorchak.javaangular.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee getById(Integer id);
    void save(Employee employee);
    void deleteByEmpID(int id);
    Employee findByEmpName(String name);
}
