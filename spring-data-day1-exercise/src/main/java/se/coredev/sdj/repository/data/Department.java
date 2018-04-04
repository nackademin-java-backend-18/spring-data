package se.coredev.sdj.repository.data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    protected Department() {
    }

    public Department(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Name:%s", id, name);
    }
}
