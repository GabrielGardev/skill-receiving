package P02_Company_Roster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee employee = new Employee(name, salary, position, department);

            if (line.length > 4) {
                try {
                    int age = Integer.parseInt(line[4]);
                    employee.setAge(age);
                    employee.setEmail("n/a");
                } catch (Exception e) {
                    String email = line[4];
                    employee.setEmail(email);
                    employee.setAge(-1);
                }

                if (line.length == 6) {
                    int age = Integer.parseInt(line[5]);
                    employee.setAge(age);
                }
            } else {
                employee.setAge(-1);
                employee.setEmail("n/a");
            }

            Department existingDepartment = departments.stream()
                    .filter(x -> x.getName().equals(department))
                    .findFirst()
                    .orElse(null);

            if (existingDepartment == null){
                Department currentDepartment = new Department(department, new ArrayList<>());
                currentDepartment.addEmployee(employee);
                departments.add(currentDepartment);
            }else {
                existingDepartment.addEmployee(employee);
            }
        }
        departments = departments.stream().sorted((x1, x2) -> {

                    List<Double> avgList1 = new ArrayList<>();
                    List<Double> avgList2 = new ArrayList<>();

                    x1.getEmployees().forEach(x -> avgList1.add(x.getSalary()));
                    x2.getEmployees().forEach(x -> avgList2.add(x.getSalary()));

                    double avg1 = avgList1.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double avg2 = avgList2.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

                    return Double.compare(avg2, avg1);
                }
        ).collect(Collectors.toList());

        Department best = departments.get(0);

        System.out.printf("Highest Average Salary: %s%n", best.getName());

        best.getEmployees().stream().sorted((x1, x2) -> Double.compare(x2.getSalary(), x1.getSalary())).forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
