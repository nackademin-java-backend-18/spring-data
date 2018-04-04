package se.coredev.sdj.repository.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    private Collection<Employee> employees;

    protected Room() {
    }

    public Room(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Number:%s", id, number);
    }
}
