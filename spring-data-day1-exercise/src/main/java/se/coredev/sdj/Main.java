package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.coredev.sdj.repository.data.Department;
import se.coredev.sdj.repository.data.Employee;
import se.coredev.sdj.repository.data.ParkingSpot;
import se.coredev.sdj.repository.data.Room;
import se.coredev.sdj.service.ApplicationService;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("se.coredev.sdj");
            context.refresh();

            ApplicationService service = context.getBean(ApplicationService.class);

            Department department = service.addDepartment(new Department("Development"));
            Room room = service.addRoom(new Room("The Central"));
            ParkingSpot parkingSpot = service.addParkingSpot(new ParkingSpot("A-15"));
            Employee employee = service.addEmployee(new Employee("Luke", "Skywalker", "1001", department, parkingSpot, room));

            service.employeesAtDepartment(department).forEach(System.out::println);

        }
    }

}
