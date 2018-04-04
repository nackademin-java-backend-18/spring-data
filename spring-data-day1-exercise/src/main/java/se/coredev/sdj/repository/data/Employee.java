package se.coredev.sdj.repository.data;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String employeeNumber;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Room room;

    @OneToOne
    @JoinColumn(unique = true)
    private ParkingSpot parkingSpot;

    protected Employee() {
    }

    public Employee(String firstName, String lastName, String employeeNumber, Department department, ParkingSpot parkingSpot, Room room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.parkingSpot = parkingSpot;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public Room getRoom() {
        return room;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, First name:%s, Last name:%s, Employee number:%s, Department:%s, Room:%s",
                id, firstName, lastName, employeeNumber, department, room);
    }
}