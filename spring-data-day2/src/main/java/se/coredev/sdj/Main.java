package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import se.coredev.sdj.data.Address;
import se.coredev.sdj.data.Employee;
import se.coredev.sdj.repository.EmployeeRepository;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("se.coredev.sdj");
            context.refresh();

            EmployeeRepository repository = context.getBean(EmployeeRepository.class);

            Page<Employee> result = repository.searchEmployeeByZip("Zip", PageRequest.of(0, 4));

            // Loop result and request next page
			while(result.hasNext()) {
				System.out.println("--------- Page " + result.getNumber() + " ----------");
				result.forEach(System.out::println);
				result = repository.searchEmployeeByZip("Zip5", result.nextPageable());
			}
			// To get content from last page
			System.out.println("--------- Page " + result.getNumber() + " ----------");
			result.forEach(System.out::println);
        }
    }

    private static void addData(EmployeeRepository repository, int count) {
        for (int i = 0; i < count; i++) {
            Address address = new Address("street" + i, "postal" + i, "zip" + i);
            Employee employee = new Employee("firstName" + i, "lastName" + i, address);
            repository.save(employee);
        }
    }

}
