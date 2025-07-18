package mentor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class user
 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(12L, "Naveen", 29, 75000.0),
                new Employee(13L, "Arup", 22, 54000.0),
                new Employee(14L, "bharat", 22, 78000.0),
                new Employee(15L, "jay", 22, 72000.0)
        ));
        
        List<Employee> sort = employees.stream()
        		.sorted(Comparator.comparing(Employee::getEmployeeId))
                .collect(Collectors.toList());
        System.out.println(sort);
        List<Employee> sortName = employees.stream()
        		.sorted(Comparator.comparing(Employee::getEmployeeName))
                .collect(Collectors.toList());
        
        System.out.println("Sorted by Name: " + sortName);
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Employee::getEmployeeName))
                .collect(Collectors.toList());
        System.out.println("Sorted by Name: " + sortedByName);
        List<Employee> sortAge = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by Name: " + sortAge);
        
        
        
        
    }

}
