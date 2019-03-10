package bohdanmayorchak.javaangular.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empName;
    private boolean empActive;
    @JsonBackReference
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE

    )
    private Department department;

    public Employee(String empName, boolean empActive) {
        this.empName = empName;
        this.empActive = empActive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empActive=" + empActive +
                '}';
    }
}
