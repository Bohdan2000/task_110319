package bohdanmayorchak.javaangular.Service.ServiceImpl;

import bohdanmayorchak.javaangular.Service.EmployeeService;
import bohdanmayorchak.javaangular.dao.EmployeeDao;
import bohdanmayorchak.javaangular.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteByEmpID(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findByEmpName(String name) {
        return employeeDao.findByEmpName(name);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
