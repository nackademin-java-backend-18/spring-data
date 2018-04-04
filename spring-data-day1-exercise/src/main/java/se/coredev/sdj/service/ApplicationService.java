package se.coredev.sdj.service;

import org.springframework.stereotype.Component;
import se.coredev.sdj.repository.data.Department;
import se.coredev.sdj.repository.data.Employee;
import se.coredev.sdj.repository.data.ParkingSpot;
import se.coredev.sdj.repository.data.Room;
import se.coredev.sdj.repository.DepartmentRepository;
import se.coredev.sdj.repository.EmployeeRepository;
import se.coredev.sdj.repository.ParkingSpotRepository;
import se.coredev.sdj.repository.RoomRepository;

import java.util.List;

@Component
public final class ApplicationService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final RoomRepository roomRepository;

    public ApplicationService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
                              ParkingSpotRepository parkingSpotRepository, RoomRepository roomRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.roomRepository = roomRepository;
    }

    public Employee addEmployee(Employee employee) {
        // Check if... then store...
        return employeeRepository.save(employee);
    }

    public Department addDepartment(Department department) {
        // Check if... then store...
        return departmentRepository.save(department);
    }

    public Room addRoom(Room room) {
        // Check if... then store...
        return roomRepository.save(room);
    }

    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        // Check if... then store...
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<Employee> employeesAtDepartment(Department department) {
        return employeeRepository.findByDepartmentName(department.getName());
    }

}
