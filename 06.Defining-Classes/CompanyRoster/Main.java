package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<Employee>> employeeMap = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Employee employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[2]);
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    employee.setEmail(input[4]);
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                }
            }
            if (input.length == 6) {
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            }
            List<Employee> depEmployees = new ArrayList<>();
            if (employeeMap.containsKey(input[3])) {
                depEmployees = employeeMap.get(input[3]);
            }
            depEmployees.add(employee);
            employeeMap.put(input[3], depEmployees);
        }
        Map.Entry<String, List<Employee>> bestDepartment = employeeMap.entrySet().stream().sorted((o1, o2) -> {
            double sum1 = 0.0;
            double sum2 = 0.0;
            for (Employee entry : o1.getValue()) {
                sum1 += entry.getSalary();
            }
            for (Employee entry : o2.getValue()) {
                sum2 += entry.getSalary();
            }
            return Double.compare(sum2, sum1);
        }).findFirst().get();
        System.out.printf("Highest Average Salary: %s%n", bestDepartment.getKey());
        bestDepartment.getValue().stream().sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()))
                        .forEach(o -> System.out.printf("%s %.2f %s %d%n", o.getName(), o.getSalary(), o.getEmail(), o.getAge()));

    }
}
