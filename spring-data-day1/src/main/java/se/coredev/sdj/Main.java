package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.coredev.sdj.data.Address;
import se.coredev.sdj.data.Employee;
import se.coredev.sdj.repository.EmployeeRepository;
import se.coredev.sdj.service.EmployeeService;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("se.coredev.sdj");
            context.refresh();

            EmployeeRepository repository = context.getBean(EmployeeRepository.class);
//            repository.save(new Employee("Luke", "Skywalker", new Address("Street1", "Postal1", "Zip1")));
//            repository.save(new Employee("Leia", "Skywalker", new Address("Street1", "Postal1", "Zip1")));
//            repository.save(new Employee("Han", "Solo", new Address("Street2", "Postal1", "Zip2")));

            repository.findByAddressZip("Zip1").forEach(System.out::println);

        }
    }

}
