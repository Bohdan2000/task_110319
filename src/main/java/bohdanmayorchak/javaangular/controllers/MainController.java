package bohdanmayorchak.javaangular.controllers;


import bohdanmayorchak.javaangular.Service.ServiceImpl.DepartmentServiceImpl;
import bohdanmayorchak.javaangular.Service.ServiceImpl.EmployeeServiceImpl;
import bohdanmayorchak.javaangular.models.Department;
import bohdanmayorchak.javaangular.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    private final DepartmentServiceImpl departmentServiceImpl;
    private final EmployeeServiceImpl employeeServiceImpl;

    public MainController(DepartmentServiceImpl departmentServiceImpl, EmployeeServiceImpl employeeServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/show")
    public List<Department> show(){
        return departmentServiceImpl.findAll();
    }

    @GetMapping("/details/{id}")
    public Employee showSingEmp(@PathVariable int id){
        return employeeServiceImpl.getById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody String employee ) throws IOException {
        Employee employee1 = new ObjectMapper().readValue(employee, Employee.class);
        employeeServiceImpl.save(employee1);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        employeeServiceImpl.deleteByEmpID(id);
    }
    
    @GetMapping("/findByName/{name}")
    public Employee findByName(@PathVariable String name){
        return employeeServiceImpl.findByEmpName(name);
    }

}
