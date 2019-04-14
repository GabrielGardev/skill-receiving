package p04_WorkForce.Models.Employees;

public class PartTimeEmployee extends BasicEmployee {
    private static final int PART_TIME_EMPLOYEE_WORKHOURS = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_EMPLOYEE_WORKHOURS);
    }
}
