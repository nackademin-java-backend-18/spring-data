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

            String zip = "Zip2";
            Page<Employee> result = repository.searchEmployeeByZip(zip, PageRequest.of(0, 4));

            // Loop result and request next page
			while(result.hasNext()) {
                printResult(result);
                result = repository.searchEmployeeByZip(zip, result.nextPageable());
                // If this is the last page just print result
				if(result.isLast()) {
                   printResult(result);
                }
			}
        }
    }

    private static void printResult(Page<Employee> page) {
        String header = getPageHeaderString(page);
        System.out.println(header);
        page.forEach(System.out::println);
    }

    private static String getPageHeaderString(Page<Employee> page) {
        return String.format("--- Page:%s of %s ---", (page.getNumber() + 1), page.getTotalPages());
    }

    private static void addData(EmployeeRepository repository, int count) {
        for (int i = 0; i < count; i++) {
            Address address = new Address("street" + i, "postal" + i, "zip" + i);
            Employee employee = new Employee("firstName" + i, "lastName" + i, address);
            repository.save(employee);
        }
    }

}
