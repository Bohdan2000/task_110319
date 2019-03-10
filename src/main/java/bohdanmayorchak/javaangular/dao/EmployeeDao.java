package bohdanmayorchak.javaangular.dao;


import bohdanmayorchak.javaangular.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    Employee getById(Integer id);
    Employee findByEmpName(String name);
}
