package bohdanmayorchak.javaangular.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dpName;
    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE,
            mappedBy = "department"
    )
    private List<Employee> employees = new ArrayList<>();

    public Department(String dpName) {
        this.dpName = dpName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dpName='" + dpName + '\'' +
                '}';
    }
}
