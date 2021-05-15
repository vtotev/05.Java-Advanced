package ExamPreparation.Openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void add(Employee employee) {
        if (employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }
    public Employee getOldestEmployee() {
        return employees.stream().sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge())).findFirst().get();
    }
    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().get();
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery " + name + ":");
        for (Employee empl : employees) {
            sb.append(System.lineSeparator());
            sb.append(empl.toString());
        }
        return sb.toString();
    }
}
