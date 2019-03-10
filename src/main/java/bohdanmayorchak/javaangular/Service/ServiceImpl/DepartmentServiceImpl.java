package bohdanmayorchak.javaangular.Service.ServiceImpl;

import bohdanmayorchak.javaangular.Service.DepartmentService;
import bohdanmayorchak.javaangular.dao.DepartmentDao;
import bohdanmayorchak.javaangular.dao.EmployeeDao;
import bohdanmayorchak.javaangular.models.Department;
import bohdanmayorchak.javaangular.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;
    private final EmployeeDao employeeDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao,EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao = employeeDao;
    }

    @Transactional
    @PostConstruct
    public void postConstruct(){
        Department department = new Department("Finance");
        Department department1 = new Department("Tech");
        this.departmentDao.save(department);
        this.departmentDao.save(department1);
        Employee employee1 = new Employee("Don",true);
        Employee employee2 = new Employee("Rick",true);
        Employee employee3 = new Employee("Bob",false);
        employee1.setDepartment(department);
        employee2.setDepartment(department);
        employee3.setDepartment(department1);
        this.employeeDao.save(employee1);
        this.employeeDao.save(employee2);
        this.employeeDao.save(employee3);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
